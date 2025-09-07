package com.deedee.thelemia.core;

import com.badlogic.gdx.graphics.Color;

public class EngineConfig {
    private final Color backgroundColor;
    private final int width;
    private final int height;
    private final String title;
    private final boolean resizable;

    public EngineConfig(Color backgroundColor, int width, int height, String title, boolean resizable) {
        this.backgroundColor = backgroundColor;
        this.width = width;
        this.height = height;
        this.title = title;
        this.resizable = resizable;
    }
    public EngineConfig(int width, int height, String title, boolean resizable) {
        this.backgroundColor = Color.WHITE;
        this.width = width;
        this.height = height;
        this.title = title;
        this.resizable = resizable;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public String getTitle() {
        return title;
    }
    public boolean isResizable() {
        return resizable;
    }

}
