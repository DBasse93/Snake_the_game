package de.snake.game.state;

import de.snake.game.controller.Command;

/** State interface for the State pattern controlling game phase transitions. */
public interface GameState {

  void handleTick();

  void handleInput(Command command);
}
