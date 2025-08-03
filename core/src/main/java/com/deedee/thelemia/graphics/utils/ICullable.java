package com.deedee.thelemia.graphics.utils;

public interface ICullable {
    boolean isInsideVisibleArea(int x, int y, int width, int height);
}
