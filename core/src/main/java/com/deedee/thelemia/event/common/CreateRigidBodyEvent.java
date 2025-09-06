package com.deedee.thelemia.event.common;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.physics.BodyData;
import com.deedee.thelemia.physics.RigidBody;

import java.util.List;
import java.util.Map;

public class CreateRigidBodyEvent extends Event {
    private final Map<String, RigidBody> resultMap;
    private final BodyDef bodyDef;
    private final List<FixtureDef> fixtureDefs;
    private final BodyData bodyData;

    public CreateRigidBodyEvent(Map<String, RigidBody> resultMap, BodyDef bodyDef, List<FixtureDef> fixtureDefs, BodyData bodyData) {
        super();
        this.resultMap = resultMap;
        this.bodyDef = bodyDef;
        this.fixtureDefs = fixtureDefs;
        this.bodyData = bodyData;
    }

    public Map<String, RigidBody> getResultMap() {
        return resultMap;
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
