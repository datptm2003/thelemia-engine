package com.deedee.thelemia.graphics;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public interface IAssetManager {
    void addUiSkin(String name, Skin skin);
    void addUiSkin(String name, FileHandle skinFile);
    Skin getUiSkin(String name);
}
