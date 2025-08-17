package com.deedee.thelemia.physics;

import com.badlogic.gdx.physics.box2d.Body;

public class PhysicsBody {
    private final Body body;
    private final CollisionVisitor visitor;

    public PhysicsBody(Body body, CollisionVisitor visitor) {
        this.body = body;
        this.visitor = visitor;
        body.setUserData(visitor);
    }

    public Body getInternalBody() {
        return body;
    }
    public CollisionVisitor getVisitor() {
        return visitor;
    }


}
