package com.deedee.thelemia.graphics.ui;

import com.deedee.thelemia.graphics.behavior.IClickable;
import com.deedee.thelemia.graphics.ui.context.ButtonContext;

public class Button extends CompositeWidget implements IClickable {
    public Button(ButtonContext context) {
        super(context);
    }

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
    public void onClick(int x, int y) {
        this.getContext().getCallback().run();
    }
    @Override
    public ButtonContext getContext() {
        return (ButtonContext) super.getContext();
    }

}
