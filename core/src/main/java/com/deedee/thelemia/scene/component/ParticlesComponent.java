package com.deedee.thelemia.scene.component;

import com.deedee.thelemia.graphics.Particles;
import com.deedee.thelemia.scene.Component;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

public class ParticlesComponent extends Component implements IGraphicsComponent {
    private final Particles particles;
    private boolean visible;

    public ParticlesComponent(Entity owner, Particles particles) {
        super(owner);
        this.particles = particles;
    }

    @Override
    public void reset() {
        enabled = true;
    }

    @Override
    public void dispose() {
        particles.dispose();
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
    public Particles getGraphicsObject() {
        return particles;
    }
}
