package com.deedee.thelemia.scene;

import com.badlogic.gdx.assets.AssetManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssetStorage implements IAssetStorage {
    private final AssetManager manager = new AssetManager();
    private final Map<String, String> aliases = new HashMap<>();

    @Override
    public void addAlias(String alias, String file) {
        aliases.put(alias, file);
    }
    @Override
    public void removeAlias(String alias) {
        aliases.remove(alias);
    }
    @Override
    public boolean hasAlias(String alias) {
        return aliases.containsKey(alias);
    }

    @Override
    public <T> void load(String alias, Class<T> type) {
        String file = aliases.get(alias);
        if (file == null) return;

        manager.load(file, type);
    }
    @Override
    public <T> void loadGroup(List<String> aliases, Class<T> type) {
        for (String a : aliases) {
            load(a, type);
        }
    }

    @Override
    public void unload(String alias) {
        String file = aliases.get(alias);
        if (file == null) return;

        manager.unload(file);
    }
    @Override
    public void unloadGroup(List<String> aliases) {
        for (String a : aliases) {
            unload(a);
        }
    }
    @Override
    public void unloadAll() {
        for (String file : aliases.values()) {
            manager.unload(file);
        }
    }

    @Override
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
