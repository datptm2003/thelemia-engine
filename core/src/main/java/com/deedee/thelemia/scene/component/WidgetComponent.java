package com.deedee.thelemia.scene.component;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.RenderFragmentEvent;
import com.deedee.thelemia.graphics.Fragment;
import com.deedee.thelemia.scene.Component;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

public class WidgetComponent extends Component implements IGraphicsComponent {
    private final Table root;
    private final Fragment fragment;
    private boolean visible = true;

    public WidgetComponent(Entity owner, Table root, Fragment fragment) {
        super(owner);
        this.root = root;
        this.fragment = fragment;
        this.fragment.create();
    }

    @Override
    public void reset() {
        visible = true;
        enabled = true;
    }

    @Override
    public void dispose() {
        fragment.getWidget().remove();
        fragment.dispose();
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

    public Table getRoot() {
        return root;
    }
}
