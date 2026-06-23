package de.snake.game.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScoreManagerTest {

  private ScoreManager scoreManager;

  @BeforeEach
  void setUp() {
    scoreManager = new ScoreManager();
  }

  @Test
  void shouldStartWithZeroScore() {
    assertEquals(0, scoreManager.getScore());
  }

  @Test
  void shouldIncreaseScoreByFixedAmount() {
    scoreManager.increase();

    assertEquals(10, scoreManager.getScore());
  }

  @Test
  void shouldIncreaseScoreMultipleTimes() {
    scoreManager.increase();
    scoreManager.increase();
    scoreManager.increase();

    assertEquals(30, scoreManager.getScore());
  }

  @Test
  void shouldResetScoreToZero() {
    scoreManager.increase();
    scoreManager.reset();

    assertEquals(0, scoreManager.getScore());
  }

  @Test
  void shouldUpdateHighScoreWhenScoreExceedsIt() {
    scoreManager.increase();
    scoreManager.reset();

    assertEquals(10, scoreManager.getHighScore());
  }

  @Test
  void shouldNotUpdateHighScoreWhenScoreIsLower() {
    scoreManager.increase();
    scoreManager.increase();
    scoreManager.reset();
    scoreManager.increase();
    scoreManager.reset();

    assertEquals(20, scoreManager.getHighScore());
  }
}
