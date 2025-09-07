package com.deedee.thelemia.event.common;

import com.badlogic.gdx.audio.Sound;
import com.deedee.thelemia.audio.enumerate.AudioControl;
import com.deedee.thelemia.event.Event;

public class ControlSoundEvent extends Event {
    private final AudioControl control;
    private final Sound sound;
    private final float volume;
    private final float pitch;
    private final float pan;

    public ControlSoundEvent(AudioControl control, Sound sound, float volume, float pitch, float pan) {
        super();
        this.control = control;
        this.sound = sound;
        this.volume = volume;
        this.pitch = pitch;
        this.pan = pan;
    }
    public ControlSoundEvent(AudioControl control, Sound sound, float volume) {
        super();
        this.control = control;
        this.sound = sound;
        this.volume = volume;
        this.pitch = 1f;
        this.pan = 0f;
    }

    public AudioControl getControl() {
        return control;
    }
    public Sound getSound() {
        return sound;
    }
    public float getVolume() {
        return volume;
    }
    public float getPitch() {
        return pitch;
    }
    public float getPan() {
        return pan;
    }

    @Override
    public String getLog() {
        return "";
    }
}
