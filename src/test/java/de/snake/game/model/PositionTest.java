package de.snake.game.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class PositionTest {

  @Test
  void shouldCreatePositionWithCoordinates() {
    Position position = new Position(3, 5);

    assertEquals(3, position.getX());
    assertEquals(5, position.getY());
  }

  @Test
  void shouldBeEqualWhenCoordinatesAreTheSame() {
    Position a = new Position(3, 5);
    Position b = new Position(3, 5);

    assertEquals(a, b);
  }

  @Test
  void shouldNotBeEqualWhenCoordinatesDiffer() {
    Position a = new Position(3, 5);
    Position b = new Position(4, 5);

    assertNotEquals(a, b);
  }
}
