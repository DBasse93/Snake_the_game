package de.snake.game.controller;

import de.snake.game.model.Direction;
import de.snake.game.model.Snake;

/** Command that sets the snake's direction to LEFT. */
public class MoveLeftCommand implements Command {

  @Override
  public void execute(Snake snake) {
    snake.setDirection(Direction.LEFT);
  }
}
