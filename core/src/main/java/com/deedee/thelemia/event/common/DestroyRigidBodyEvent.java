package com.deedee.thelemia.event.common;

import com.deedee.thelemia.event.Event;

import java.util.ArrayList;
import java.util.List;

public class DestroyRigidBodyEvent extends Event {
    private final List<String> names = new ArrayList<>();

    public DestroyRigidBodyEvent(String name) {
        super();
        this.names.add(name);
    }
    public DestroyRigidBodyEvent(List<String> names) {
        super();
        this.names.addAll(names);
    }

    public List<String> getNames() {
        return names;

    }

    @Override
    public String getLog() {
        return "";
    }
}
