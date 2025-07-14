package com.deedee.thelemia.graphics.ui.behavior;

public interface ICullable {
    void setVisibleArea(int x, int y, int width, int height);
    boolean isInVisibleArea(int x, int y);
}
