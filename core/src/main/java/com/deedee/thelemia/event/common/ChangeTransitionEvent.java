package com.deedee.thelemia.event.common;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.graphics.Transition;

public class ChangeTransitionEvent extends Event {
    private final Transition nextTransition;

    public ChangeTransitionEvent(Transition nextTransition) {
        super();
        this.nextTransition = nextTransition;
    }

    public Transition getNextTransition() {
        return nextTransition;
    }

    @Override
    public String getLog() {
        return "";
    }

}
