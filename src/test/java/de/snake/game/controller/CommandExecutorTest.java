package de.snake.game.controller;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import de.snake.game.model.Snake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CommandExecutorTest {

  @Mock
  private Snake snake;

  @Mock
  private Command command;

  private CommandExecutor executor;

  @BeforeEach
  void setUp() {
    executor = new CommandExecutor();
  }

  @Test
  void shouldExecuteCommandWhenQueueIsNotEmpty() {
    executor.addCommand(command);
    executor.executeNext(snake);

    verify(command, times(1)).execute(snake);
  }

  @Test
  void shouldNotExecuteWhenQueueIsEmpty() {
    executor.executeNext(snake);

    verify(command, never()).execute(snake);
  }

  @Test
  void shouldExecuteOnlyOneCommandPerTick() {
    executor.addCommand(command);
    executor.addCommand(command);
    executor.executeNext(snake);

    verify(command, times(1)).execute(snake);
  }
}
