package com.deedee.thelemia.time;

import com.badlogic.gdx.utils.Array;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.AddTimerEvent;
import com.deedee.thelemia.scene.IGameSystem;

public class TimerManager implements IGameSystem, ITimerManager {
    private final TimeEventListener listener = new TimeEventListener(this);
    private final Array<Timer> timers = new Array<>();

    public TimerManager() {
        subscribeListener();
    }

    @Override
    public void subscribeListener() {
        EventBus.getInstance().subscribe(AddTimerEvent.class, listener);
    }
    @Override
    public void update(float delta) {
        for (int i = timers.size - 1; i >= 0; i--) {
            ITimer timer = timers.get(i);
            timer.update(delta);
            if (timer.isFinished()) {
                timers.removeIndex(i);
            }
        }
    }
    @Override
    public void dispose() {

    }
    @Override
    public TimeEventListener getListener() {
        return listener;
    }

    @Override
    public void addTimer(Timer timer) {
        timers.add(timer);
    }
    @Override
    public void clearAll() {
        timers.clear();
    }

}
