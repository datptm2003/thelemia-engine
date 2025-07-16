package com.deedee.thelemia.time;

public interface ITimer {
    void update(float delta);
    void pause();
    void resume();
    void reset();
    boolean isFinished();

}
