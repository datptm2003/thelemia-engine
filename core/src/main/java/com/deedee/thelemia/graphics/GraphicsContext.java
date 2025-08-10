package com.deedee.thelemia.graphics;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.graphics.ui.Widget;

public abstract class GraphicsContext implements IGraphicsContext {
    protected final int width, height;
    protected Vector2 position;

    public GraphicsContext(int width, int height) {
        this.width = width;
        this.height = height;
        this.position = new Vector2(0, 0);
    }

    @Override
    public int getWidth() {
        return width;
    }
    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }
    @Override
    public void setPosition(int x, int y) {
        this.position.x = x;
        this.position.y = y;
    }

}
