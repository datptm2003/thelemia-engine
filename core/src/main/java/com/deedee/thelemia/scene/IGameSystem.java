package com.deedee.thelemia.scene;

import com.badlogic.gdx.utils.Disposable;
import com.deedee.thelemia.event.IEventListener;

public interface IGameSystem extends Disposable {
    void subscribeListener();
    IEventListener getListener();
    void update(float delta);
}

