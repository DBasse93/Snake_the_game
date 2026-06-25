package de.snake.game.controller;

import de.snake.game.model.Direction;
import de.snake.game.model.Snake;

/** Command that sets the snake's direction to RIGHT. */
public class MoveRightCommand implements Command {

  @Override
  public void execute(Snake snake) {
    snake.setDirection(Direction.RIGHT);
  }
}
