package com.deedee.thelemia.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.deedee.thelemia.audio.enumerate.EffectType;

public interface IAudioEmitter {
    void playSound(Sound sound, float volume);
    void playSound(Sound sound, float volume, float pitch, float pan);
    void stopSound(Sound sound);

    void loopSound(Sound sound, float volume);
    void loopSound(Sound sound, float volume, float pitch, float pan);

    boolean playMusic(Music music, float volume, boolean loop);
    boolean playMusic(Music music, IMusicEffect effect, float volume, boolean loop);

    boolean stopMusic(Music music);
    boolean stopMusic(Music music, IMusicEffect effect);

    boolean pauseMusic(Music music);
    boolean pauseMusic(Music music, IMusicEffect effect);

    boolean resumeMusic(Music music);
    boolean resumeMusic(Music music, float volume, boolean loop);

    boolean resumeMusic(Music music, IMusicEffect effect);
    boolean resumeMusic(Music music, IMusicEffect effect, float volume, boolean loop);

    boolean applyPlayingEffect(Music music, IMusicEffect effect);
}
