package de.snake.game.event;

import java.util.ArrayList;
import java.util.List;

public class EventBus {

  private final List<GameEventListener> listeners;

  public EventBus() {
    this.listeners = new ArrayList<>();
  }

  public void subscribe(GameEventListener listener) {
    listeners.add(listener);
  }

  public void publish(GameEvent event) {
    for (GameEventListener listener : listeners) {
      listener.onEvent(event);
    }
  }
}
