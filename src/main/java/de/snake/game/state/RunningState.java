package de.snake.game.state;

import de.snake.game.controller.Command;
import de.snake.game.core.SnakeGame;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/** Active gameplay state; delegates each tick to the game's runStep method. */
public class RunningState implements GameState {

  private final SnakeGame game;

  @SuppressFBWarnings("EI_EXPOSE_REP2")
  public RunningState(SnakeGame game) {
    this.game = game;
  }

  @Override
  public void handleTick() {
    game.runStep();
  }

  @Override
  public void handleInput(Command command) {
    // movement handled by CommandExecutor via InputHandler
  }
}
