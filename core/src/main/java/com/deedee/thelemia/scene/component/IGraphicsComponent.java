package com.deedee.thelemia.scene.component;

import com.deedee.thelemia.graphics.ui.IContainer;
import com.deedee.thelemia.scene.IComponent;

public interface IGraphicsComponent extends IComponent {
    void render();
    boolean isVisible();
    void setVisible(boolean visible);

    IContainer getContainer();
    void setContainer(IContainer container);
}
