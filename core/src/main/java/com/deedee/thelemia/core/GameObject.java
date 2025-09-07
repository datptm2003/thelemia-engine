package com.deedee.thelemia.core;

public class GameObject implements IGameObject {
    protected boolean isStarted = false;
    protected boolean isStopped = false;

    @Override
    public void create() {

    }
    @Override
    public void start() {
        isStarted = true;
    }

    @Override
    public void update(float delta) {
        if (!isStarted) start();
        if (isStopped) stop();
    }

    @Override
    public void stop() {

    }
    @Override
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
