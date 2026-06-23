package de.snake.game.controller;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class InputHandler {

  private final CommandExecutor executor;

  @SuppressFBWarnings("EI_EXPOSE_REP2")
  public InputHandler(CommandExecutor executor) {
    this.executor = executor;
  }

  public void handleKeyEvent(KeyEvent event) {
    handleKeyCode(event.getCode());
  }

  void handleKeyCode(KeyCode code) {
    switch (code) {
      case UP -> executor.addCommand(new MoveUpCommand());
      case DOWN -> executor.addCommand(new MoveDownCommand());
      case LEFT -> executor.addCommand(new MoveLeftCommand());
      case RIGHT -> executor.addCommand(new MoveRightCommand());
      default -> { }
    }
  }
}
