package de.snake.game.core;

import de.snake.game.controller.CollisionDetector;
import de.snake.game.controller.Command;
import de.snake.game.controller.CommandExecutor;
import de.snake.game.model.Apple;
import de.snake.game.model.GameBoard;
import de.snake.game.model.Position;
import de.snake.game.model.ScoreManager;
import de.snake.game.model.Snake;
import de.snake.game.state.GameState;
import de.snake.game.state.InitState;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** Central game coordinator that owns the snake, board, apple, and current game state. */
public class SnakeGame {

  private static final Logger logger = LogManager.getLogger(SnakeGame.class);

  private GameState currentState;
  private final Snake snake;
  private final GameBoard board;
  private final Apple apple;
  private final Position initialApplePosition;
  private final ScoreManager scoreManager;
  private final CommandExecutor executor;
  private final CollisionDetector collisionDetector;

  /** Creates a new SnakeGame with all required components and sets the initial state. */
  @SuppressFBWarnings("EI_EXPOSE_REP2")
  public SnakeGame(Snake snake, GameBoard board, Apple apple, ScoreManager scoreManager,
      CommandExecutor executor, CollisionDetector collisionDetector) {
    this.snake = snake;
    this.board = board;
    this.apple = apple;
    this.initialApplePosition = apple.getPosition();
    this.scoreManager = scoreManager;
    this.executor = executor;
    this.collisionDetector = collisionDetector;
    this.currentState = new InitState(this);
  }

  /** Transitions the game to the given state. */
  public void setState(GameState state) {
    this.currentState = state;
  }

  /** Delegates a tick to the current game state. */
  public void tick() {
    currentState.handleTick();
  }

  /** Executes one full game step: move, collision check, and apple check. */
  public void runStep() {
    // Direction must be updated before move() so the snake moves in the newly requested direction
    executor.executeNext(snake);
    snake.move();
    // Collision checks run after the move so they evaluate the new head position
    collisionDetector.check(snake, board);
    collisionDetector.checkApple(snake, apple);
    logger.debug("Game step executed");
  }

  /** Resets snake, apple, and score to their initial state for a new game. */
  public void reset() {
    snake.reset();
    apple.setPosition(initialApplePosition);
    scoreManager.reset();
    logger.info("Game reset");
  }

  /** Forwards a player input command to the current game state. */
  public void handleInput(Command command) {
    currentState.handleInput(command);
  }
}
