package com.deedee.thelemia.event.common;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.time.Timer;

public class AddTimerEvent extends Event {
    private final Timer timer;

    public AddTimerEvent(Timer timer) {
        super();
        this.timer = timer;
    }

    public Timer getTimer() {
        return timer;
    }

    @Override
    public String getLog() {
        return "";
    }
}
