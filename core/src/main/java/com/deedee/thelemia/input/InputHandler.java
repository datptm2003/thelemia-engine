package com.deedee.thelemia.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.AssignStageEvent;
import com.deedee.thelemia.event.common.ChangeInputControllerEvent;
import com.deedee.thelemia.scene.GameSystem;

public class InputHandler extends GameSystem implements IInputHandler {
    private final InputListener listener = new InputListener(this);

    private Stage stage;
    private final InputMultiplexer multiplexer = new InputMultiplexer();
    private InputController<?> currentInputController;

    public InputHandler() {
        subscribeListener();
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void subscribeListener() {
        EventBus.getInstance().subscribe(ChangeInputControllerEvent.class, listener);
        EventBus.getInstance().subscribe(AssignStageEvent.class, listener);
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
        multiplexer.clear();
        if (stage != null) {
            multiplexer.addProcessor(stage);
        }
        if (nextInputController != null) {
            multiplexer.addProcessor(nextInputController);
        }
        currentInputController = nextInputController;
    }
    public void assignStage(Stage stage) {
        this.stage = stage;
    }

    public InputMultiplexer getMultiplexer() {
        return multiplexer;
    }
}
