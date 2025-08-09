package com.deedee.thelemia.graphics;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.graphics.ui.Widget;

public abstract class GraphicsContext<T extends Widget> implements IGraphicsContext<T> {
    protected int width, height;
    protected int x = 0;
    protected int y = 0;

    public GraphicsContext(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Vector2 getHitboxSize() {
        return new Vector2(width, height);
    }

    public Vector2 getRelativePosition() {
        return new Vector2(x, y);
    }
    public void setRelativePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
