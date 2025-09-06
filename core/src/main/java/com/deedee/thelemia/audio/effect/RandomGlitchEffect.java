package com.deedee.thelemia.audio.effect;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.deedee.thelemia.audio.MusicEffect;
import com.deedee.thelemia.audio.enumerate.EffectType;

import java.util.Random;

public class RandomGlitchEffect extends MusicEffect {
    private final float duration;
    private final float intensity;

    private final Random random = new Random();

    public RandomGlitchEffect(float duration, float intensity) {
        this.duration = duration;
        this.intensity = Math.max(0.1f, Math.min(1f, intensity)); // clamp
    }

    @Override
    public boolean validate(Music target, EffectType effectType) {
        return effectType == EffectType.ON_PLAYING;
    }
    @Override
    public void apply(Music music) {
        applyGlitch(music);
    }

    private void applyGlitch(Music music) {
        final float originalVolume = music.getVolume();
        final boolean wasPlaying = music.isPlaying();

        if (!music.isPlaying()) {
            music.play();
        }

        Timer.schedule(new Task() {
            float elapsed = 0f;

            @Override
            public void run() {
                elapsed += 0.05f;

                // Random chance each tick to glitch
                if (random.nextFloat() < intensity) {
                    int type = random.nextInt(3);
                    switch (type) {
                        case 0: // mute/unmute stutter
                            music.setVolume(random.nextBoolean() ? 0f : originalVolume);
                            break;

                        case 1: // tiny pause/resume
                            if (music.isPlaying()) {
                                music.pause();
                            } else {
                                music.play();
                            }
                            break;

                        case 2: // jump slightly forward/backward
                            float pos = music.getPosition();
                            float jump = (random.nextFloat() - 0.5f) * 0.2f; // ±0.1s
                            float newPos = Math.max(0f, pos + jump);
                            music.setPosition(newPos);
                            elapsed += jump;
                            break;
                    }
                }

                if (elapsed >= duration) {
                    // restore clean playback
                    music.setVolume(originalVolume);
                    if (wasPlaying && !music.isPlaying()) {
                        music.play();
                    }
                    cancel();
                }
            }
        }, 0f, 0.05f); // run every 50ms
    }
}
