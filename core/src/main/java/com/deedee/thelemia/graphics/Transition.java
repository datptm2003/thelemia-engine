package com.deedee.thelemia.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.deedee.thelemia.graphics.enumerate.Easing;
import com.deedee.thelemia.scene.Scene;

import java.util.Objects;

public abstract class Transition {
    // Shared 1x1 white texture used to draw full-screen quads.
    private static Texture whitePixel;

    protected final float durationSeconds;
    protected float elapsedSeconds = 0f;
    protected boolean active = false;
    protected boolean finished = false;

    protected Easing easing = Easing.LINEAR;
    protected Color color = new Color(0f, 0f, 0f, 1f);

    // optional completion callback
    protected Runnable onComplete;

    /**
     * Create a transition with given duration in seconds.
     *
     * @param durationSeconds duration of transition in seconds (must be > 0)
     */
    public Transition(float durationSeconds) {
        if (durationSeconds <= 0f) throw new IllegalArgumentException("duration must be > 0");
        this.durationSeconds = durationSeconds;
        ensureWhitePixel();
    }

    private static void ensureWhitePixel() {
        if (whitePixel == null) {
            Pixmap p = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
            p.setColor(Color.WHITE);
            p.fill();
            whitePixel = new Texture(p);
            p.dispose();
        }
    }

    /**
     * Called to start the transition.
     */
    public void start() {
        this.elapsedSeconds = 0f;
        this.active = true;
        this.finished = false;
    }

    /**
     * Update internal timers. Call each frame before drawing the transition.
     *
     * @param delta delta seconds since last frame
     */
    public void update(float delta) {
        if (!active || finished) return;
        elapsedSeconds += delta;
        if (elapsedSeconds >= durationSeconds) {
            elapsedSeconds = durationSeconds;
            finished = true;
            active = false;
            if (onComplete != null) onComplete.run();
        }
    }

    /**
     * Render the transition overlay. Implementations should draw using Renderer sprite batch.
     * The renderer will have already drawn the "current" scene contents (so transitions draw on top).
     *
     * @param batch sprite batch to draw on (again) — convenience; implementations may rely on this object
     */
    public abstract void draw(SpriteBatch batch);

    /**
     * Force-finish the transition immediately (progress becomes 1).
     */
    public void finish() {
        if (!finished) {
            elapsedSeconds = durationSeconds;
            finished = true;
            active = false;
            if (onComplete != null) onComplete.run();
        }
    }

    public boolean isActive() {
        return active;
    }

    public boolean isFinished() {
        return finished;
    }

    /**
     * Progress in [0,1] before easing.
     */
    public float getRawProgress() {
        return Math.min(1f, Math.max(0f, elapsedSeconds / durationSeconds));
    }

    /**
     * Progress after easing applied.
     */
    public float getProgress() {
        return easing.apply(getRawProgress());
    }

    public Transition setEasing(Easing easing) {
        this.easing = easing == null ? Easing.LINEAR : easing;
        return this;
    }

    public Transition setColor(Color color) {
        if (color != null) this.color.set(color);
        return this;
    }

    public Transition setOnComplete(Runnable onComplete) {
        this.onComplete = onComplete;
        return this;
    }

    /**
     * Draws a full-screen rectangle tinted with the provided color and alpha.
     * Uses the shared 1×1 white pixel. <br><br>
     *
     * Note: this method starts/ends the batch; transition implementations may choose to
     * batch multiple draws together and avoid repeated begin/end if needed.
     */
    protected void drawFullscreenQuad(SpriteBatch batch, float r, float g, float b, float a) {
        // flush any GL state we might need (keep it simple)
        batch.end();

        batch.begin();
        // ensure blending on for semi-transparency
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        Color c = batch.getColor();
        batch.setColor(r, g, b, a);

        float sw = Gdx.graphics.getWidth();
        float sh = Gdx.graphics.getHeight();

        batch.draw(whitePixel, 0, 0, sw, sh);

        batch.setColor(c); // restore
        batch.end();

        batch.begin();
    }

    /**
     * Dispose static resources used by transitions. Call when your application exits.
     */
    public static void dispose() {
        if (whitePixel != null) {
            whitePixel.dispose();
            whitePixel = null;
        }
    }

    public static Texture getWhitePixel() {
        return whitePixel;
    }
}
