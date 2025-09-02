package com.deedee.thelemia.event.common;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.graphics.Particles;
import com.deedee.thelemia.scene.component.ParticlesComponent;

public class RenderParticlesEvent extends Event {
    private final ParticlesComponent particlesComponent;

    public RenderParticlesEvent(ParticlesComponent particlesComponent, int x, int y, boolean loop) {
        this.particlesComponent = particlesComponent;
        this.particlesComponent.getGraphicsObject().setPosition(x, y);
        this.particlesComponent.getGraphicsObject().setLoop(loop);
    }

    public ParticlesComponent getParticlesComponent() {
        return particlesComponent;
    }

    @Override
    public String getLog() {
        return "";
    }
}
