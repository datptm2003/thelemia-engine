package com.deedee.thelemia.audio;

import com.badlogic.gdx.audio.Music;
import com.deedee.thelemia.audio.enumerate.EffectType;

public abstract class MusicEffect {
    public abstract boolean validate(Music music, EffectType effectType);
    public abstract void apply(Music music);
}
