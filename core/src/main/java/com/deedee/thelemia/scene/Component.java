package com.deedee.thelemia.scene;

public abstract class Component implements IComponent {
    protected boolean enabled = true;

    @Override
    public boolean isEnabled() {
        return enabled;
    }
    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
