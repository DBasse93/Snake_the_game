package de.snake.game.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppleTest {

  private Apple apple;

  @BeforeEach
  void setUp() {
    apple = new Apple(new Position(3, 3));
  }

  @Test
  void shouldInitializeWithCorrectPosition() {
    assertEquals(new Position(3, 3), apple.getPosition());
  }

  @Test
  void shouldHaveNonNullPosition() {
    assertNotNull(apple.getPosition());
  }
}
