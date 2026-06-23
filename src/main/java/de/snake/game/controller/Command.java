package de.snake.game.controller;

import de.snake.game.model.Snake;

public interface Command {
  void execute(Snake snake);
}
