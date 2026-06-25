package de.snake.game.model;

/** Represents the game board dimensions and boundary logic. */
public class GameBoard {

  private final int width;
  private final int height;
  private final int cellSize;

  /** Creates a new game board with the given width, height, and cell size. */
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

  /** Returns true if the given position is within the board boundaries. */
  public boolean isInsideBounds(Position position) {
    // All four edges are checked: left (x>=0), right (x<width), top (y>=0), bottom (y<height)
    return position.getX() >= 0
        && position.getX() < width
        && position.getY() >= 0
        && position.getY() < height;
  }
}
