package com.deedee.thelemia.scene;

import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.IEventListener;

public abstract class GameSystem implements IGameSystem {
    protected final EventBus eventBus;

    public GameSystem(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public abstract void subscribeListener();
    @Override
    public abstract IEventListener getListener();

    @Override
    public abstract void update(float delta);
    @Override
    public abstract void dispose();

    public EventBus getEventBus() {
        return eventBus;
    }
}
