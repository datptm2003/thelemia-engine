package com.deedee.thelemia.time;

public interface ITimerManager {
    void addTimer(String id, Timer timer);
    void removeTimer(String id);
    void clearAll();

}
