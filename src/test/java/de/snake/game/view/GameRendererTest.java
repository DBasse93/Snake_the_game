package de.snake.game.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import de.snake.game.model.Apple;
import de.snake.game.model.Direction;
import de.snake.game.model.GameBoard;
import de.snake.game.model.Position;
import de.snake.game.model.ScoreManager;
import de.snake.game.model.Snake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameRendererTest {

  private Snake snake;
  private Apple apple;
  private GameBoard board;
  private ScoreManager scoreManager;
  private GameRenderer renderer;

  @BeforeEach
  void setUp() {
    board = new GameBoard(20, 20, 30);
    snake = new Snake(new Position(10, 10), Direction.RIGHT);
    apple = new Apple(new Position(5, 5));
    scoreManager = new ScoreManager();
    renderer = new GameRenderer(board, snake, apple, scoreManager);
  }

  @Test
  void shouldReturnRenderDataWithCorrectSnakeHead() {
    RenderData data = renderer.getRenderData();

    assertEquals(new Position(10, 10), data.snakeHead());
  }

  @Test
  void shouldReturnRenderDataWithCorrectApplePosition() {
    RenderData data = renderer.getRenderData();

    assertEquals(new Position(5, 5), data.applePosition());
  }

  @Test
  void shouldReturnRenderDataWithCorrectScore() {
    scoreManager.increase();
    RenderData data = renderer.getRenderData();

    assertEquals(10, data.score());
  }

  @Test
  void shouldReturnNonNullRenderData() {
    assertNotNull(renderer.getRenderData());
  }

  @Test
  void shouldReturnGameOverFalseByDefault() {
    assertFalse(renderer.getRenderData().gameOver());
  }

  @Test
  void shouldReturnGameOverTrueAfterSetGameOver() {
    renderer.setGameOver(true);

    assertTrue(renderer.getRenderData().gameOver());
  }
}
