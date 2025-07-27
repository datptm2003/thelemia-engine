package com.deedee.thelemia.scene;

import com.deedee.thelemia.scene.enumerate.ComponentGroup;

public interface IComponent {
    void update(float delta);
    void reset();
    boolean isEnabled();
    void setEnabled(boolean enabled);
    ComponentGroup getGroup();
}
