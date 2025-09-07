package com.deedee.thelemia.audio.effect;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.deedee.thelemia.audio.MusicEffect;
import com.deedee.thelemia.audio.enumerate.EffectType;

public class FadeInEffect extends MusicEffect {
    private final float duration;

    public FadeInEffect(float duration) {
        super();
        this.duration = duration;
    }

    @Override
    public boolean validate(Music music, EffectType effectType) {
        return (effectType == EffectType.ON_START || effectType == EffectType.ON_RESUME) && !music.isPlaying();
    }
    @Override
    public void apply(Music music) {
        boolean loop = music.isLooping();
        music.setLooping(false);
        applyFadeIn(music);

        music.setOnCompletionListener(completedMusic -> {
            if (loop) {
                applyFadeIn(completedMusic);
            }
        });
    }

    private void applyFadeIn(Music music) {
        float maxVolume = music.getVolume();
        music.setVolume(0f);
        music.play();

        Timer.schedule(new Task() {
            float elapsed = 0f;
            @Override
            public void run() {
                elapsed += 0.05f;
                float progress = Math.min(1f, elapsed / duration);
                music.setVolume(progress * maxVolume);

                if (progress >= 1f) {
                    cancel();
                }
            }
        }, 0f, 0.05f);
    }

}
