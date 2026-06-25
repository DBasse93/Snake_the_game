package de.snake.game.controller;

import de.snake.game.model.Snake;

/** Command interface for encapsulating a single snake input action. */
public interface Command {
  void execute(Snake snake);
}
