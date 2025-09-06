package com.deedee.thelemia.physics;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.event.IEventListener;
import com.deedee.thelemia.event.common.CreateRigidBodyEvent;
import com.deedee.thelemia.event.common.DestroyRigidBodyEvent;

public class PhysicsEventListener implements IEventListener {
    private final PhysicsEngine gameSystem;

    public PhysicsEventListener(PhysicsEngine engine) {
        this.gameSystem = engine;
    }

    @Override
    public void onEvent(Event event) {
        if (event instanceof CreateRigidBodyEvent) {
            CreateRigidBodyEvent createRigidBodyEvent = (CreateRigidBodyEvent) event;
            RigidBody rigidBody = gameSystem.createBody(createRigidBodyEvent.getBodyDef(), createRigidBodyEvent.getFixtureDefs(), createRigidBodyEvent.getBodyData());
            createRigidBodyEvent.getResultMap().put(createRigidBodyEvent.getBodyData().getName(), rigidBody);

        } else if (event instanceof DestroyRigidBodyEvent) {
            DestroyRigidBodyEvent destroyRigidBodyEvent = (DestroyRigidBodyEvent) event;
            for (String name : destroyRigidBodyEvent.getNames()) {
                gameSystem.destroyBody(name);
            }

        }
    }
}
