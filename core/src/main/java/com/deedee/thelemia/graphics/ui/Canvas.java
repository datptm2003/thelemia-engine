package com.deedee.thelemia.graphics.ui;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.graphics.utils.ICullable;
import com.deedee.thelemia.graphics.ui.context.CanvasContext;
import com.deedee.thelemia.graphics.ui.style.CanvasStyle;

public class Canvas extends Widget implements ICullable {
    public Canvas(CanvasContext context, CanvasStyle style) {
        super(context, style);
    }

    @Override
    public boolean isInsideVisibleArea(int x, int y, int width, int height) {
        Vector2 canvasSize = getHitboxSize();
        return x >= 0 && y >= 0 && x + width <= canvasSize.x && y + height <= canvasSize.y;
    }

    @Override
    public CanvasContext getContext() {
        return (CanvasContext) super.getContext();
    }

}
