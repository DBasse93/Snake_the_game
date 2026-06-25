package de.snake.game.state;

import de.snake.game.controller.Command;
import de.snake.game.core.SnakeGame;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/** Initial waiting state before the game starts; transitions to RunningState on any input. */
public class InitState implements GameState {

  private final SnakeGame game;

  @SuppressFBWarnings("EI_EXPOSE_REP2")
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
