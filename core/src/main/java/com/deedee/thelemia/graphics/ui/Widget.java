package com.deedee.thelemia.graphics.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.UpdateBufferEvent;
import com.deedee.thelemia.graphics.ui.style.Style;
import com.deedee.thelemia.graphics.utils.IRenderableObject;
import com.deedee.thelemia.graphics.ui.context.WidgetContext;

public abstract class Widget implements IRenderableObject {
    protected WidgetContext<? extends Widget> context;
    protected Style style;

    public Widget(WidgetContext<? extends Widget> context, Style style) {
        this.context = context;
        this.style = style;
    }

    @Override
    public void create() {

    }
    @Override
    public void start() {

    }
    @Override
    public void update(float delta) {

    }

    @Override
    public void render(int x, int y) {
        EventBus.getInstance().post(new UpdateBufferEvent(this, x, y, 1.0f));
    }
    @Override
    public void render() {
        EventBus.getInstance().post(new UpdateBufferEvent(this, (int) context.getRelativePosition().x, (int) context.getRelativePosition().y, 1.0f));
    }

    @Override
    public void dispose() {

    }

    @Override
    public Style getStyle() {
        return style;
    }
    @Override
    public Drawable getDrawable(SpriteBatch batch, FrameBuffer fbo, boolean transparent) {
        return style.apply(context, batch, fbo, transparent);
    }
    public WidgetContext<? extends Widget> getContext() {
        return context;
    }

    @Override
    public Vector2 getHitboxSize() {
        return context.getHitboxSize();
    }
}
