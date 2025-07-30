package com.deedee.thelemia.graphics.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.deedee.thelemia.graphics.ui.context.ButtonContext;
import com.deedee.thelemia.graphics.ui.context.LabelContext;
import com.deedee.thelemia.graphics.ui.style.LabelStyle;

public class Label extends Widget {
    public Label(LabelContext context, LabelStyle style) {
        super(context, style);
    }

    @Override
    public LabelContext getContext() {
        return (LabelContext) super.getContext();
    }
}
