package com.deedee.thelemia.scene;

public abstract class Component implements IComponent {
    protected final Entity owner;
    protected boolean enabled = true;

    public Component(Entity owner) {
        this.owner = owner;
    }

    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Entity getOwner() {
        return owner;
    }

}
