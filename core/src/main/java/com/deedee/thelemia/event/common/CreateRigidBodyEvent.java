package com.deedee.thelemia.event.common;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.physics.BodyData;

import java.util.List;

public class CreateRigidBodyEvent extends Event {
    private final BodyDef bodyDef;
    private final List<FixtureDef> fixtureDefs;
    private final BodyData bodyData;

    public CreateRigidBodyEvent(BodyDef bodyDef, List<FixtureDef> fixtureDefs, BodyData bodyData) {
        super();
        this.bodyDef = bodyDef;
        this.fixtureDefs = fixtureDefs;
        this.bodyData = bodyData;
    }

    public BodyDef getBodyDef() {
        return bodyDef;
    }
    public List<FixtureDef> getFixtureDefs() {
        return fixtureDefs;
    }
    public BodyData getBodyData() {
        return bodyData;
    }

    @Override
    public String getLog() {
        return "";
    }
}
