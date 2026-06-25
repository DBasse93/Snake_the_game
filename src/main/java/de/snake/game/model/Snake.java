package de.snake.game.model;

import java.util.LinkedList;
import java.util.List;

/** Represents the snake entity, including its body, direction, and movement logic. */
public class Snake {

  private final LinkedList<Position> body;
  private Direction direction;
  private boolean growing;

  /** Creates a new snake at the given start position moving in the given start direction. */
  public Snake(Position startPosition, Direction startDirection) {
    this.body = new LinkedList<>();
    this.body.add(startPosition);
    this.direction = startDirection;
    this.growing = false;
  }

  /** Moves the snake one cell in its current direction, growing if flagged. */
  public void move() {
    Position head = getHead();
    Position newHead = switch (direction) {
      case UP -> new Position(head.getX(), head.getY() - 1);
      case DOWN -> new Position(head.getX(), head.getY() + 1);
      case LEFT -> new Position(head.getX() - 1, head.getY());
      case RIGHT -> new Position(head.getX() + 1, head.getY());
    };

    // addFirst prepends the new head; the body now has one extra segment at the front
    body.addFirst(newHead);

    if (growing) {
      // Consume the flag after one move so the snake only grows by one cell per apple
      growing = false;
    } else {
      // Drop the tail to maintain length — simulates movement without copying the whole list
      body.removeLast();
    }
  }

  /** Flags the snake to grow on its next move. */
  public void grow() {
    growing = true;
  }

  /** Sets the snake's direction, ignoring the change if it would reverse the snake. */
  public void setDirection(Direction newDirection) {
    // Reversing into the body is an instant collision; the check enforces the game rule
    if (!direction.isOpposite(newDirection)) {
      direction = newDirection;
    }
  }

  /** Returns the current head position of the snake. */
  public Position getHead() {
    return body.getFirst();
  }

  /** Returns an unmodifiable view of the snake's body segments. */
  public List<Position> getBody() {
    // Unmodifiable wrapper prevents callers from accidentally mutating the live body list
    return java.util.Collections.unmodifiableList(body);
  }

  /** Returns the current movement direction of the snake. */
  public Direction getDirection() {
    return direction;
  }
}
