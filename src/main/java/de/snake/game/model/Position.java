package de.snake.game.model;

import java.util.Objects;

/** Represents a 2D grid position with x and y coordinates. */
public class Position {

  // Named px/py rather than x/y to satisfy the CheckStyle MemberName pattern requirement
  private final int px;
  private final int py;

  public Position(int x, int y) {
    this.px = x;
    this.py = y;
  }

  public int getX() {
    return px;
  }

  public int getY() {
    return py;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    // instanceof check guards the cast and handles null in one step (per Effective Java)
    if (!(o instanceof Position)) {
      return false;
    }
    Position position = (Position) o;
    return px == position.px && py == position.py;
  }

  @Override
  public int hashCode() {
    return Objects.hash(px, py);
  }
}
