package com.deedee.thelemia.ai.btree;

import com.deedee.thelemia.scene.Entity;

import java.util.HashMap;
import java.util.Map;

public class Blackboard {
    private final Entity owner;
    private final Map<String, Object> data = new HashMap<>();

    public Blackboard(Entity owner) {
        this.owner = owner;
    }

    public Entity getOwner() {
        return owner;
    }

    public <T> T get(String key, Class<T> valueType) {
        return valueType.cast(data.get(key));
    }
    public void set(String key, Object value) {
        data.put(key, value);
    }
}
