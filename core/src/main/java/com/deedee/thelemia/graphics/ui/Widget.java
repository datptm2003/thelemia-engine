package com.deedee.thelemia.graphics.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.UpdateBufferEvent;
import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.behavior.IRenderableObject;
import com.deedee.thelemia.graphics.ui.context.IWidgetContext;
import com.deedee.thelemia.graphics.ui.context.WidgetContext;

public abstract class Widget implements IRenderableObject {
    protected Texture texture;
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
        if (texture == null) {
            throw new IllegalArgumentException("Texture cannot be null!");
        }
        EventBus.getInstance().post(new UpdateBufferEvent(texture, x, y, 1.0f));
    }
    @Override
    public void render() {
        if (texture == null) {
            throw new IllegalArgumentException("Texture cannot be null!");
        }
        EventBus.getInstance().post(new UpdateBufferEvent(texture, (int) context.getRelativePosition().x, (int) context.getRelativePosition().y, 1.0f));
    }

    @Override
    public void dispose() {

    }

    public Style getStyle() {
        return style;
    }

    @Override
    public Texture getTexture() {
        return texture;
    }
    public WidgetContext<? extends Widget> getContext() {
        return context;
    }

    @Override
    public Vector2 getHitboxSize() {
        return context.getHitboxSize();
    }
}
