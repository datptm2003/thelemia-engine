package com.deedee.thelemia.graphics.transition;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.deedee.thelemia.graphics.Transition;
import com.deedee.thelemia.graphics.enumerate.Direction;

/**
 * Slide overlay transition: a solid rectangle (color) slides across the screen in a direction.
 * This is a lightweight effect — it does not render textures of scenes — it simply draws a sliding
 * colored panel that can be used to hide/reveal scene changes.
 */
public class SlideTransition extends Transition {
    private final Direction direction;

    /**
     * @param durationSeconds duration in seconds
     * @param direction       direction the overlay moves (e.g. LEFT means overlay moves leftwards across screen)
     */
    public SlideTransition(float durationSeconds, Direction direction) {
        super(durationSeconds);
        this.direction = direction == null ? Direction.EAST : direction;
    }

    @Override
    public void draw(SpriteBatch batch) {
        float p = getProgress();
        batch.begin();
        // ensure blending for smooth edges if color has alpha
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        float sw = Gdx.graphics.getWidth();
        float sh = Gdx.graphics.getHeight();

        float panelWidth, panelHeight;
        float x = 0f, y = 0f;

        switch (direction) {
            case WEST:
                // panel slides from right->left. width grows from 0->sw
                panelWidth = sw * p;
                x = sw - panelWidth;
                panelHeight = sh;
                y = 0;
                break;
            case EAST:
                panelWidth = sw * p;
                x = 0;
                panelHeight = sh;
                y = 0;
                break;
            case NORTH:
                panelHeight = sh * p;
                y = 0;
                panelWidth = sw;
                x = 0;
                break;
            case SOUTH:
            default:
                panelHeight = sh * p;
                y = sh - panelHeight;
                panelWidth = sw;
                x = 0;
                break;
        }

        Color prev = batch.getColor();
        batch.setColor(color);
        // draw the rectangle using white pixel scaled
        batch.draw(Transition.getWhitePixel(), x, y, panelWidth, panelHeight);
        batch.setColor(prev);

        batch.end();
    }
}
