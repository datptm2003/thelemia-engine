package com.deedee.thelemia.event.common;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.graphics.TileMap;
import com.deedee.thelemia.scene.component.TileMapComponent;

public class ChangeMapEvent extends Event {
    private final TileMapComponent nextTileMapComponent;
    private final float unitScale;

    public ChangeMapEvent(TileMapComponent nextTilemapComponent, float unitScale) {
        super();
        this.nextTileMapComponent = nextTilemapComponent;
        this.unitScale = 1.0f;
    }
    public ChangeMapEvent(TileMapComponent nextTilemapComponent) {
        this.nextTileMapComponent = nextTilemapComponent;
        this.unitScale = 1.0f;
    }

    public TileMapComponent getNextTileMapComponent() {
        return nextTileMapComponent;
    }

    @Override
    public String getLog() {
        return "";
    }
}
