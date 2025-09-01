package com.deedee.thelemia.event.common;

import com.badlogic.gdx.utils.Null;
import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.graphics.Fragment;
import com.deedee.thelemia.graphics.GraphicsObject;
import com.deedee.thelemia.graphics.enumerate.RenderRequestType;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.component.TransformComponent;

public class RenderFragmentEvent extends Event {
    private final Entity fragmentEntity;
    private final float parentAlpha;

    public RenderFragmentEvent(Entity fragmentEntity, float parentAlpha) {
        super();
        this.fragmentEntity = fragmentEntity;
        this.parentAlpha = parentAlpha;
    }

    public Entity getFragmentEntity() {
        return fragmentEntity;
    }
    public float getParentAlpha() {
        return parentAlpha;
    }

    @Override
    public String getLog() {
        return "";
    }
}
