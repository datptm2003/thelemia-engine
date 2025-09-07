package com.deedee.thelemia.event.common;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.deedee.thelemia.event.Event;

public class AssignStageEvent extends Event {
    public Stage stage;

    public AssignStageEvent(Stage stage) {
        super();
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public String getLog() {
        return "";
    }
}
