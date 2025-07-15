package com.deedee.thelemia.graphics.behavior;

public interface IDraggable {
    void onDragStart(int x, int y);
    void onDrag(int currentX, int currentY, int deltaX, int deltaY);
    void onDragEnd(int x, int y);
}
