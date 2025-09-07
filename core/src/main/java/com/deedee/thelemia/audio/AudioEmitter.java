package com.deedee.thelemia.audio;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.deedee.thelemia.audio.enumerate.EffectType;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.ControlMusicEvent;
import com.deedee.thelemia.event.common.ControlSoundEvent;
import com.deedee.thelemia.scene.GameSystem;

public class AudioEmitter extends GameSystem implements IAudioEmitter {
    private final AudioEventListener listener = new AudioEventListener(this);

    public AudioEmitter() {
        subscribeListener();
    }

    @Override
    public void subscribeListener() {
        EventBus.getInstance().subscribe(ControlMusicEvent.class, listener);
        EventBus.getInstance().subscribe(ControlSoundEvent.class, listener);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void dispose() {

    }

    @Override
    public AudioEventListener getListener() {
        return listener;
    }

    @Override
    public void playSound(Sound sound, float volume) {
        sound.play(volume);
    }
    @Override
    public void playSound(Sound sound, float volume, float pitch, float pan) {
        sound.play(volume, pitch, pan);
    }
    @Override
    public void stopSound(Sound sound) {
        sound.stop();
    }

    @Override
    public void loopSound(Sound sound, float volume) {
        sound.loop(volume);
    }
    @Override
    public void loopSound(Sound sound, float volume, float pitch, float pan) {
        sound.loop(volume, pitch, pan);
    }

    @Override
    public boolean playMusic(Music music, float volume, boolean loop) {
        if (music.isPlaying()) return false;

        music.setVolume(volume);
        music.setLooping(loop);
        music.play();
        return true;
    }
    @Override
    public boolean playMusic(Music music, MusicEffect effect, float volume, boolean loop) {
        if (!effect.validate(music, EffectType.ON_START)) return false;

        music.setVolume(volume);
        music.setLooping(loop);
        effect.apply(music);
        return true;
    }

    @Override
    public boolean stopMusic(Music music) {
        if (!music.isPlaying()) return false;

        music.stop();
        music.setVolume(1f);
        music.setLooping(false);
        return true;
    }
    @Override
    public boolean stopMusic(Music music, MusicEffect effect) {
        if (!effect.validate(music, EffectType.ON_STOP)) return false;

        effect.apply(music);
        return true;
    }

    @Override
    public boolean pauseMusic(Music music) {
        if (!music.isPlaying()) return false;

        music.pause();
        return true;
    }
    @Override
    public boolean pauseMusic(Music music, MusicEffect effect) {
        if (!effect.validate(music, EffectType.ON_PAUSE)) return false;

        effect.apply(music);
        return true;
    }

    @Override
    public boolean resumeMusic(Music music) {
        if (music.isPlaying()) return false;

        music.play();
        return true;
    }
    @Override
    public boolean resumeMusic(Music music, float volume, boolean loop) {
        if (music.isPlaying()) return false;

        music.setVolume(volume);
        music.setLooping(loop);
        music.play();
        return true;
    }

    @Override
    public boolean resumeMusic(Music music, MusicEffect effect) {
        if (!effect.validate(music, EffectType.ON_RESUME)) return false;

        effect.apply(music);
        return true;
    }
    @Override
    public boolean resumeMusic(Music music, MusicEffect effect, float volume, boolean loop) {
        if (!effect.validate(music, EffectType.ON_RESUME)) return false;

        music.setVolume(volume);
        music.setLooping(loop);
        effect.apply(music);
        return true;
    }

    @Override
    public boolean applyPlayingEffect(Music music, MusicEffect effect) {
        if (!effect.validate(music, EffectType.ON_PLAYING)) return false;

        effect.apply(music);
        return true;
    }
}
