package com.deedee.thelemia.graphics.ui;

import com.deedee.thelemia.graphics.IContainer;

public interface IOverlay extends IContainer {
    void setLayer(int layer);
    int getLayer();
}
