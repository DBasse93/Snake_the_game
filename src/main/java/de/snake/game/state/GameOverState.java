package de.snake.game.state;

import de.snake.game.controller.Command;
import de.snake.game.core.SnakeGame;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/** Game-over state shown after a collision; transitions back to InitState on any input. */
public class GameOverState implements GameState {

  private final SnakeGame game;

  @SuppressFBWarnings("EI_EXPOSE_REP2")
  public GameOverState(SnakeGame game) {
    this.game = game;
  }

  @Override
  public void handleTick() {
  }

  @Override
  public void handleInput(Command command) {
    // Returns to InitState; a second key press is needed to actually start the game
    game.setState(new InitState(game));
  }
}
