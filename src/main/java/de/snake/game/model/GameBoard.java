package de.snake.game.model;

public class GameBoard {

  private final int width;
  private final int height;
  private final int cellSize;

  public GameBoard(int width, int height, int cellSize) {
    this.width = width;
    this.height = height;
    this.cellSize = cellSize;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getCellSize() {
    return cellSize;
  }

  public boolean isInsideBounds(Position position) {
    return position.getX() >= 0
        && position.getX() < width
        && position.getY() >= 0
        && position.getY() < height;
  }
}
