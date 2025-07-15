package com.deedee.thelemia.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBus {
    private final Map<Class<?>, List<IEventListener>> listeners = new HashMap<>();

    public EventBus() {

    }

    public void subscribe(Class<?> eventType, IEventListener listener) {
        listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);
    }

    public void post(IEvent event) {
        if (listeners.containsKey(event.getClass())) {
            for (IEventListener listener : listeners.get(event.getClass())) {
                listener.onEvent(event);
            }
        }
    }

}
