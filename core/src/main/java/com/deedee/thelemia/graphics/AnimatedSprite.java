package com.deedee.thelemia.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.RenderAnimatedSpriteEvent;
import com.deedee.thelemia.scene.component.TransformComponent;

import java.util.HashMap;
import java.util.Map;

public class AnimatedSprite extends GraphicsObject implements IAnimatedSprite {
    private final Map<String, Animation<TextureRegion>> animations = new HashMap<>();
    private String currentAnimation = null;
    private float timeframe = 0f;

    public AnimatedSprite(Skin skin, String filePath, Map<Integer, String> nameMap, int cols, float frameDuration) {
        super(skin);
        load(filePath, nameMap, cols, frameDuration);
    }

    private void load(String filePath, Map<Integer, String> nameMap, int cols, float frameDuration) {
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
    }

    @Override
    public void update(float delta) {
        timeframe += delta;
    }
    @Override
    public void render(TransformComponent transform) {
        if (currentAnimation == null) return;

        EventBus.getInstance().post(new RenderAnimatedSpriteEvent(this, transform));
    }
    @Override
    public void dispose() {
        super.dispose();
        for (Animation<TextureRegion> anim : animations.values()) {
            if (anim.getKeyFrames().length > 0) {
                Texture tex = anim.getKeyFrames()[0].getTexture();
                tex.dispose();
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

    public Animation<TextureRegion> getCurrentAnimation() {
        return animations.get(currentAnimation);
    }
    public void setCurrentAnimation(String currentAnimation) {
        this.currentAnimation = currentAnimation;
    }
    public float getTimeframe() {
        return timeframe;
    }
}
