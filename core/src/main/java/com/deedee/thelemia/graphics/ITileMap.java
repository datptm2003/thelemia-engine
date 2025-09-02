package com.deedee.thelemia.graphics;

import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public interface ITileMap {
    TiledMapTileLayer getTileLayer(String name);
    void setTile(TiledMapTileLayer layer, int tx, int ty, TiledMapTile tile);
    void clearTile(TiledMapTileLayer layer, int tx, int ty);
}
