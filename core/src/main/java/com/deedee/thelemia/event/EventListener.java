package com.deedee.thelemia.event;

public abstract class EventListener implements IEventListener {
    private final EventBus eventBus;

    public EventListener(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public abstract void onEvent(IEvent event);

    public EventBus getEventBus() {
        return eventBus;
    }
}
