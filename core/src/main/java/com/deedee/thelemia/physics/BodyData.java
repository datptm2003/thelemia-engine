package com.deedee.thelemia.physics;

public class BodyData {
    private final String name;
    private final short categoryMask;
    private final short collisionMask;

    public BodyData(String name, short categoryMask, short collisionMask) {
        this.name = name;
        this.categoryMask = categoryMask;
        this.collisionMask = collisionMask;
    }

    public String getName() {
        return name;
    }
    public short getCategoryMask() {
        return categoryMask;
    }
    public short getCollisionMask() {
        return collisionMask;
    }
}
