package de.snake.game.model;

/** Tracks the current score and all-time high score for the game session. */
public class ScoreManager {

  private static final int SCORE_INCREMENT = 10;

  private int score;
  private int highScore;

  public ScoreManager() {
    this.score = 0;
    this.highScore = 0;
  }

  /** Increases the current score by the fixed increment amount. */
  public void increase() {
    score += SCORE_INCREMENT;
  }

  /** Resets the current score to zero, updating the high score if needed. */
  public void reset() {
    // highScore must be updated before zeroing score — order matters here
    if (score > highScore) {
      highScore = score;
    }
    score = 0;
  }

  /** Returns the current score. */
  public int getScore() {
    return score;
  }

  /** Returns the all-time high score. */
  public int getHighScore() {
    return highScore;
  }
}
