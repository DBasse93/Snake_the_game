package de.snake.game.controller;

import de.snake.game.event.AppleEatenEvent;
import de.snake.game.event.CollisionEvent;
import de.snake.game.event.EventBus;
import de.snake.game.model.Apple;
import de.snake.game.model.GameBoard;
import de.snake.game.model.Snake;

/** Detects wall and self-collisions as well as apple-eating events for the snake. */
public class CollisionDetector {

  private final EventBus eventBus;

  public CollisionDetector(EventBus eventBus) {
    this.eventBus = eventBus;
  }

  /** Checks for wall or self-collision and publishes a CollisionEvent if detected. */
  public void check(Snake snake, GameBoard board) {
    if (!board.isInsideBounds(snake.getHead())) {
      eventBus.publish(new CollisionEvent());
      return;
    }
    if (isBodyCollision(snake)) {
      eventBus.publish(new CollisionEvent());
    }
  }

  /** Checks if the snake's head overlaps the apple and publishes an AppleEatenEvent if so. */
  public void checkApple(Snake snake, Apple apple) {
    if (snake.getHead().equals(apple.getPosition())) {
      eventBus.publish(new AppleEatenEvent());
    }
  }

  private boolean isBodyCollision(Snake snake) {
    // skip(1) skips the head itself (index 0) — only tail segments can collide with the head
    return snake.getBody().stream()
        .skip(1)
        .anyMatch(segment -> segment.equals(snake.getHead()));
  }
}
