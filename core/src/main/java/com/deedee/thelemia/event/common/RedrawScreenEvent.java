package com.deedee.thelemia.event.common;

import com.badlogic.gdx.graphics.Color;
import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.scene.Entity;

import java.util.List;

public class RedrawScreenEvent extends Event {
    /**
     * Clear screen and re-render
     */
    private final Color backgroundColor;
    private final List<Entity> renderableEntities;

    public RedrawScreenEvent(Color backgroundColor, List<Entity> renderableEntities) {
        super();
        this.backgroundColor = backgroundColor;
        this.renderableEntities = renderableEntities;
    }

    @Override
    public String getLog() {
        return "";
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }
    public List<Entity> getRenderableEntities() {
        return renderableEntities;
    }
}
