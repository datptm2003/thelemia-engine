package com.deedee.thelemia.physics;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import java.util.List;

public interface IPhysicsEngine {
    void createBody(BodyDef bodyDef, List<FixtureDef> fixtureDefs, BodyData bodyData);
    RigidBody getRigidBody(String name);
    void destroyBody(String name);
}
