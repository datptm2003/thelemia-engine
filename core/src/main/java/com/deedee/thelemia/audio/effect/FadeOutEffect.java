package com.deedee.thelemia.audio.effect;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.deedee.thelemia.audio.MusicEffect;
import com.deedee.thelemia.audio.enumerate.EffectType;

public class FadeOutEffect extends MusicEffect {
    private final float duration;

    public FadeOutEffect(float duration) {
        this.duration = duration;
    }

    @Override
    public boolean validate(Music music, EffectType effectType) {
        return (effectType == EffectType.ON_STOP);
    }
    @Override
    public void apply(Music music) {
        applyFadeOut(music, duration);
    }

    private void applyFadeOut(Music music, float duration) {
        float initialVolume = music.getVolume();

        Timer.schedule(new Task() {
            float elapsed = 0f;
            @Override
            public void run() {
                elapsed += 0.05f;
                float progress = Math.min(1f, elapsed / duration);
                float newVolume = initialVolume * (1f - progress);
                music.setVolume(newVolume);

                if (progress >= 1f) {
                    music.stop();  // stop after fade completes
                    cancel();
                }
            }
        }, 0f, 0.05f);
    }
}
