package com.deedee.thelemia.scene.component;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.deedee.thelemia.graphics.Fragment;
import com.deedee.thelemia.scene.Component;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

public class WidgetComponent extends Component implements IGraphicsComponent {
    private final Stage stage;
    private final Fragment fragment;
    private boolean visible = true;

    public WidgetComponent(Entity owner, Stage stage, Fragment fragment) {
        super(owner);
        this.stage = stage;
        this.fragment = fragment;
        this.fragment.create();

        stage.addActor(fragment.getWidgetGroup());
    }

    @Override
    public void update(float delta) {
        if (!enabled) return;

        fragment.update(delta);
    }
    @Override
    public void reset() {
        visible = true;
        enabled = true;
    }

    @Override
    public void dispose() {
        fragment.getWidgetGroup().remove();
        fragment.dispose();
    }

    @Override
    public void render() {
        if (!visible) return;

        TransformComponent transform = owner.getComponentByType(TransformComponent.class);
        fragment.render(transform);
    }

    @Override
    public boolean isVisible() {
        return visible;
    }
    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public ComponentGroup getGroup() {
        return ComponentGroup.GRAPHICS;
    }
    @Override
    public Fragment getGraphicsObject() {
        return fragment;
    }

    public Stage getStage() {
        return stage;
    }
}
