package com.deedee.thelemia.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.deedee.thelemia.scene.IGameSystem;

import java.util.*;

public class InputHandler implements IGameSystem, IInputHandler {
    private final InputListener listener = new InputListener(this);
    private final Map<Integer, Vector2> touchPositions = new HashMap<>();
    private final Set<Integer> activeTouches = new HashSet<>();

    private final InputAdapter inputAdapter = new InputAdapter() {
        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            activeTouches.add(pointer);
            touchPositions.put(pointer, new Vector2(screenX, screenY));
            return true;
        }

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            if (activeTouches.contains(pointer)) {
                touchPositions.put(pointer, new Vector2(screenX, screenY));
            }
            return true;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            activeTouches.remove(pointer);
            touchPositions.remove(pointer);
            return true;
        }
    };

    public InputHandler() {
        subscribeListener();
//        Gdx.input.setInputProcessor(stage);
//        Gdx.input.setInputProcessor(inputAdapter);
    }

    @Override
    public void subscribeListener() {

    }
    @Override
    public void update(float delta) {
        // Optional: Could clear transient states like "justTouched" flags if needed
    }
    @Override
    public void dispose() {
        activeTouches.clear();
        touchPositions.clear();
    }
    @Override
    public InputListener getListener() {
        return listener;
    }

    @Override
    public boolean isTouchDown(int pointer) {
        // Modified: Now tracks if a specific pointer is active
        return activeTouches.contains(pointer);
    }
    @Override
    public Vector2 getTouchPosition(int pointer) {
        // Modified: Returns the position or -1, -1 if the pointer is not active
        return touchPositions.getOrDefault(pointer, new Vector2(-1, -1));
    }

    public InputAdapter getInputAdapter() {
        return inputAdapter;
    }
}
