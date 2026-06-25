package de.snake.game.controller;

import de.snake.game.core.SnakeGame;
import de.snake.game.view.GameRenderer;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import javafx.animation.AnimationTimer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** Drives the game forward at a fixed tick interval using a JavaFX AnimationTimer. */
public class GameLoop extends AnimationTimer {

  private static final Logger logger = LogManager.getLogger(GameLoop.class);
  private static final long TICK_INTERVAL_NS = 200_000_000L;

  private final SnakeGame game;
  private final GameRenderer renderer;
  private long lastTickNanos = -1L;

  @SuppressFBWarnings("EI_EXPOSE_REP2")
  public GameLoop(SnakeGame game, GameRenderer renderer) {
    this.game = game;
    this.renderer = renderer;
  }

  @Override
  public void handle(long now) {
    tick(now);
  }

  /** Advances the game by one tick if enough time has elapsed since the last tick. */
  public void tick(long nowNanos) {
    if (lastTickNanos < 0) {
      lastTickNanos = nowNanos;
      return;
    }
    if (nowNanos - lastTickNanos >= TICK_INTERVAL_NS) {
      lastTickNanos = nowNanos;
      logger.debug("Game tick");
      game.tick();
      renderer.render();
    }
  }
}
