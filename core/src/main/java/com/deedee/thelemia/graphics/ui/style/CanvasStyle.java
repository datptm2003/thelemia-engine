package com.deedee.thelemia.graphics.ui.style;

import com.badlogic.gdx.graphics.Texture;
import com.deedee.thelemia.graphics.Style;

public class CanvasStyle extends Style {
    private final Texture background;

    public CanvasStyle(Texture background) {
        this.background = background;
    }
    public CanvasStyle() {
        this.background = null;
    }

    public Texture getBackground() {
        return background;
    }
}
