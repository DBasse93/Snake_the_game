package de.snake.game.controller;

import de.snake.game.model.Snake;
import java.util.LinkedList;
import java.util.Queue;

/** Queues and executes commands one at a time against the snake. */
public class CommandExecutor {

  // Queue (FIFO) guarantees commands are processed in the order they were issued
  private final Queue<Command> queue;

  public CommandExecutor() {
    this.queue = new LinkedList<>();
  }

  /** Adds a command to the execution queue. */
  public void addCommand(Command command) {
    queue.add(command);
  }

  /** Executes the next queued command against the given snake, if any. */
  public void executeNext(Snake snake) {
    if (!queue.isEmpty()) {
      // Only one command per tick prevents multiple direction changes within a single frame
      queue.poll().execute(snake);
    }
  }
}
