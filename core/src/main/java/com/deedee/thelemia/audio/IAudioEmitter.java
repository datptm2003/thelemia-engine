package com.deedee.thelemia.audio;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public interface IAudioEmitter {
    void playSound(Sound sound, float volume);
    void playSound(Sound sound, float volume, float pitch, float pan);
    void stopSound(Sound sound);

    void loopSound(Sound sound, float volume);
    void loopSound(Sound sound, float volume, float pitch, float pan);

    boolean playMusic(Music music, float volume, boolean loop);
    boolean playMusic(Music music, MusicEffect effect, float volume, boolean loop);

    boolean stopMusic(Music music);
    boolean stopMusic(Music music, MusicEffect effect);

    boolean pauseMusic(Music music);
    boolean pauseMusic(Music music, MusicEffect effect);

    boolean resumeMusic(Music music);
    boolean resumeMusic(Music music, float volume, boolean loop);

    boolean resumeMusic(Music music, MusicEffect effect);
    boolean resumeMusic(Music music, MusicEffect effect, float volume, boolean loop);

    boolean applyPlayingEffect(Music music, MusicEffect effect);
}
