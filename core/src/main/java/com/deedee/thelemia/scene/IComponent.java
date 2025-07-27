package com.deedee.thelemia.scene;

public interface IComponent {
    void update(float delta);
    void reset();
    boolean isEnabled();
    void setEnabled(boolean enabled);
}
