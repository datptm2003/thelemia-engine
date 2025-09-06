package com.deedee.thelemia.scene;

import com.badlogic.gdx.utils.Disposable;
import com.deedee.thelemia.event.IEventListener;

public abstract class GameSystem implements Disposable {
    public abstract void subscribeListener();
    public abstract IEventListener getListener();
    public abstract void update(float delta);
}

