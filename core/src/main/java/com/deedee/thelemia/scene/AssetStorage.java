package com.deedee.thelemia.scene;

import com.badlogic.gdx.assets.AssetManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssetStorage {
    private final AssetManager manager = new AssetManager();
    private final Map<String, String> aliases = new HashMap<>();

    public AssetStorage() {

    }

    public void addAlias(String alias, String file) {
        aliases.put(alias, file);
    }
    public void removeAlias(String alias) {
        aliases.remove(alias);
    }
    public boolean hasAlias(String alias) {
        return aliases.containsKey(alias);
    }

    public <T> void load(String alias, Class<T> type) {
        String file = aliases.get(alias);
        if (file == null) return;

        manager.load(file, type);
    }
    public <T> void loadGroup(List<String> aliases, Class<T> type) {
        for (String a : aliases) {
            load(a, type);
        }
    }

    public void unload(String alias) {
        String file = aliases.get(alias);
        if (file == null) return;

        manager.unload(file);
    }
    public void unloadGroup(List<String> aliases) {
        for (String a : aliases) {
            unload(a);
        }
    }
    public void unloadAll() {
        for (String file : aliases.values()) {
            manager.unload(file);
        }
    }

    public <T> T get(String alias, Class<T> type) {
        if (!aliases.containsKey(alias) || !manager.isLoaded(aliases.get(alias), type)) {
            return null;
        }
        return manager.get(aliases.get(alias), type);
    }

    public AssetManager getAssetManager() {
        return manager;
    }
}
