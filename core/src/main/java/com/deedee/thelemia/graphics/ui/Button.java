package com.deedee.thelemia.graphics.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.deedee.thelemia.graphics.behavior.IClickable;
import com.deedee.thelemia.graphics.ui.context.ButtonContext;
import com.deedee.thelemia.graphics.ui.style.ButtonStyle;

public class Button extends CompositeWidget implements IClickable {
    public Button(ButtonContext context, ButtonStyle style) {
        super(context, style);
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
