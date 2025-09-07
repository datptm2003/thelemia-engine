package com.deedee.thelemia.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileSystem {
    private static final String TAG = "FileSystem";
    private FileSystem() {} // no instances

    // ---------- existing basic helpers ----------
    public static String readFile(String path) {
        FileHandle file = Gdx.files.local(path);
        if (!file.exists()) return null;

        return file.readString();
    }

    public static void writeFile(String path, String data, boolean append) {
        FileHandle file = Gdx.files.local(path);
        // Ensure parent directory exists
        boolean parentExists = ensureParentDirectory(file);
        if (!parentExists) return;

        file.writeString(data, append);
    }

    public static boolean fileExists(String path) {
        FileHandle file = Gdx.files.local(path);
        return file.exists();
    }

    public static byte[] readBytes(String path) {
        FileHandle file = Gdx.files.local(path);
        if (!file.exists()) return null;

        return file.readBytes();
    }

    public static void writeBytes(String path, byte[] data, boolean append) {
        FileHandle file = Gdx.files.local(path);
        ensureParentDirectory(file);
        file.writeBytes(data, append);
    }

    public static FileHandle getFileHandle(String path) {
        return Gdx.files.local(path);
    }

    // ---------- JSON (de)serialization ----------
    /**
     * Read JSON from local file and deserialize into a class instance.
     * Returns null if file doesn't exist or parsing fails.
     */
    public static <T> T readJson(String path, Class<T> type) {
        String raw = readFile(path);
        if (raw == null) return null;

        try {
            Json json = new Json();
            return json.fromJson(type, raw);
        } catch (Exception e) {
            Gdx.app.error(TAG, "Failed to read/parse JSON: " + path, e);
            return null;
        }
    }

    /**
     * Read JSON as a JsonValue (useful for flexible/partial parsing).
     * Returns null if file doesn't exist or parsing fails.
     */
    public static JsonValue readJsonValue(String path) {
        String raw = readFile(path);
        if (raw == null) return null;
        try {
            JsonReader reader = new JsonReader();
            return reader.parse(raw);
        } catch (Exception e) {
            Gdx.app.error(TAG, "Failed to parse JSON value: " + path, e);
            return null;
        }
    }

    /**
     * Write object as JSON to local file.
     * If pretty == true, output will be pretty-printed.
     * Overwrites existing file.<br>
     * NOTE: does not do atomic/safe write. For safety use safeWriteJson.
     */
    public static <T> boolean writeJson(String path, T object, boolean pretty) {
        try {
            Json json = new Json();
            if (pretty) {
                json.setOutputType(JsonWriter.OutputType.json); // pretty
            } else {
                json.setOutputType(JsonWriter.OutputType.minimal); // compact
            }
            String out = json.toJson(object);
            writeFile(path, out, false);
            return true;
        } catch (Exception e) {
            Gdx.app.error(TAG, "Failed to write JSON: " + path, e);
            return false;
        }
    }

    /**
     * Safe JSON write: writes to a temporary file then copies over the target.
     * This reduces the chance of corrupting an existing save if the write fails.
     */
    public static <T> boolean safeWriteJson(String path, T object, boolean pretty) {
        FileHandle target = Gdx.files.local(path);
        FileHandle tmp = Gdx.files.local(path + ".tmp");

        try {
            Json json = new Json();
            if (pretty) json.setOutputType(JsonWriter.OutputType.json);
            else json.setOutputType(JsonWriter.OutputType.minimal);
            String out = json.toJson(object);

            ensureParentDirectory(tmp);
            tmp.writeString(out, false);            // write temporary
            tmp.copyTo(target);                     // replace target
            tmp.delete();                           // remove temp
            return true;
        } catch (Exception e) {
            Gdx.app.error(TAG, "Failed to safe-write JSON: " + path, e);
            try { if (tmp.exists()) tmp.delete(); } catch (Exception ignored) {}
            return false;
        }
    }

    /**
     * Read JSON but return defaultValue when file missing or parse fails.
     */
    public static <T> T safeReadJson(String path, Class<T> type, T defaultValue) {
        T v = readJson(path, type);
        return v != null ? v : defaultValue;
    }

    // ---------- file/directory helpers ----------
    /**
     * Ensure the parent directory for a FileHandle exists.
     */
    private static boolean ensureParentDirectory(FileHandle handle) {
        try {
            FileHandle parent = handle.parent();
            if (parent != null && !parent.exists()) {
                // parent may be a file handle to a directory; create via java.io.File to be safe
                return parent.file().mkdirs();
            }
        } catch (Exception e) {
            // best effort; log and continue
            Gdx.app.error(TAG, "Failed to ensure parent directory for: " + handle.path(), e);
        }
        return false;
    }

    public static boolean deleteFile(String path) {
        FileHandle file = Gdx.files.local(path);
        if (!file.exists()) return false;
        try {
            return file.delete();
        } catch (Exception e) {
            Gdx.app.error(TAG, "Failed to delete file: " + path, e);
            return false;
        }
    }

    public static boolean copyFile(String srcPath, String destPath, boolean overwrite) {
        FileHandle src = Gdx.files.local(srcPath);
        if (!src.exists()) return false;
        FileHandle dest = Gdx.files.local(destPath);
        try {
            if (dest.exists() && !overwrite) return false;
            ensureParentDirectory(dest);
            src.copyTo(dest);
            return true;
        } catch (Exception e) {
            Gdx.app.error(TAG, "Failed to copy file: " + srcPath + " -> " + destPath, e);
            return false;
        }
    }

    public static boolean moveFile(String srcPath, String destPath, boolean overwrite) {
        boolean copied = copyFile(srcPath, destPath, overwrite);
        if (!copied) return false;
        return deleteFile(srcPath);
    }

    /**
     * List file names in a directory (non-recursive by default).
     * Returns empty list for missing directory.
     */
    public static List<String> listFiles(String dirPath, boolean recursive) {
        FileHandle dir = Gdx.files.local(dirPath);
        if (!dir.exists() || !dir.isDirectory()) return Collections.emptyList();

        try {
            List<String> names = new ArrayList<>();
            if (!recursive) {
                FileHandle[] children = dir.list();
                for (FileHandle f : children) names.add(f.path());
            } else {
                // manual recursive traversal
                listFilesRecursive(dir, names);
            }
            return names;
        } catch (Exception e) {
            Gdx.app.error(TAG, "Failed to list files in: " + dirPath, e);
            return Collections.emptyList();
        }
    }

    /**
     * Helper to recursively collect file and directory paths.
     * Adds the entry's path and, if it's a directory, descends into it.
     */
    private static void listFilesRecursive(FileHandle dir, List<String> out) {
        FileHandle[] children = dir.list();
        if (children == null) return;
        for (FileHandle f : children) {
            out.add(f.path());
            if (f.isDirectory()) {
                listFilesRecursive(f, out);
            }
        }
    }

    public static boolean ensureDirectoryExists(String dirPath) {
        try {
            FileHandle dir = Gdx.files.local(dirPath);
            if (dir.exists() && dir.isDirectory()) return true;
            boolean result = dir.file().mkdirs();
            return dir.exists() && dir.isDirectory();
        } catch (Exception e) {
            Gdx.app.error(TAG, "Failed to create directory: " + dirPath, e);
            return false;
        }
    }

}
