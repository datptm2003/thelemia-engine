package com.deedee.thelemia.scene;

public interface IAssetStorage {
    void addAlias(String alias, String file);
    void removeAlias(String alias);
    boolean hasAlias(String alias);

    <T> void load(String alias, Class<T> type);
    void unload(String alias);
    void unloadAll();
    <T> T get(String alias, Class<T> type);

}
