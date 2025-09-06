package com.deedee.thelemia.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.ChangeInputControllerEvent;
import com.deedee.thelemia.scene.GameSystem;

public class InputHandler extends GameSystem implements IInputHandler {
    private final InputListener listener = new InputListener(this);

    private final Stage stage;
    private final InputMultiplexer multiplexer = new InputMultiplexer();
    private InputController<?> currentInputController;

    public InputHandler(Stage stage) {
        subscribeListener();
        this.stage = stage;
        multiplexer.addProcessor(stage);
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void subscribeListener() {
        EventBus.getInstance().subscribe(ChangeInputControllerEvent.class, listener);
    }
    @Override
    public void update(float delta) {
        if (currentInputController != null) {
            currentInputController.update(delta);
        }
    }
    @Override
    public void dispose() {

    }
    @Override
    public InputListener getListener() {
        return listener;
    }

    public void changeInputController(InputController<?> nextInputController) {
        if (nextInputController == null) {
            multiplexer.clear();
            multiplexer.addProcessor(stage);
            Gdx.input.setInputProcessor(multiplexer);
        } else {
            multiplexer.clear();
            multiplexer.addProcessor(stage);
            multiplexer.addProcessor(nextInputController);
            Gdx.input.setInputProcessor(multiplexer);
        }
        currentInputController = nextInputController;
    }

    public InputMultiplexer getMultiplexer() {
        return multiplexer;
    }
}
