package com.deedee.thelemia.event.common;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Null;
import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.graphics.enumerate.RenderRequestType;

public class UpdateBufferEvent extends Event {
    private final Actor actor;

    private final RenderRequestType renderRequestType;
    @Null
    private int width, height;
    @Null
    private float scale;

    public UpdateBufferEvent(Actor actor, int width, int height) {
        super();
        this.actor = actor;

        this.renderRequestType = RenderRequestType.BY_SIZE;
        this.width = width;
        this.height = height;
    }
    public UpdateBufferEvent(Actor actor, float scale) {
        super();
        this.actor = actor;

        this.renderRequestType = RenderRequestType.BY_SCALE;
        this.scale = scale;
    }

    public Actor getActor() {
        return actor;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public float getScale() {
        return scale;
    }
    public RenderRequestType getRequestType() {
        return renderRequestType;
    }

    @Override
    public String getLog() {
        return "";
    }
}
