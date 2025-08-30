package com.deedee.thelemia.event.common;

import com.badlogic.gdx.utils.Null;
import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.graphics.Fragment;
import com.deedee.thelemia.graphics.GraphicsObject;
import com.deedee.thelemia.graphics.enumerate.RenderRequestType;
import com.deedee.thelemia.scene.component.TransformComponent;

public class RenderFragmentEvent extends Event {
    private final Fragment fragment;
    private final TransformComponent transform;
    private final float parentAlpha;

    public RenderFragmentEvent(Fragment fragment, TransformComponent transform, float parentAlpha) {
        super();
        this.fragment = fragment;
        this.transform = transform;
        this.parentAlpha = parentAlpha;
    }

    public Fragment getFragment() {
        return fragment;
    }
    public TransformComponent getTransform() {
        return transform;
    }
    public float getParentAlpha() {
        return parentAlpha;
    }

    @Override
    public String getLog() {
        return "";
    }
}
