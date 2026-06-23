package de.snake.game.view;

import de.snake.game.model.Position;
import java.util.List;

public record RenderData(
    Position snakeHead,
    List<Position> snakeBody,
    Position applePosition,
    int score,
    int highScore
) {
  public RenderData {
    snakeBody = List.copyOf(snakeBody);
  }
}
