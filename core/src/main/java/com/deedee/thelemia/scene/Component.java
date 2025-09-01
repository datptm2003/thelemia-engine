package com.deedee.thelemia.scene;

public abstract class Component implements IComponent {
    protected final Entity owner;
    protected boolean enabled = true;

    public Component(Entity owner) {
        this.owner = owner;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Entity getOwner() {
        return owner;
    }

}
