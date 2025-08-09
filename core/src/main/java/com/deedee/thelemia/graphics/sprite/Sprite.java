package com.deedee.thelemia.graphics.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.UpdateBufferEvent;
import com.deedee.thelemia.graphics.GraphicsContext;
import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.ui.Widget;
import com.deedee.thelemia.graphics.utils.IRenderableObject;

public class Sprite implements IRenderableObject {
    protected final GraphicsContext<? extends Widget> context;
    protected final Style style;
    protected final Animation animation;

    public Sprite(GraphicsContext<? extends Widget> context, Style style, Animation animation) {
        this.context = context;
        this.style = style;
        this.animation = animation;
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
    public Drawable getDrawable(SpriteBatch batch, FrameBuffer fbo, boolean transparent) {
        return style.apply(context, batch, fbo, transparent);
    }
    public GraphicsContext<? extends Widget> getContext() {
        return context;
    }
    public Style getStyle() {
        return style;
    }
    public Animation getAnimation() {
        return animation;
    }


    @Override
    public Vector2 getHitboxSize() {
        return context.getHitboxSize();
    }
}
