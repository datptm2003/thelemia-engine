package com.deedee.thelemia.time;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.event.IEventListener;
import com.deedee.thelemia.event.common.AddTimerEvent;

public class TimeEventListener implements IEventListener {
    private final TimerController gameSystem;

    public TimeEventListener(TimerController system) {
        this.gameSystem = system;
    }

    @Override
    public void onEvent(Event event) {
        if (event instanceof AddTimerEvent) {
            AddTimerEvent addTimerEvent = (AddTimerEvent) event;
            gameSystem.addTimer(addTimerEvent.getTimer());
        }
    }
}
