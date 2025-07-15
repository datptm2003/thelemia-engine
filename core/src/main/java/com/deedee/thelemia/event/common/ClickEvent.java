package com.deedee.thelemia.event.common;

import com.deedee.thelemia.core.IGameObject;
import com.deedee.thelemia.event.IEvent;

public class ClickEvent implements IEvent {
    private final IGameObject gameObject;
    private final int x, y;

    public ClickEvent(IGameObject gameObject, int x, int y) {
        this.gameObject = gameObject;
        this.x = x;
        this.y = y;
    }

    public IGameObject getGameObject() {
        return gameObject;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public void handle() {

    }
}
