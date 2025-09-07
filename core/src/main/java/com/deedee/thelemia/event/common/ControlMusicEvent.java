package com.deedee.thelemia.event.common;

import com.badlogic.gdx.audio.Music;
import com.deedee.thelemia.audio.MusicEffect;
import com.deedee.thelemia.audio.enumerate.AudioControl;
import com.deedee.thelemia.event.Event;

public class ControlMusicEvent extends Event {
    private final AudioControl control;
    private final Music music;
    private final MusicEffect effect;
    private final float volume;
    private final boolean loop;

    public ControlMusicEvent(AudioControl control, Music music, float volume, boolean loop) {
        super();
        this.control = control;
        this.music = music;
        this.effect = null;
        this.volume = volume;
        this.loop = loop;
    }
    public ControlMusicEvent(AudioControl control, Music music, MusicEffect effect, float volume, boolean loop) {
        super();
        this.control = control;
        this.music = music;
        this.effect = effect;
        this.volume = volume;
        this.loop = loop;
    }
    public ControlMusicEvent(AudioControl control, Music music) {
        super();
        this.control = control;
        this.music = music;
        this.effect = null;
        this.volume = 1f;
        this.loop = false;
    }
    public ControlMusicEvent(AudioControl control, Music music, MusicEffect effect) {
        super();
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
    public MusicEffect getEffect() {
        return effect;
    }

    @Override
    public String getLog() {
        return "";
    }

}
