package de.snake.game.core;

import de.snake.game.controller.Command;
import de.snake.game.state.GameState;

public class SnakeGame {

  private GameState currentState;

  public SnakeGame() {
    this.currentState = new de.snake.game.state.InitState(this);
  }

  public void setState(GameState state) {
    this.currentState = state;
  }

  public void tick() {
    currentState.handleTick();
  }

  public void handleInput(Command command) {
    currentState.handleInput(command);
  }
}
