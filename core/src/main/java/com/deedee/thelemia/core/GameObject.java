package com.deedee.thelemia.core;

public class GameObject {
    protected boolean isStarted = false;
    protected boolean isStopped = false;

    public void create() {

    }
    public void start() {
        isStarted = true;
    }

    public void update(float delta) {
        if (!isStarted) start();
        if (isStopped) stop();
    }

    public void stop() {

    }
    public void dispose() {

    }

    public boolean isStarted() {
        return isStarted;
    }
    public void setStarted(boolean started) {
        isStarted = started;
    }

    public boolean isStopped() {
        return isStopped;
    }
    public void setStopped(boolean stopped) {
        isStopped = stopped;
    }
}
