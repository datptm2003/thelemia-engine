package com.deedee.thelemia.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;

import java.util.List;
import java.util.ArrayList;

public class Particles extends RenderableObject {
    protected ParticleEffect template;
    protected ParticleEffectPool pool;
    protected final List<PooledEffect> activeEffects = new ArrayList<>();

    protected int defaultPoolInitial = 8;
    protected int defaultPoolMax = 50;

    protected final Vector2 position = new Vector2();

    protected boolean loadedWithAtlas = false;
    protected boolean loop = false;

    public Particles(Skin skin, String pPath, int poolInitial, int poolMax) {
        super(skin);
        defaultPoolInitial = poolInitial;
        defaultPoolMax = poolMax;
        load(pPath);
    }
    public Particles(Skin skin, String pPath) {
        super(skin);
        load(pPath);
    }

    private void load(String pPath) {
        FileHandle pFile = Gdx.files.internal(pPath);
        TextureAtlas atlas = null;
        try {
            atlas = skin.getAtlas();
        } catch (Exception ignored) {

        }

        if (atlas != null) {
            List<String> refs = parseImagePathsFromP(pFile);
            boolean allFound = true;
            for (String ref : refs) {
                String basename = ref;
                int lastSlash = Math.max(basename.lastIndexOf('/'), basename.lastIndexOf('\\'));
                if (lastSlash >= 0) basename = basename.substring(lastSlash + 1);
                String noExt = basename;
                int dot = basename.lastIndexOf('.');
                if (dot > 0) noExt = basename.substring(0, dot);

                if (atlas.findRegion(noExt) == null && atlas.findRegion(basename) == null) {
                    allFound = false;
                    break;
                }
            }

            if (allFound) {
                Gdx.app.log("Particles", "Loading .p using Skin atlas: " + pFile.path());
                template = new ParticleEffect();
                template.load(pFile, atlas);
                loadedWithAtlas = true;
                createPool(defaultPoolInitial, defaultPoolMax);
                return;
            } else {
                Gdx.app.log("Particles", "Atlas present but missing referenced regions; falling back to folder load.");
            }
        }
        loadFromFolder(pFile);
    }

    public void loadFromFolder(FileHandle pFile) {
        template = new ParticleEffect();

        List<String> refs = parseImagePathsFromP(pFile);
        List<String> missing = new ArrayList<>();
        for (String ref : refs) {
            String basename = ref;
            int lastSlash = Math.max(basename.lastIndexOf('/'), basename.lastIndexOf('\\'));
            if (lastSlash >= 0) basename = basename.substring(lastSlash + 1);

            FileHandle candidate = pFile.parent().child(basename);
            if (!candidate.exists()) {
                boolean found = false;
                if (!basename.toLowerCase().endsWith(".png")) {
                    if (pFile.parent().child(basename + ".png").exists()) found = true;
                    else if (pFile.parent().child(basename + ".jpg").exists()) found = true;
                }
                if (!found) missing.add(basename);
            }
        }

        if (!missing.isEmpty()) {
            Gdx.app.error("Particles", "Missing image files referenced by " + pFile.path() +
                ". Make sure these files exist in the same folder: " + missing);
        }

        template.load(pFile, pFile.parent());
        loadedWithAtlas = false;
        createPool(defaultPoolInitial, defaultPoolMax);
    }

    private List<String> parseImagePathsFromP(FileHandle pFile) {
        List<String> result = new ArrayList<>();
        String text = pFile.readString();
        String[] lines = text.split("\\r?\\n");
        boolean inImagePath = false;
        for (String raw : lines) {
            String line = raw.trim();
            if (line.isEmpty()) {
                if (inImagePath) inImagePath = false;
                continue;
            }
            if (line.startsWith("-")) {
                inImagePath = line.equalsIgnoreCase("- Image Path -");
                continue;
            }
            if (inImagePath) {
                if (!line.contains(":")) result.add(line);
            }
        }
        // fallback scan for png lines
        if (result.isEmpty()) {
            for (String raw : lines) {
                String l = raw.trim();
                if (l.toLowerCase().matches(".*\\.(png|jpg|jpeg)$")) {
                    String[] toks = l.split("\\s+");
                    result.add(toks[toks.length - 1]);
                }
            }
        }
        return result;
    }

