package com.deedee.thelemia.event.common;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.graphics.TileMap;
import com.deedee.thelemia.scene.component.TileMapComponent;

public class ChangeMapEvent extends Event {
    private final TileMap nextTileMap;

    public ChangeMapEvent(TileMap nextTileMap) {
        this.nextTileMap = nextTileMap;
    }
    public ChangeMapEvent(TileMapComponent nextTilemapComponent) {
        this.nextTileMap = nextTilemapComponent.getGraphicsObject();
    }

    public TileMap getNextTileMap() {
        return nextTileMap;
    }

    @Override
    public String getLog() {
        return "";
    }
}
