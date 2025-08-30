package com.deedee.thelemia.scene.component;

import com.deedee.thelemia.graphics.Fragment;
import com.deedee.thelemia.scene.Component;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

public class UIComponent extends Component implements IGraphicsComponent {
    private final Fragment fragment;
    private boolean visible = true;

    public UIComponent(Entity owner, Fragment fragment) {
        super(owner);
        this.fragment = fragment;
        this.fragment.create();
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
        fragment.dispose();
    }

    @Override
    public void render() {
        if (!visible) return;

        TransformComponent transform = owner.getComponentByType(TransformComponent.class);
        fragment.render();
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
    public Fragment getContainer() {
        return fragment;
    }

}
