package com.deedee.thelemia.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.ChangeInputAdapterEvent;
import com.deedee.thelemia.scene.IGameSystem;

import java.util.*;

public class InputHandler implements IGameSystem, IInputHandler {
    private final InputListener listener = new InputListener(this);

    private final Stage stage;
    private final InputMultiplexer multiplexer = new InputMultiplexer();

    public InputHandler(Stage stage) {
        subscribeListener();
        this.stage = stage;
        multiplexer.addProcessor(stage);
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void subscribeListener() {
        EventBus.getInstance().subscribe(ChangeInputAdapterEvent.class, listener);
    }
    @Override
    public void update(float delta) {

    }
    @Override
    public void dispose() {

    }
    @Override
    public InputListener getListener() {
        return listener;
    }

    public void changeInputAdapter(InputAdapter nextInputAdapter) {
        if (nextInputAdapter == null) {
            multiplexer.clear();
            multiplexer.addProcessor(stage);
            Gdx.input.setInputProcessor(multiplexer);
        } else {
            multiplexer.clear();
            multiplexer.addProcessor(stage);
            multiplexer.addProcessor(nextInputAdapter);
            Gdx.input.setInputProcessor(multiplexer);
        }
    }

    public InputMultiplexer getMultiplexer() {
        return multiplexer;
    }
}
