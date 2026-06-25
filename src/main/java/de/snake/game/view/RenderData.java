package de.snake.game.view;

import de.snake.game.model.Position;
import java.util.List;

/** Immutable snapshot of game state passed to the renderer each frame. */
public record RenderData(
    Position snakeHead,
    List<Position> snakeBody,
    Position applePosition,
    int score,
    int highScore,
    boolean gameOver
) {
  public RenderData {
    snakeBody = List.copyOf(snakeBody);
  }
}
