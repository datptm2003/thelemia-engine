package com.deedee.thelemia.physics;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.event.IEventListener;

public class PhysicsEventListener implements IEventListener {
    private final PhysicsEngine gameSystem;

    public PhysicsEventListener(PhysicsEngine engine) {
        this.gameSystem = engine;
    }

    @Override
    public void onEvent(Event event) {

    }
}
