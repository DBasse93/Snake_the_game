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

    body.addFirst(newHead);

    if (growing) {
      growing = false;
    } else {
      body.removeLast();
    }
  }

  /** Flags the snake to grow on its next move. */
  public void grow() {
    growing = true;
  }

  /** Sets the snake's direction, ignoring the change if it would reverse the snake. */
  public void setDirection(Direction newDirection) {
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
    return java.util.Collections.unmodifiableList(body);
  }

  /** Returns the current movement direction of the snake. */
  public Direction getDirection() {
    return direction;
  }
}
