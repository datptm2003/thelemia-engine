package com.deedee.thelemia.graphics;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class TileMap extends GraphicsObject implements ITileMap {
    private final TiledMap tiledMap;
    private final int tileWidth;
    private final int tileHeight;
    private final int mapWidth;
    private final int mapHeight;

    public static final long FLIP_H = 0x80000000L;
    public static final long FLIP_V = 0x40000000L;
    public static final long FLIP_D = 0x20000000L;
    public static final long FLIP_MASK = FLIP_H | FLIP_V | FLIP_D;

    public TileMap(Skin skin, String tmxPath) {
        super(skin);
        tiledMap = new TmxMapLoader().load(tmxPath);
        MapProperties props = tiledMap.getProperties();
        tileWidth = props.get("tilewidth", Integer.class);
        tileHeight = props.get("tileheight", Integer.class);
        mapWidth = props.get("width", Integer.class);
        mapHeight = props.get("height", Integer.class);
    }

    @Override
    public void update(float delta) {
        AnimatedTiledMapTile.updateAnimationBaseTime();
    }
    @Override
    public void dispose() {
        super.dispose();
        if (tiledMap != null) tiledMap.dispose();
    }

    @Override
    public TiledMapTileLayer getTileLayer(String name) {
        MapLayer layer = tiledMap.getLayers().get(name);
        if (layer instanceof TiledMapTileLayer) {
            return (TiledMapTileLayer) layer;
        }
        return null;
    }
    @Override
    public void setTile(TiledMapTileLayer layer, int tx, int ty, TiledMapTile tile) {
        if (layer == null) return;
        if (tx < 0 || ty < 0 || tx >= layer.getWidth() || ty >= layer.getHeight()) return;
        TiledMapTileLayer.Cell cell = layer.getCell(tx, ty);
        if (cell == null) {
            cell = new TiledMapTileLayer.Cell();
        }
        cell.setTile(tile);
        layer.setCell(tx, ty, cell);
    }
    @Override
    public void clearTile(TiledMapTileLayer layer, int tx, int ty) {
        if (layer == null) return;
        if (tx < 0 || ty < 0 || tx >= layer.getWidth() || ty >= layer.getHeight()) return;
        layer.setCell(tx, ty, null);
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }
    public int getTileWidth() {
        return tileWidth;
    }
    public int getTileHeight() {
        return tileHeight;
    }
    public int getMapWidth() {
        return mapWidth;
    }
    public int getMapHeight() {
        return mapHeight;
    }
}
