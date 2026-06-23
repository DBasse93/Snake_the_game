package de.snake.game.state;

import de.snake.game.controller.Command;
import de.snake.game.core.SnakeGame;

public class RunningState implements GameState {

  private final SnakeGame game;

  public RunningState(SnakeGame game) {
    this.game = game;
  }

  @Override
  public void handleTick() {
    game.tick();
  }

  @Override
  public void handleInput(Command command) {
    command.execute(null);
  }
}
