package com.deedee.thelemia.scene.component;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.deedee.thelemia.graphics.SpriteGroup;
import com.deedee.thelemia.scene.Component;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

public class SpriteComponent extends Component implements IGraphicsComponent {
    private final SpriteGroup group;
    private boolean visible = true;

    private Animation<TextureRegion> animation;

    public SpriteComponent(Entity owner, SpriteGroup group, Animation<TextureRegion> animation) {
        super(owner);
        this.group = group;
        this.animation = animation;

        this.group.create();
    }

    @Override
    public void update(float delta) {
        if (!enabled) return;

        group.update(delta);
    }
    @Override
    public void reset() {
        visible = true;
        enabled = true;
    }
    @Override
    public void dispose() {
        group.dispose();
    }

    @Override
    public void render() {
        if (!visible) return;

        TransformComponent transform = owner.getComponentByType(TransformComponent.class);
        group.render();
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
    public SpriteGroup getContainer() {
        return group;
    }

    public Animation<TextureRegion> getAnimation() {
        return animation;
    }
    public void setAnimation(Animation<TextureRegion> animation) {
        this.animation = animation;
    }
}
