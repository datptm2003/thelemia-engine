package com.deedee.thelemia.event.common;

import com.deedee.thelemia.event.Event;

public class ApplyShaderEvent extends Event {
    private final String shaderName;

    public ApplyShaderEvent(String shaderName) {
        super();
        this.shaderName = shaderName;
    }

    public String getShaderName() {
        return shaderName;
    }

    @Override
    public String getLog() {
        return "";
    }
}
