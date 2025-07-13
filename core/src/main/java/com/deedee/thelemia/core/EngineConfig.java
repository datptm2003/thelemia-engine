package com.deedee.thelemia.core;

public class EngineConfig {
    private final int width;
    private final int height;
    private final String title;
    private final boolean resizable;

    public EngineConfig(int width, int height, String title, boolean resizable) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.resizable = resizable;
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
