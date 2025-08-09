package com.deedee.thelemia.graphics.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.UpdateBufferEvent;
import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.utils.IRenderableObject;
import com.deedee.thelemia.graphics.GraphicsContext;

public abstract class Widget implements IRenderableObject {
    protected final GraphicsContext<? extends Widget> context;
    protected final Style style;

    public Widget(GraphicsContext<? extends Widget> context, Style style) {
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
    public abstract Drawable getDrawable(SpriteBatch batch, FrameBuffer fbo, boolean transparent);

    public abstract GraphicsContext<? extends Widget> getContext();
    public abstract Style getStyle();

}
