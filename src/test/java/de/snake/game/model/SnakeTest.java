package de.snake.game.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SnakeTest {

  private Snake snake;

  @BeforeEach
  void setUp() {
    snake = new Snake(new Position(5, 5), Direction.RIGHT);
  }

  @Test
  void shouldInitializeWithCorrectHeadPosition() {
    assertEquals(new Position(5, 5), snake.getHead());
  }

  @Test
  void shouldMoveRightOnTick() {
    snake.move();

    assertEquals(new Position(6, 5), snake.getHead());
  }

  @Test
  void shouldMoveUpOnTick() {
    snake.setDirection(Direction.UP);
    snake.move();

    assertEquals(new Position(5, 4), snake.getHead());
  }

  @Test
  void shouldGrowAfterEatingApple() {
    int lengthBefore = snake.getBody().size();
    snake.grow();
    snake.move();

    assertEquals(lengthBefore + 1, snake.getBody().size());
  }

  @Test
  void shouldNotChangeDirectionToOpposite() {
    snake.setDirection(Direction.LEFT);

    assertEquals(Direction.RIGHT, snake.getDirection());
  }

  @Test
  void shouldContainHeadInBody() {
    assertTrue(snake.getBody().contains(snake.getHead()));
  }

  @Test
  void shouldResetHeadToStartPosition() {
    snake.move();
    snake.reset();

    assertEquals(new Position(5, 5), snake.getHead());
  }

  @Test
  void shouldResetDirectionToStartDirection() {
    snake.setDirection(Direction.UP);
    snake.reset();

    assertEquals(Direction.RIGHT, snake.getDirection());
  }

  @Test
  void shouldResetBodyLengthToOne() {
    snake.grow();
    snake.move();
    snake.reset();

    assertEquals(1, snake.getBody().size());
  }
}
