package de.snake.game.model;

import java.util.LinkedList;
import java.util.List;

public class Snake {

  private final LinkedList<Position> body;
  private Direction direction;
  private boolean growing;

  public Snake(Position startPosition, Direction startDirection) {
    this.body = new LinkedList<>();
    this.body.add(startPosition);
    this.direction = startDirection;
    this.growing = false;
  }

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

  public void grow() {
    growing = true;
  }

  public void setDirection(Direction newDirection) {
    if (!direction.isOpposite(newDirection)) {
      direction = newDirection;
    }
  }

  public Position getHead() {
    return body.getFirst();
  }

  public List<Position> getBody() {
    return body;
  }

  public Direction getDirection() {
    return direction;
  }
}
