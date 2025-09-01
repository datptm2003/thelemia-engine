package com.deedee.thelemia.graphics;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.deedee.thelemia.core.GameObject;
import com.deedee.thelemia.scene.component.TransformComponent;

public abstract class GraphicsObject extends GameObject implements IGraphicsObject {
    protected final Skin skin;

    public GraphicsObject(Skin skin) {
        this.skin = skin;
    }

    @Override
    public Skin getSkin() {
        return skin;
    }
}
