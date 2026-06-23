package de.snake.game.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.snake.game.model.Direction;
import de.snake.game.model.Position;
import de.snake.game.model.Snake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoveCommandTest {

  @Test
  void shouldSetDirectionUpWhenMoveUpCommandExecuted() {
    Snake snake = new Snake(new Position(5, 5), Direction.LEFT);
    new MoveUpCommand().execute(snake);

    assertEquals(Direction.UP, snake.getDirection());
  }

  @Test
  void shouldSetDirectionDownWhenMoveDownCommandExecuted() {
    Snake snake = new Snake(new Position(5, 5), Direction.LEFT);
    new MoveDownCommand().execute(snake);

    assertEquals(Direction.DOWN, snake.getDirection());
  }

  @Test
  void shouldSetDirectionLeftWhenMoveLeftCommandExecuted() {
    Snake snake = new Snake(new Position(5, 5), Direction.UP);
    new MoveLeftCommand().execute(snake);

    assertEquals(Direction.LEFT, snake.getDirection());
  }

  @Test
  void shouldSetDirectionRightWhenMoveRightCommandExecuted() {
    Snake snake = new Snake(new Position(5, 5), Direction.UP);
    new MoveRightCommand().execute(snake);

    assertEquals(Direction.RIGHT, snake.getDirection());
  }
}
