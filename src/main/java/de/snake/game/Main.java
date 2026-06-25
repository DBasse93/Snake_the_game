package de.snake.game;

import de.snake.game.controller.CollisionDetector;
import de.snake.game.controller.CommandExecutor;
import de.snake.game.controller.GameLoop;
import de.snake.game.controller.InputHandler;
import de.snake.game.controller.MoveRightCommand;
import de.snake.game.core.SnakeGame;
import de.snake.game.event.AppleEatenEvent;
import de.snake.game.event.CollisionEvent;
import de.snake.game.event.EventBus;
import de.snake.game.model.Apple;
import de.snake.game.model.Direction;
import de.snake.game.model.GameBoard;
import de.snake.game.model.Position;
import de.snake.game.model.ScoreManager;
import de.snake.game.model.Snake;
import de.snake.game.state.GameOverState;
import de.snake.game.view.GameRenderer;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** JavaFX Application entry point that wires up all game components and starts the game loop. */
public class Main extends Application {

  private static final Logger logger = LogManager.getLogger(Main.class);

  @Override
  public void start(Stage primaryStage) {
    GameBoard board = new GameBoard(20, 20, 30);
    Snake snake = new Snake(new Position(10, 10), Direction.RIGHT);
    Apple apple = new Apple(new Position(5, 15));
    ScoreManager scoreManager = new ScoreManager();
    EventBus eventBus = new EventBus();
    CommandExecutor executor = new CommandExecutor();
    CollisionDetector collisionDetector = new CollisionDetector(eventBus);
    final Random random = new Random();

    SnakeGame game = new SnakeGame(snake, board, apple, executor, collisionDetector);
    GameRenderer renderer = new GameRenderer(board, snake, apple, scoreManager);
    final GameLoop gameLoop = new GameLoop(game, renderer);
    InputHandler inputHandler = new InputHandler(executor);

    eventBus.subscribe(event -> {
      if (event instanceof CollisionEvent) {
        logger.info("Collision — game over");
        game.setState(new GameOverState(game));
        renderer.setGameOver(true);
        renderer.render();
      } else if (event instanceof AppleEatenEvent) {
        snake.grow();
        scoreManager.increase();
        Position newPos;
        do {
          // Retry until the new apple lands on an empty cell, not inside the snake body
          newPos = new Position(
              random.nextInt(board.getWidth()),
              random.nextInt(board.getHeight()));
        } while (snake.getBody().contains(newPos));
        apple.setPosition(newPos);
        logger.info("Apple eaten, score: {}", scoreManager.getScore());
      }
    });

    Scene scene = new Scene(new StackPane(renderer.getCanvas()));
    scene.setOnKeyPressed(keyEvent -> {
      renderer.setGameOver(false);
      // Queue the directional command so it is applied on the next game tick
      inputHandler.handleKeyEvent(keyEvent);
      // Dummy command drives state transitions (Init→Running, GameOver→Init)
      game.handleInput(new MoveRightCommand());
    });

    primaryStage.setTitle("Snake");
    primaryStage.setScene(scene);
    primaryStage.show();

    renderer.render();
    gameLoop.start();
    logger.info("Snake game started");
  }

  public static void main(String[] args) {
    launch(args);
  }
}
