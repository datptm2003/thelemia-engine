package com.deedee.thelemia.graphics;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.deedee.thelemia.core.GameObject;

public abstract class RenderableObject extends GameObject {
    protected final Skin skin;

    public RenderableObject(Skin skin) {
        this.skin = skin;
    }

    public Skin getSkin() {
        return skin;
    }
}
