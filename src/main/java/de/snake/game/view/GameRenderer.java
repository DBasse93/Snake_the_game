package de.snake.game.view;

import de.snake.game.model.Apple;
import de.snake.game.model.GameBoard;
import de.snake.game.model.ScoreManager;
import de.snake.game.model.Snake;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** Renders the snake, apple, score, and game-over overlay onto a JavaFX canvas. */
public class GameRenderer {

  private static final Logger logger = LogManager.getLogger(GameRenderer.class);

  private final GameBoard board;
  private final Snake snake;
  private final Apple apple;
  private final ScoreManager scoreManager;
  private final Canvas canvas;
  private boolean gameOver;

  /** Creates a new GameRenderer and initialises the canvas to fit the given board. */
  @SuppressFBWarnings("EI_EXPOSE_REP2")
  public GameRenderer(GameBoard board, Snake snake, Apple apple, ScoreManager scoreManager) {
    this.board = board;
    this.snake = snake;
    this.apple = apple;
    this.scoreManager = scoreManager;
    this.canvas = new Canvas(
        (double) board.getWidth() * board.getCellSize(),
        (double) board.getHeight() * board.getCellSize() + 40);
    this.gameOver = false;
  }

  /** Sets whether the game-over overlay should be shown on the next render. */
  public void setGameOver(boolean gameOver) {
    this.gameOver = gameOver;
  }

  /** Returns a snapshot of the current render state as a RenderData record. */
  public RenderData getRenderData() {
    return new RenderData(
        snake.getHead(),
        snake.getBody(),
        apple.getPosition(),
        scoreManager.getScore(),
        scoreManager.getHighScore(),
        gameOver);
  }

  /** Draws the current game frame including the snake, apple, score, and optional overlay. */
  public void render() {
    logger.debug("Rendering frame");
    GraphicsContext gc = canvas.getGraphicsContext2D();
    final int cell = board.getCellSize();

    // Fill the entire canvas black first to erase the previous frame before drawing the new one
    gc.setFill(Color.BLACK);
    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

    gc.setFill(Color.LIME);
    snake.getBody().forEach(pos ->
        gc.fillRect(pos.getX() * cell + 1, pos.getY() * cell + 1, cell - 2, cell - 2));

    gc.setFill(Color.RED);
    gc.fillOval(
        apple.getPosition().getX() * cell + 2,
        apple.getPosition().getY() * cell + 2,
        cell - 4, cell - 4);

    gc.setFill(Color.WHITE);
    gc.setFont(Font.font(16));
    gc.fillText(
        "Score: " + scoreManager.getScore() + "  High: " + scoreManager.getHighScore(),
        10, (double) board.getHeight() * cell + 25);

    if (gameOver) {
      renderGameOver(gc);
    }
  }

  private void renderGameOver(GraphicsContext gc) {
    double cx = canvas.getWidth() / 2;
    double cy = canvas.getHeight() / 2;

    // Alpha 0.65 dims the board without hiding it completely
    gc.setFill(Color.color(0, 0, 0, 0.65));
    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

    gc.setTextAlign(TextAlignment.CENTER);

    gc.setFill(Color.RED);
    gc.setFont(Font.font("Arial", 48));
    gc.fillText("GAME OVER", cx, cy - 10);

    gc.setFill(Color.WHITE);
    gc.setFont(Font.font("Arial", 18));
    gc.fillText("Score: " + scoreManager.getScore(), cx, cy + 30);

    gc.setFill(Color.LIGHTGRAY);
    gc.setFont(Font.font("Arial", 14));
    gc.fillText("Druecke eine Taste zum Neustart", cx, cy + 58);

    gc.setTextAlign(TextAlignment.LEFT);
  }

  /** Returns the JavaFX canvas used for rendering. */
  @SuppressFBWarnings("EI_EXPOSE_REP")
  public Canvas getCanvas() {
    return canvas;
  }
}
