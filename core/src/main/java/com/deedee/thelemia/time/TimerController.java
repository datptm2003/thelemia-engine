package com.deedee.thelemia.time;

import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.AddTimerEvent;
import com.deedee.thelemia.event.common.RemoveTimerEvent;
import com.deedee.thelemia.scene.GameSystem;

import java.util.HashMap;
import java.util.Map;

public class TimerController extends GameSystem {
    private final TimeEventListener listener = new TimeEventListener(this);
    private final Map<String, Timer> timers = new HashMap<>();

    public TimerController() {
        subscribeListener();
    }

    @Override
    public void subscribeListener() {
        EventBus.getInstance().subscribe(AddTimerEvent.class, listener);
        EventBus.getInstance().subscribe(RemoveTimerEvent.class, listener);
    }
    @Override
    public void update(float delta) {
        for (Timer timer : timers.values()) {
            if (!timer.isFinished()) {
                timer.update(delta);
            }
        }
    }
    @Override
    public void dispose() {
        clearAll();
    }
    @Override
    public TimeEventListener getListener() {
        return listener;
    }

    public void addTimer(String id, Timer timer) {
        timers.put(id, timer);
    }
    public void removeTimer(String id) {
        timers.remove(id);
    }

    public void clearAll() {
        timers.clear();
    }

}
