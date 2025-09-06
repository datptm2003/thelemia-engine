package com.deedee.thelemia.physics;

import com.badlogic.gdx.physics.box2d.Body;

public class RigidBody {
    private final Body body;
    private final BodyData bodyData;

    public RigidBody(Body body, BodyData bodyData) {
        this.body = body;
        this.bodyData = bodyData;
        body.setUserData(this);
    }

    public void onBeginCollision(RigidBody other) {

    }
    public void onEndCollision(RigidBody other) {

    }

    public Body getInternalBody() {
        return body;
    }
    public BodyData getData() {
        return bodyData;
    }
}
