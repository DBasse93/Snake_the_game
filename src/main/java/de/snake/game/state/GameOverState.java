package de.snake.game.state;

import de.snake.game.controller.Command;
import de.snake.game.core.SnakeGame;

public class GameOverState implements GameState {

  private final SnakeGame game;

  public GameOverState(SnakeGame game) {
    this.game = game;
  }

  @Override
  public void handleTick() {
  }

  @Override
  public void handleInput(Command command) {
    game.setState(new InitState(game));
  }
}
