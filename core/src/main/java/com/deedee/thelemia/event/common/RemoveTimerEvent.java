package com.deedee.thelemia.event.common;

import com.deedee.thelemia.event.Event;

public class RemoveTimerEvent extends Event {
    private final String id;

    public RemoveTimerEvent(String id) {
        super();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getLog() {
        return "";
    }

}
