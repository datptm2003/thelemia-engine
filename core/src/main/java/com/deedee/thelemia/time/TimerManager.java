package com.deedee.thelemia.time;

import com.badlogic.gdx.utils.Array;
import com.deedee.thelemia.event.IEventListener;
import com.deedee.thelemia.scene.IGameSystem;

public class TimerManager implements IGameSystem, ITimerManager {
    private final TimerListener listener = new TimerListener(this);
    private final Array<ITimer> timers = new Array<>();

    public TimerManager() {
        subscribeListener();
    }

    @Override
    public void subscribeListener() {

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
    public TimerListener getListener() {
        return listener;
    }

    @Override
    public void addTimer(ITimer timer) {
        timers.add(timer);
    }
    @Override
    public void clearAll() {
        timers.clear();
    }

}
