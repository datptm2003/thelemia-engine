package com.deedee.thelemia.event.common;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.physics.BodyData;
import com.deedee.thelemia.physics.RigidBody;
import com.deedee.thelemia.utils.Carrier;

import java.util.List;
import java.util.Map;

public class CreateRigidBodyEvent extends Event {
    private final Carrier<Map<String, RigidBody>> resultCarrier;
    private final BodyDef bodyDef;
    private final List<FixtureDef> fixtureDefs;
    private final BodyData bodyData;

    public CreateRigidBodyEvent(Carrier<Map<String, RigidBody>> resultCarrier, BodyDef bodyDef, List<FixtureDef> fixtureDefs, BodyData bodyData) {
        super();
        this.resultCarrier = resultCarrier;
        this.bodyDef = bodyDef;
        this.fixtureDefs = fixtureDefs;
        this.bodyData = bodyData;
    }

    public Map<String, RigidBody> getResultMap() {
        return resultCarrier.getItem();
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
