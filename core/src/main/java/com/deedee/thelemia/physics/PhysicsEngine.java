package com.deedee.thelemia.physics;

import com.badlogic.gdx.physics.box2d.*;
import com.deedee.thelemia.scene.IGameSystem;

import java.util.ArrayList;
import java.util.List;

public class PhysicsEngine implements IGameSystem, IPhysicsEngine {
    private static class InternalContactListener implements ContactListener {
        @Override
        public void beginContact(Contact contact) {
            CollisionVisitor visitorA = (CollisionVisitor) contact.getFixtureA().getBody().getUserData();
            CollisionVisitor visitorB = (CollisionVisitor) contact.getFixtureB().getBody().getUserData();

            if (visitorA == null || visitorB == null) return;

            visitorA.onCollide(visitorB);
            visitorB.onCollide(visitorA);
        }

        @Override
        public void endContact(Contact contact) {

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
    private final List<PhysicsBody> bodies = new ArrayList<>();

    public PhysicsEngine(PhysicsConfig config) {
        this.world = new World(config.getGravity(), true);
        this.world.setContactListener(new InternalContactListener());
        subscribeListener();
    }

    public PhysicsBody createBody(BodyDef definition, CollisionVisitor visitor) {
        Body body = world.createBody(definition);
        PhysicsBody physicsBody = new PhysicsBody(body, visitor);
        bodies.add(physicsBody);
        return physicsBody;
    }

    @Override
    public void subscribeListener() {

    }
    @Override
    public void update(float delta) {
        world.step(delta, 6, 2);
    }
    @Override
    public void dispose() {
        for (PhysicsBody body : bodies) {
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
    public List<PhysicsBody> getAllBodies() {
        return bodies;
    }
}
