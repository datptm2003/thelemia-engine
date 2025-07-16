package com.deedee.thelemia.time;

import com.deedee.thelemia.event.IEvent;
import com.deedee.thelemia.event.IEventListener;

public class TimerListener implements IEventListener {
    private final TimerManager gameSystem;

    public TimerListener(TimerManager system) {
        this.gameSystem = system;
    }

    @Override
    public void onEvent(IEvent event) {

    }
}
