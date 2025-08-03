package com.deedee.thelemia.scene;

import com.deedee.thelemia.event.IEventListener;
import com.deedee.thelemia.graphics.utils.IDisposable;

public interface IGameSystem extends IDisposable {
    void subscribeListener();
    IEventListener getListener();
    void update(float delta);
}

