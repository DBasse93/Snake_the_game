package de.snake.game.event;

import java.util.ArrayList;
import java.util.List;

/** Simple publish-subscribe event bus for decoupling game components. */
public class EventBus {

  // List (not Set) so listeners are notified in the order they subscribed
  private final List<GameEventListener> listeners;

  public EventBus() {
    this.listeners = new ArrayList<>();
  }

  /** Registers a listener to receive all future published events. */
  public void subscribe(GameEventListener listener) {
    listeners.add(listener);
  }

  /** Publishes an event to all registered listeners. */
  public void publish(GameEvent event) {
    for (GameEventListener listener : listeners) {
      listener.onEvent(event);
    }
  }
}