    protected void createPool(int initial, int max) {
        pool = new ParticleEffectPool(template, Math.max(1, initial), Math.max(initial, max));
    }

    public PooledEffect spawn(float x, float y) {
        if (pool == null) {
            throw new IllegalStateException("Particles not loaded. Call load(...) first.");
        }

        PooledEffect e = pool.obtain();
        e.setPosition(x, y);
        e.start();
        activeEffects.add(e);

        position.x = x;
        position.y = y;
        setStarted(true);
        setStopped(false);
        return e;
    }
    public PooledEffect spawn() {
        return spawn(position.x, position.y);
    }

    public void draw(SpriteBatch batch) {
        for (PooledEffect pooledEffect : activeEffects) {
            pooledEffect.draw(batch);
        }
    }
    public void clear() {
        for (int i = activeEffects.size() - 1; i >= 0; i--) {
            PooledEffect e = activeEffects.remove(i);
            try {
                e.free();
            } catch (Exception ignored) { }
        }
    }

    public void allowCompletion() {
        for (PooledEffect e : activeEffects) {
            try {
                Array<ParticleEmitter> emitters = e.getEmitters();
                for (int j = 0; j < emitters.size; j++) {
                    emitters.get(j).setContinuous(false);
                }
            } catch (Exception ignored) {
            }
        }
    }
    public void setEmittersCleanUpBlendFunction(boolean value) {
        try {
            if (template != null) template.setEmittersCleanUpBlendFunction(value);
        } catch (Exception ignored) {}
        for (PooledEffect pooledEffect : activeEffects) {
            try {
                pooledEffect.setEmittersCleanUpBlendFunction(value);
            } catch (Exception ignored) {

            }
        }
    }

    @Override
    public void create() {
        super.create();
    }
    @Override
    public void start() {
        super.start();
        if (pool != null && activeEffects.isEmpty()) {
            spawn(position.x, position.y);
        }
    }

    @Override
    public void update(float delta) {
        if (!isStarted()) start();
        if (isStopped()) {
            // if stopped we can clear immediately (or choose to let them finish if desired)
            clear();
            return;
        }

        // update and recycle completed
        for (int i = activeEffects.size() - 1; i >= 0; i--) {
            PooledEffect e = activeEffects.get(i);
            e.update(delta);
            if (e.isComplete()) {
                e.free();
                activeEffects.remove(i);
            }
        }

        if (loop && activeEffects.isEmpty() && !isStopped() && isStarted()) {
            spawn(position.x, position.y);
        }
    }

    @Override
    public void stop() {
        super.stop();
        // immediate free of active instances by default
        clear();
        setStopped(true);
        setStarted(false);
    }
    @Override
    public void dispose() {
        clear();
        template = null;
        pool = null;
    }

    public ParticleEffect getTemplate() {
        return template;
    }
    public int getActiveCount() {
        return activeEffects.size();
    }
    public List<PooledEffect> getActiveEffects() {
        return activeEffects;
    }

    public boolean isLoaded() {
        return template != null && pool != null;
    }
    public boolean isLooping() {
        return loop;
    }
    public void setLoop(boolean loop) {
        this.loop = loop;
        // if enabling loop, and we are started with no active effects, start immediately
        if (loop && isStarted() && activeEffects.isEmpty() && !isStopped() && pool != null) {
            spawn(position.x, position.y);
        }
    }

    public Vector2 getPosition() {
        return position;
    }
    public void setPosition(float x, float y) {
        this.position.x = x;
        this.position.y = y;
    }
}
