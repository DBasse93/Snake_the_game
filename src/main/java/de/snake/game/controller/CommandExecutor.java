package de.snake.game.controller;

import de.snake.game.model.Snake;
import java.util.LinkedList;
import java.util.Queue;

public class CommandExecutor {

  private final Queue<Command> queue;

  public CommandExecutor() {
    this.queue = new LinkedList<>();
  }

  public void addCommand(Command command) {
    queue.add(command);
  }

  public void executeNext(Snake snake) {
    if (!queue.isEmpty()) {
      queue.poll().execute(snake);
    }
  }
}
