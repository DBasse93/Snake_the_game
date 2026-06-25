package de.snake.game.model;

/** Represents the four cardinal movement directions for the snake. */
public enum Direction {
  UP, DOWN, LEFT, RIGHT;

  /** Returns true if this direction is the direct opposite of the given direction. */
  public boolean isOpposite(Direction other) {
    // Used by Snake.setDirection to block 180-degree turns — moving into the body is instant death
    return (this == UP && other == DOWN)
        || (this == DOWN && other == UP)
        || (this == LEFT && other == RIGHT)
        || (this == RIGHT && other == LEFT);
  }
}
