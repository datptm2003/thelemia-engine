package com.deedee.thelemia.time;

public class Timer implements ITimer {
    private float timeLeft;
    private float duration;
    private boolean repeat;
    private boolean finished = false;
    private boolean paused = false;
    private final Runnable callback;

    public Timer(float duration, boolean repeat, Runnable callback) {
        this.duration = duration;
        this.timeLeft = duration;
        this.repeat = repeat;
        this.callback = callback;
    }

    @Override
    public void update(float delta) {
        if (paused || finished) return;
        timeLeft -= delta;
        if (timeLeft <= 0f) {
            callback.run();
            if (repeat) {
                timeLeft = duration;
            } else {
                finished = true;
            }
        }
    }

    @Override
    public void pause() {
        paused = true;
    }
    @Override
    public void resume() {
        paused = false;
    }
    @Override
    public void reset() {
        timeLeft = duration;
        finished = false;
    }
    @Override
    public boolean isFinished() {
        return finished;
    }

    public float getDuration() {
        return duration;
    }
    public void setDuration(float duration) {
        this.duration = duration;
    }

    public boolean isRepeat() {
        return repeat;
    }
    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public float getTimeLeft() {
        return timeLeft;
    }
}

