package com.deedee.thelemia.event.common;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.time.Timer;

public class AddTimerEvent extends Event {
    private final String id;
    private final Timer timer;

    public AddTimerEvent(String id, Timer timer) {
        super();
        this.id = id;
        this.timer = timer;
    }

    public String getId() {
        return id;
    }
    public Timer getTimer() {
        return timer;
    }

    @Override
    public String getLog() {
        return "";
    }
}
