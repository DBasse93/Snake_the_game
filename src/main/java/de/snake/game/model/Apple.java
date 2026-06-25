package de.snake.game.model;

/** Represents the apple that the snake can eat to grow and score points. */
public class Apple {

  private Position position;

  public Apple(Position position) {
    this.position = position;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }
}
