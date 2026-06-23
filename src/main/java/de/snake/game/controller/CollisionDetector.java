package de.snake.game.controller;

import de.snake.game.event.AppleEatenEvent;
import de.snake.game.event.CollisionEvent;
import de.snake.game.event.EventBus;
import de.snake.game.model.Apple;
import de.snake.game.model.GameBoard;
import de.snake.game.model.Snake;

public class CollisionDetector {

  private final EventBus eventBus;

  public CollisionDetector(EventBus eventBus) {
    this.eventBus = eventBus;
  }

  public void check(Snake snake, GameBoard board) {
    if (!board.isInsideBounds(snake.getHead())) {
      eventBus.publish(new CollisionEvent());
      return;
    }
    if (isBodyCollision(snake)) {
      eventBus.publish(new CollisionEvent());
    }
  }

  public void checkApple(Snake snake, Apple apple) {
    if (snake.getHead().equals(apple.getPosition())) {
      eventBus.publish(new AppleEatenEvent());
    }
  }

  private boolean isBodyCollision(Snake snake) {
    return snake.getBody().stream()
        .skip(1)
        .anyMatch(segment -> segment.equals(snake.getHead()));
  }
}
