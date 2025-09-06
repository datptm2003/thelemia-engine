package com.deedee.thelemia.event.common;

import com.deedee.thelemia.event.Event;

public class DestroyRigidBodyEvent extends Event {
    private final String name;

    public DestroyRigidBodyEvent(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getLog() {
        return "";
    }
}
