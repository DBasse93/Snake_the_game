package de.snake.game.state;

import de.snake.game.controller.Command;
import de.snake.game.core.SnakeGame;

public class InitState implements GameState {

  private final SnakeGame game;

  public InitState(SnakeGame game) {
    this.game = game;
  }

  @Override
  public void handleTick() {
  }

  @Override
  public void handleInput(Command command) {
    game.setState(new RunningState(game));
  }
}
