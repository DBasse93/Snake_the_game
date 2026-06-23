package de.snake.game.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class InputHandlerTest {

  @Mock
  private CommandExecutor executor;

  private InputHandler inputHandler;

  @BeforeEach
  void setUp() {
    inputHandler = new InputHandler(executor);
  }

  @Test
  void shouldAddMoveUpCommandWhenUpKeyPressed() {
    inputHandler.handleKeyCode(KeyCode.UP);

    verify(executor).addCommand(any(MoveUpCommand.class));
  }

  @Test
  void shouldAddMoveDownCommandWhenDownKeyPressed() {
    inputHandler.handleKeyCode(KeyCode.DOWN);

    verify(executor).addCommand(any(MoveDownCommand.class));
  }

  @Test
  void shouldAddMoveLeftCommandWhenLeftKeyPressed() {
    inputHandler.handleKeyCode(KeyCode.LEFT);

    verify(executor).addCommand(any(MoveLeftCommand.class));
  }

  @Test
  void shouldAddMoveRightCommandWhenRightKeyPressed() {
    inputHandler.handleKeyCode(KeyCode.RIGHT);

    verify(executor).addCommand(any(MoveRightCommand.class));
  }
}
