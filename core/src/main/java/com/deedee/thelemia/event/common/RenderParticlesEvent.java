package com.deedee.thelemia.event.common;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.scene.component.ParticlesComponent;

public class RenderParticlesEvent extends Event {
    private final ParticlesComponent particlesComponent;

    public RenderParticlesEvent(ParticlesComponent particlesComponent, int x, int y, boolean loop) {
        super();
        this.particlesComponent = particlesComponent;
        this.particlesComponent.getRenderableObject().setPosition(x, y);
        this.particlesComponent.getRenderableObject().setLoop(loop);
    }

    public ParticlesComponent getParticlesComponent() {
        return particlesComponent;
    }

    @Override
    public String getLog() {
        return "";
    }
}
