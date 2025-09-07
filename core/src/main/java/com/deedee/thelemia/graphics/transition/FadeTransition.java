package com.deedee.thelemia.graphics.transition;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.deedee.thelemia.graphics.Renderer;
import com.deedee.thelemia.graphics.Transition;

/**
 * Simple fade transition: draws a color overlay whose alpha follows progress.<br>
 * At progress=0 the overlay alpha is 0 (fully transparent), at progress=1 alpha=1 (fully opaque).<br>
 * You probably want to call this while switching scenes like:<br>
 *   - Render "from" scene as usual<br>
 *   - Update transition (progress increases)<br>
 *   - Call transition.render(renderer) to draw overlay (fade out)<br>
 * After finished you then swap to the to-scene and optionally run another fade-in.
 */
public class FadeTransition extends Transition {

    private final boolean fadeIn; // if true progress 0->1 means fade-in of 'to' (inverse alpha)

    /**
     * Create fade transition.
     *
     * @param durationSeconds duration in seconds (must be > 0)
     * @param fadeIn true if the transition is a fade-in (showing the new scene), false = fade-out
     */
    public FadeTransition(float durationSeconds, boolean fadeIn) {
        super(durationSeconds);
        this.fadeIn = fadeIn;
    }

    @Override
    public void draw(SpriteBatch batch) {
        float p = getProgress();

        // If fadeIn==true: we want alpha to go from 1 -> 0 (i.e. reveal new scene). So compute alpha = 1 - p.
        // If fadeIn==false: alpha 0 -> 1 (cover).
        float alpha = fadeIn ? (1f - p) : p;

        // If alpha is effectively zero, skip draw.
        if (alpha <= 0f) return;

        Color c = color;
        drawFullscreenQuad(batch, c.r, c.g, c.b, alpha);
    }
}
