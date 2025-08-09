package com.deedee.thelemia.event.common;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.graphics.utils.IRenderableObject;
import com.deedee.thelemia.graphics.enumerate.RenderRequestType;

public class UpdateBufferEvent extends Event {
    private final IRenderableObject object;
    private final Vector2 position;

    private final RenderRequestType renderRequestType;
    private int width, height;
    private float scale;

    public UpdateBufferEvent(IRenderableObject object, Vector2 position, int width, int height) {
        super();
        this.object = object;
        this.position = position;

        this.renderRequestType = RenderRequestType.BY_SIZE;
        this.width = width;
        this.height = height;
    }
    public UpdateBufferEvent(IRenderableObject object, Vector2 position, float scale) {
        super();
        this.object = object;
        this.position = position;

        this.renderRequestType = RenderRequestType.BY_SCALE;
        this.scale = scale;
    }

    public IRenderableObject getRenderableObject() {
        return object;
    }
    public Vector2 getPosition() {
        return position;
    }
    public Vector2 getSize() {
        return new Vector2(width, height);
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
