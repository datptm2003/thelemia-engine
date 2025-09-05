package com.deedee.thelemia.audio;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.event.IEventListener;
import com.deedee.thelemia.event.common.ControlMusicEvent;
import com.deedee.thelemia.event.common.ControlSoundEvent;

public class AudioEventListener implements IEventListener {
    private final AudioEmitter gameSystem;

    public AudioEventListener(AudioEmitter gameSystem) {
        this.gameSystem = gameSystem;
    }

    @Override
    public void onEvent(Event event) {
        if (event instanceof ControlMusicEvent) {
            ControlMusicEvent controlMusicEvent = (ControlMusicEvent) event;
            switch (controlMusicEvent.getControl()) {
                case PLAY_MUSIC:
                    gameSystem.playMusic(controlMusicEvent.getMusic(), controlMusicEvent.getVolume(), controlMusicEvent.isLoop());
                    break;
                case PLAY_MUSIC_WITH_EFFECT:
                    gameSystem.playMusic(controlMusicEvent.getMusic(), controlMusicEvent.getEffect(), controlMusicEvent.getVolume(), controlMusicEvent.isLoop());
                    break;
                case STOP_MUSIC:
                    gameSystem.stopMusic(controlMusicEvent.getMusic());
                    break;
                case STOP_MUSIC_WITH_EFFECT:
                    gameSystem.stopMusic(controlMusicEvent.getMusic(), controlMusicEvent.getEffect());
                    break;
                case PAUSE_MUSIC:
                    gameSystem.pauseMusic(controlMusicEvent.getMusic());
                    break;
                case PAUSE_MUSIC_WITH_EFFECT:
                    gameSystem.pauseMusic(controlMusicEvent.getMusic(), controlMusicEvent.getEffect());
                    break;
                case RESUME_MUSIC_SAME_CONFIG:
                    gameSystem.resumeMusic(controlMusicEvent.getMusic());
                    break;
                case RESUME_MUSIC:
                    gameSystem.resumeMusic(controlMusicEvent.getMusic(), controlMusicEvent.getVolume(), controlMusicEvent.isLoop());
                    break;
                case RESUME_MUSIC_SAME_CONFIG_WITH_EFFECT:
                    gameSystem.resumeMusic(controlMusicEvent.getMusic(), controlMusicEvent.getEffect());
                    break;
                case RESUME_MUSIC_WITH_EFFECT:
                    gameSystem.resumeMusic(controlMusicEvent.getMusic(), controlMusicEvent.getEffect(), controlMusicEvent.getVolume(), controlMusicEvent.isLoop());
                    break;
                case APPLY_PLAYING_EFFECT:
                    gameSystem.applyPlayingEffect(controlMusicEvent.getMusic(), controlMusicEvent.getEffect());
            }

        } else if (event instanceof ControlSoundEvent) {
            ControlSoundEvent controlSoundEvent = (ControlSoundEvent) event;
            switch (controlSoundEvent.getControl()) {
                case PLAY_SOUND:
                    gameSystem.playSound(controlSoundEvent.getSound(), controlSoundEvent.getVolume());
                    break;
                case PLAY_SOUND_WITH_TWEAK:
                    gameSystem.playSound(controlSoundEvent.getSound(), controlSoundEvent.getVolume(), controlSoundEvent.getPitch(), controlSoundEvent.getPan());
                    break;
                case STOP_SOUND:
                    gameSystem.stopSound(controlSoundEvent.getSound());
                    break;
                case LOOP_SOUND:
                    gameSystem.loopSound(controlSoundEvent.getSound(), controlSoundEvent.getVolume());
                    break;
                case LOOP_SOUND_WITH_TWEAK:
                    gameSystem.loopSound(controlSoundEvent.getSound(), controlSoundEvent.getVolume(), controlSoundEvent.getPitch(), controlSoundEvent.getPan());
                    break;
            }

        }
    }

}
