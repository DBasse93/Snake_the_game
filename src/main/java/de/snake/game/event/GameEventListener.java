package de.snake.game.event;

/** Listener interface for receiving game events from the EventBus. */
public interface GameEventListener {
  void onEvent(GameEvent event);
}
