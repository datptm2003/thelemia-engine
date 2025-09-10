package com.deedee.thelemia.physics;

import com.badlogic.gdx.physics.box2d.*;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.CreateRigidBodyEvent;
import com.deedee.thelemia.event.common.DestroyRigidBodyEvent;
import com.deedee.thelemia.scene.GameSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhysicsEngine extends GameSystem {
    private static class InternalContactListener implements ContactListener {
        @Override
        public void beginContact(Contact contact) {
            RigidBody bodyA = (RigidBody) contact.getFixtureA().getBody().getUserData();
            RigidBody bodyB = (RigidBody) contact.getFixtureB().getBody().getUserData();

            if (bodyA == null || bodyB == null) {
                return;
            }

            bodyA.onBeginCollision(bodyB);
            bodyB.onBeginCollision(bodyA);
        }

        @Override
        public void endContact(Contact contact) {
            RigidBody bodyA = (RigidBody) contact.getFixtureA().getBody().getUserData();
            RigidBody bodyB = (RigidBody) contact.getFixtureB().getBody().getUserData();

            if (bodyA == null || bodyB == null) {
                return;
            }

            bodyA.onEndCollision(bodyB);
            bodyB.onEndCollision(bodyA);
        }
        @Override
        public void preSolve(Contact contact, Manifold oldManifold) {

        }
        @Override
        public void postSolve(Contact contact, ContactImpulse impulse) {

        }
    }

    private final PhysicsEventListener listener = new PhysicsEventListener(this);

    private final World world;
    private final Map<String, RigidBody> bodies = new HashMap<>();

    public PhysicsEngine(PhysicsConfig config) {
        this.world = new World(config.getGravity(), true);
        this.world.setContactListener(new InternalContactListener());
        subscribeListener();
    }

    public RigidBody createBody(BodyDef bodyDef, List<FixtureDef> fixtureDefs, BodyData bodyData) {
        Body body = world.createBody(bodyDef);
        for (FixtureDef fixtureDef : fixtureDefs) {
            body.createFixture(fixtureDef);
        }
        RigidBody rigidBody = new RigidBody(body, bodyData);
        bodies.put(bodyData.getName(), rigidBody);
        return rigidBody;
    }
    public RigidBody getRigidBody(String name) {
        return bodies.get(name);
    }
    public void destroyBody(String name) {
        RigidBody body = bodies.get(name);
        world.destroyBody(body.getInternalBody());
        bodies.remove(name);
    }

    @Override
    public void subscribeListener() {
        EventBus.getInstance().subscribe(CreateRigidBodyEvent.class, listener);
        EventBus.getInstance().subscribe(DestroyRigidBodyEvent.class, listener);
    }

    @Override
    public void update(float delta) {
        world.step(delta, 6, 2);
    }
    @Override
    public void dispose() {
        for (RigidBody body : bodies.values()) {
            world.destroyBody(body.getInternalBody());
        }
        world.dispose();
        bodies.clear();
    }
    @Override
    public PhysicsEventListener getListener() {
        return listener;
    }

    public World getWorld() {
        return world;
    }
    public List<RigidBody> getAllRigidBodies() {
        return (List<RigidBody>) bodies.values();
    }
}
