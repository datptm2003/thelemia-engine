package com.deedee.thelemia.event.common;

import com.badlogic.gdx.audio.Music;
import com.deedee.thelemia.audio.IMusicEffect;
import com.deedee.thelemia.audio.enumerate.AudioControl;
import com.deedee.thelemia.event.Event;

public class ControlMusicEvent extends Event {
    private final AudioControl control;
    private final Music music;
    private final IMusicEffect effect;
    private final float volume;
    private final boolean loop;

    public ControlMusicEvent(AudioControl control, Music music, float volume, boolean loop) {
        this.control = control;
        this.music = music;
        this.effect = null;
        this.volume = volume;
        this.loop = loop;
    }
    public ControlMusicEvent(AudioControl control, Music music, IMusicEffect effect, float volume, boolean loop) {
        this.control = control;
        this.music = music;
        this.effect = effect;
        this.volume = volume;
        this.loop = loop;
    }
    public ControlMusicEvent(AudioControl control, Music music) {
        this.control = control;
        this.music = music;
        this.effect = null;
        this.volume = 1f;
        this.loop = false;
    }
    public ControlMusicEvent(AudioControl control, Music music, IMusicEffect effect) {
        this.control = control;
        this.music = music;
        this.effect = effect;
        this.volume = 1f;
        this.loop = false;
    }

    public AudioControl getControl() {
        return control;
    }
    public Music getMusic() {
        return music;
    }
    public float getVolume() {
        return volume;
    }
    public boolean isLoop() {
        return loop;
    }
    public IMusicEffect getEffect() {
        return effect;
    }

    @Override
    public String getLog() {
        return "";
    }

}
