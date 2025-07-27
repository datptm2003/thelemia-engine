package com.deedee.thelemia.time;

import com.deedee.thelemia.event.IEvent;
import com.deedee.thelemia.event.IEventListener;

public class TimeEventListener implements IEventListener {
    private final TimerManager gameSystem;

    public TimeEventListener(TimerManager system) {
        this.gameSystem = system;
    }

    @Override
    public void onEvent(IEvent event) {

    }
}
