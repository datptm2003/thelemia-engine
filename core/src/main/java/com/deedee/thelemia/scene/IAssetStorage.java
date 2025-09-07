package com.deedee.thelemia.scene;

import java.util.List;

public interface IAssetStorage {
    void addAlias(String alias, String file);
    void removeAlias(String alias);
    boolean hasAlias(String alias);

    <T> void load(String alias, Class<T> type);
    <T> void loadGroup(List<String> aliases, Class<T> type);

    void unload(String alias);
    void unloadGroup(List<String> aliases);
    void unloadAll();

    <T> T get(String alias, Class<T> type);

}
