package com.deedee.thelemia.graphics;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.deedee.thelemia.scene.component.TransformComponent;

public abstract class GraphicsObject implements IGraphicsObject {
    protected final Skin skin;

    public GraphicsObject(Skin skin) {
        this.skin = skin;
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
    public void dispose() {

    }

    @Override
    public abstract void render(TransformComponent transform);

    @Override
    public Skin getSkin() {
        return skin;
    }
}
