package de.snake.game.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import de.snake.game.event.AppleEatenEvent;
import de.snake.game.event.CollisionEvent;
import de.snake.game.event.EventBus;
import de.snake.game.model.Apple;
import de.snake.game.model.Direction;
import de.snake.game.model.GameBoard;
import de.snake.game.model.Position;
import de.snake.game.model.Snake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CollisionDetectorTest {

  @Mock
  private EventBus eventBus;

  private GameBoard board;
  private CollisionDetector detector;

  @BeforeEach
  void setUp() {
    board = new GameBoard(10, 10, 30);
    detector = new CollisionDetector(eventBus);
  }

  @Test
  void shouldPublishCollisionEventWhenSnakeHitsWall() {
    Snake snake = new Snake(new Position(9, 5), Direction.RIGHT);
    snake.move();

    detector.check(snake, board);

    verify(eventBus).publish(any(CollisionEvent.class));
  }

  @Test
  void shouldNotPublishCollisionEventWhenSnakeIsInsideBoard() {
    Snake snake = new Snake(new Position(5, 5), Direction.RIGHT);

    detector.check(snake, board);

    verify(eventBus, never()).publish(any(CollisionEvent.class));
  }

  @Test
  void shouldPublishAppleEatenEventWhenSnakeHeadOnApple() {
    Snake snake = new Snake(new Position(5, 5), Direction.RIGHT);
    Apple apple = new Apple(new Position(5, 5));

    detector.checkApple(snake, apple);

    verify(eventBus).publish(any(AppleEatenEvent.class));
  }

  @Test
  void shouldNotPublishAppleEatenEventWhenSnakeNotOnApple() {
    Snake snake = new Snake(new Position(5, 5), Direction.RIGHT);
    Apple apple = new Apple(new Position(3, 3));

    detector.checkApple(snake, apple);

    verify(eventBus, never()).publish(any(AppleEatenEvent.class));
  }
}
