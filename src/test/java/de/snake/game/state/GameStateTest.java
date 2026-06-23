package de.snake.game.state;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import de.snake.game.controller.Command;
import de.snake.game.core.SnakeGame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GameStateTest {

  @Mock
  private SnakeGame game;

  @Mock
  private Command command;

  @Test
  void shouldTransitionToRunningStateWhenStartCalledInInitState() {
    InitState initState = new InitState(game);

    initState.handleInput(command);

    verify(game).setState(any(RunningState.class));
  }

  @Test
  void shouldDelegateTickToGameWhenRunningState() {
    RunningState runningState = new RunningState(game);

    runningState.handleTick();

    verify(game).runStep();
  }

  @Test
  void shouldTransitionToInitStateWhenRestartCalledInGameOverState() {
    GameOverState gameOverState = new GameOverState(game);

    gameOverState.handleInput(command);

    verify(game).setState(any(InitState.class));
  }
}
