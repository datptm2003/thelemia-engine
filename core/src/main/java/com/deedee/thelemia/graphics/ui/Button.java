package com.deedee.thelemia.graphics.ui;

import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.ClickEvent;
import com.deedee.thelemia.graphics.behavior.IClickable;

public abstract class Button extends Widget implements IClickable {
    @Override
    public void create() {
        super.create();
    }
    @Override
    public void start() {
        super.start();
    }
    @Override
    public void update(float delta) {
        super.update(delta);
    }
    @Override
    public void render(int x, int y) {
        super.render(x, y);
    }
    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public abstract void onClick(int x, int y);
}
