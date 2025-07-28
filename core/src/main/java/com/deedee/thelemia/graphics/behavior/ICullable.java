package com.deedee.thelemia.graphics.behavior;

public interface ICullable {
    boolean isInsideVisibleArea(int x, int y, int width, int height);
}
