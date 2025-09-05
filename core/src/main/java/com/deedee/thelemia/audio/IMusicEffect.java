package com.deedee.thelemia.audio;

import com.badlogic.gdx.audio.Music;
import com.deedee.thelemia.audio.enumerate.EffectType;

public interface IMusicEffect {
    boolean validate(Music music, EffectType effectType);
    void apply(Music music);
}
