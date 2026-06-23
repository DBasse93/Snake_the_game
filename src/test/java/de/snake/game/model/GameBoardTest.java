package de.snake.game.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameBoardTest {

  private GameBoard board;

  @BeforeEach
  void setUp() {
    board = new GameBoard(20, 20, 30);
  }

  @Test
  void shouldReturnCorrectWidth() {
    assertEquals(20, board.getWidth());
  }

  @Test
  void shouldReturnCorrectHeight() {
    assertEquals(20, board.getHeight());
  }

  @Test
  void shouldReturnCorrectCellSize() {
    assertEquals(30, board.getCellSize());
  }

  @Test
  void shouldReturnTrueWhenPositionIsInsideBoard() {
    assertTrue(board.isInsideBounds(new Position(5, 5)));
  }

  @Test
  void shouldReturnFalseWhenPositionIsOutsideBoard() {
    assertFalse(board.isInsideBounds(new Position(20, 5)));
  }

  @Test
  void shouldReturnFalseWhenPositionIsNegative() {
    assertFalse(board.isInsideBounds(new Position(-1, 5)));
  }
}
