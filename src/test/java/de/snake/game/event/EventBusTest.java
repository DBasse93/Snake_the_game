package de.snake.game.event;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EventBusTest {

  @Mock
  private GameEventListener listenerA;

  @Mock
  private GameEventListener listenerB;

  @Mock
  private GameEvent event;

  private EventBus eventBus;

  @BeforeEach
  void setUp() {
    eventBus = new EventBus();
  }

  @Test
  void shouldNotifyAllSubscribersWhenEventPublished() {
    eventBus.subscribe(listenerA);
    eventBus.subscribe(listenerB);

    eventBus.publish(event);

    verify(listenerA).onEvent(event);
    verify(listenerB).onEvent(event);
  }

  @Test
  void shouldNotNotifyUnsubscribedListener() {
    eventBus.publish(event);

    verify(listenerA, never()).onEvent(event);
  }

  @Test
  void shouldNotifyOnlySubscribedListeners() {
    eventBus.subscribe(listenerA);

    eventBus.publish(event);

    verify(listenerA).onEvent(event);
    verify(listenerB, never()).onEvent(event);
  }
}
