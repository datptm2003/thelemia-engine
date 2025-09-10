package com.deedee.thelemia.time;

public class Timer {
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

    public void pause() {
        paused = true;
    }
    public void resume() {
        paused = false;
    }
    public void reset() {
        timeLeft = duration;
        finished = false;
    }
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

