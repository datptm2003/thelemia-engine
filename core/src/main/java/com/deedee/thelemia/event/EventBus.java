package com.deedee.thelemia.event;

import java.util.*;

public class EventBus {
    private static EventBus instance;
    private final Map<Class<?>, List<IEventListener>> listeners = new HashMap<>();
    private final Queue<Event> eventQueue = new LinkedList<>();
    private boolean isProcessing = false;

    private EventBus() {

    }

    public static EventBus getInstance() {
        if (instance == null) {
            instance = new EventBus();
        }
        return instance;
    }

    public void subscribe(Class<? extends Event> eventType, IEventListener listener) {
        listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);
    }

    public void post(Event event) {
        synchronized (eventQueue) {
            eventQueue.add(event);
        }
    }

    public void process() {
        if (isProcessing) return;

        isProcessing = true;

        while (true) {
            Event event;
            synchronized (eventQueue) {
                event = eventQueue.poll();
            }

            if (event == null) break;

            List<IEventListener> eventListeners = listeners.get(event.getClass());
            if (eventListeners != null) {
                for (IEventListener listener : eventListeners) {
                    listener.onEvent(event);
                }
            }
        }

        isProcessing = false;
    }

}
