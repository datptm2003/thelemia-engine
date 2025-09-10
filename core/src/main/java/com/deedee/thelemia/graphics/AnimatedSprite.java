package com.deedee.thelemia.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnimatedSprite extends RenderableObject {
    private final Map<String, Animation<TextureRegion>> animations = new HashMap<>();
    private String currentAnimation = null;
    private float timeframe = 0f;
    private boolean loaded = false;

    public AnimatedSprite(Skin skin) {
        super(skin);
    }

    public void loadAll(String filePath, Map<Integer, String> nameMap, int cols, float frameDuration) {
        Texture sheet = new Texture(Gdx.files.internal(filePath));
        sheet.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        int frameRows = nameMap.size();
        TextureRegion[][] tmp = TextureRegion.split(
            sheet,
            sheet.getWidth() / cols,
            sheet.getHeight() / frameRows
        );

        for (Map.Entry<Integer, String> entry : nameMap.entrySet()) {
            int row = entry.getKey();
            String name = entry.getValue();

            TextureRegion[] frames = new TextureRegion[cols];
            System.arraycopy(tmp[row], 0, frames, 0, cols);

            Animation<TextureRegion> animation = new Animation<>(frameDuration, frames);
            animations.put(name, animation);

        }
        loaded = true;
    }
    public void load(String filePath, String name, int rows, int cols, float frameDuration) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("rows and cols must be > 0");
        }

        Texture sheet = new Texture(Gdx.files.internal(filePath));
        sheet.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        // Split into rows x cols
        TextureRegion[][] tmp = TextureRegion.split(
            sheet,
            sheet.getWidth() / cols,
            sheet.getHeight() / rows
        );

        // Flatten rows into one long frame array: row0 col0..colN, row1 col0..colN, ...
        int totalFrames = rows * cols;
        TextureRegion[] frames = new TextureRegion[totalFrames];
        int idx = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                frames[idx++] = tmp[r][c];
            }
        }

        Animation<TextureRegion> animation = new Animation<>(frameDuration, frames);
        animation.setPlayMode(Animation.PlayMode.LOOP); // typical for sprites; remove/change if needed

        animations.put(name, animation);
        loaded = true;
    }

    @Override
    public void create() {
        super.create();
    }
    @Override
    public void start() {
        super.start();
    }

    @Override
    public void update(float delta) {
        if (currentAnimation == null) return;
        if (!isStarted) start();
        if (isStopped) stop();

        timeframe += delta;
    }

    @Override
    public void stop() {
        super.stop();
    }
    @Override
    public void dispose() {
        super.dispose();
        Set<Texture> disposed = new HashSet<>();
        for (Animation<TextureRegion> anim : animations.values()) {
            TextureRegion[] keyFrames = anim.getKeyFrames();
            if (keyFrames.length > 0) {
                Texture tex = keyFrames[0].getTexture();
                if (!disposed.contains(tex)) {
                    tex.dispose();
                    disposed.add(tex);
                }
            }
        }
        animations.clear();
    }

    public void setAnimation(String key) {
        if (animations.containsKey(key)) {
            currentAnimation = key;
            timeframe = 0f; // reset on switch
        }
    }

    public void draw(SpriteBatch batch, float x, float y, float originX, float originY, float scaleX, float scaleY, float rotation) {
        if (currentAnimation == null) return;

        TextureRegion region = getCurrentAnimation().getKeyFrame(timeframe);
        float width = region.getRegionWidth();
        float height = region.getRegionHeight();

        batch.draw(region, x, y, originX, originY, width, height, scaleX, scaleY, rotation);
    }

    public Animation<TextureRegion> getCurrentAnimation() {
        return animations.get(currentAnimation);
    }
    public void setCurrentAnimation(String currentAnimation) {
        this.currentAnimation = currentAnimation;
    }
    public float getTimeframe() {
        return timeframe;
    }

    public boolean isLoaded() {
        return loaded;
    }
}
