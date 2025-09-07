package com.deedee.thelemia.graphics;

import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public interface IParticles {
    PooledEffect spawn(float x, float y);
    PooledEffect spawn();
    void draw(SpriteBatch batch);
    void clear();

    /**
     * Mark active effects to stop emitting new particles, but allow existing particles to finish naturally.
     * This tries to emulate a graceful stop.
     */
    void allowCompletion();

    /**
     * Control whether effects reset/restore the Batch blend function after drawing.
     * When drawing many effects with the same blend mode you may want to set this to false
     * and manage the blend function yourself (reduce flushes).
     */
    void setEmittersCleanUpBlendFunction(boolean value);
}
