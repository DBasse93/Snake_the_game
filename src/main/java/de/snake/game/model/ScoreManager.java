package de.snake.game.model;

public class ScoreManager {

  private static final int SCORE_INCREMENT = 10;

  private int score;
  private int highScore;

  public ScoreManager() {
    this.score = 0;
    this.highScore = 0;
  }

  public void increase() {
    score += SCORE_INCREMENT;
  }

  public void reset() {
    if (score > highScore) {
      highScore = score;
    }
    score = 0;
  }

  public int getScore() {
    return score;
  }

  public int getHighScore() {
    return highScore;
  }
}
