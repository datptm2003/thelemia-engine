package com.deedee.thelemia.graphics.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.UpdateBufferEvent;
import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.IRenderableObject;
import com.deedee.thelemia.graphics.GraphicsContext;

public abstract class Widget<C extends GraphicsContext, S extends Style> implements IRenderableObject {
    protected final C context;
    protected final S style;

    public Widget(C context, S style) {
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
    public void render(Vector2 position) {
        EventBus.getInstance().post(new UpdateBufferEvent(this, position, 1.0f));
    }
    @Override
    public void render() {
        EventBus.getInstance().post(new UpdateBufferEvent(this, context.getPosition(), 1.0f));
    }

    @Override
    public void dispose() {

    }

    @Override
    public int getWidth() {
        return context.getWidth();
    }
    @Override
    public int getHeight() {
        return context.getHeight();
    }

    @Override
    public abstract Drawable getDrawable(SpriteBatch batch, FrameBuffer fbo, boolean isTransparent);

    public C getContext() {
        return context;
    }
    public S getStyle() {
        return style;
    }

}
