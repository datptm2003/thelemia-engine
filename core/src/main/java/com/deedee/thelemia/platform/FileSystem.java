package com.deedee.thelemia.platform;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class FileSystem {

    public String readFile(String path) {
        FileHandle file = Gdx.files.local(path);
        if (!file.exists()) return null;
        return file.readString();
    }

    public void writeFile(String path, String data, boolean append) {
        FileHandle file = Gdx.files.local(path);
        file.writeString(data, append);
    }

    public boolean fileExists(String path) {
        FileHandle file = Gdx.files.local(path);
        return file.exists();
    }
}
