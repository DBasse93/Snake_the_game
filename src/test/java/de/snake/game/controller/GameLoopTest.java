package de.snake.game.controller;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import de.snake.game.core.SnakeGame;
import de.snake.game.view.GameRenderer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GameLoopTest {

  @Mock
  private SnakeGame game;

  @Mock
  private GameRenderer renderer;

  private GameLoop gameLoop;

  @BeforeEach
  void setUp() {
    gameLoop = new GameLoop(game, renderer);
  }

  @Test
  void shouldNotTickBeforeIntervalPasses() {
    gameLoop.tick(0L);
    gameLoop.tick(100_000_000L);

    verify(game, never()).tick();
  }

  @Test
  void shouldTickAfterIntervalPasses() {
    gameLoop.tick(0L);
    gameLoop.tick(200_000_000L);

    verify(game, times(1)).tick();
  }

  @Test
  void shouldCallRenderAfterTick() {
    gameLoop.tick(0L);
    gameLoop.tick(200_000_000L);

    verify(renderer, times(1)).render();
  }
}
