package com.deedee.thelemia.graphics;

import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public interface ITileMap {
    TiledMapTileLayer getTileLayer(Enum<?> name);
    void setTile(Enum<?> layerName, int tx, int ty, TiledMapTile tile);
    void clearTile(Enum<?> layerName, int tx, int ty);
}
