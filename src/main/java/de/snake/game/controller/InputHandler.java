package de.snake.game.controller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class InputHandler {

  private final CommandExecutor executor;

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
