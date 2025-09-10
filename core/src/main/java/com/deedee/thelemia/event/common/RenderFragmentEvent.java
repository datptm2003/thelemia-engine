package com.deedee.thelemia.event.common;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.scene.component.WidgetComponent;

public class RenderFragmentEvent extends Event {
    private final WidgetComponent widgetComponent;
    private final float parentAlpha;

    public RenderFragmentEvent(WidgetComponent widgetComponent, float parentAlpha) {
        super();
        this.widgetComponent = widgetComponent;
        this.parentAlpha = parentAlpha;
    }

    public WidgetComponent getWidgetComponent() {
        return widgetComponent;
    }
    public float getParentAlpha() {
        return parentAlpha;
    }

    @Override
    public String getLog() {
        return "";
    }
}
