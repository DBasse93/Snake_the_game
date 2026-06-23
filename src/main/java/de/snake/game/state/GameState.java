package de.snake.game.state;

import de.snake.game.controller.Command;

public interface GameState {
  void handleTick();
  void handleInput(Command command);
}
