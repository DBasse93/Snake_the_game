package de.snake.game.model;

/** Represents the four cardinal movement directions for the snake. */
public enum Direction {
  UP, DOWN, LEFT, RIGHT;

  /** Returns true if this direction is the direct opposite of the given direction. */
  public boolean isOpposite(Direction other) {
    return (this == UP && other == DOWN)
        || (this == DOWN && other == UP)
        || (this == LEFT && other == RIGHT)
        || (this == RIGHT && other == LEFT);
  }
}
