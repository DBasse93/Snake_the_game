package de.snake.game.core;

import de.snake.game.controller.CollisionDetector;
import de.snake.game.controller.Command;
import de.snake.game.controller.CommandExecutor;
import de.snake.game.model.Apple;
import de.snake.game.model.GameBoard;
import de.snake.game.model.Snake;
import de.snake.game.state.GameState;
import de.snake.game.state.InitState;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SnakeGame {

  private static final Logger logger = LogManager.getLogger(SnakeGame.class);

  private GameState currentState;
  private final Snake snake;
  private final GameBoard board;
  private final Apple apple;
  private final CommandExecutor executor;
  private final CollisionDetector collisionDetector;

  @SuppressFBWarnings("EI_EXPOSE_REP2")
  public SnakeGame(Snake snake, GameBoard board, Apple apple,
      CommandExecutor executor, CollisionDetector collisionDetector) {
    this.snake = snake;
    this.board = board;
    this.apple = apple;
    this.executor = executor;
    this.collisionDetector = collisionDetector;
    this.currentState = new InitState(this);
  }

  public void setState(GameState state) {
    this.currentState = state;
  }

  public void tick() {
    currentState.handleTick();
  }

  public void runStep() {
    executor.executeNext(snake);
    snake.move();
    collisionDetector.check(snake, board);
    collisionDetector.checkApple(snake, apple);
    logger.debug("Game step executed");
  }

  public void handleInput(Command command) {
    currentState.handleInput(command);
  }
}
