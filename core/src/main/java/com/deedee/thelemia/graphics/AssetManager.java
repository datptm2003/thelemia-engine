package com.deedee.thelemia.graphics;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.HashMap;
import java.util.Map;

public class AssetManager implements IAssetManager {
    private final Map<String, Skin> uiSkins = new HashMap<>();

    public AssetManager() {

    }

    private Skin extractSkin(FileHandle skinFile) {
        // TODO: More handle here
        return new Skin(skinFile);
    }

    @Override
    public void addUiSkin(String name, Skin skin) {
        uiSkins.put(name, skin);
    }
    @Override
    public void addUiSkin(String name, FileHandle skinFile) {
        uiSkins.put(name, extractSkin(skinFile));
    }

    @Override
    public Skin getUiSkin(String name) {
        return uiSkins.get(name);
    }
}
