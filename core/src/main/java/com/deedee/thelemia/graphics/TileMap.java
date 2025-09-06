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

    // Layer mask methods

    /**
     * Sets the flip properties (layer mask) for a tile at the specified position
     * @param layer The tile layer
     * @param tx Tile x coordinate
     * @param ty Tile y coordinate
     * @param flipHorizontally Whether to flip horizontally
     * @param flipVertically Whether to flip vertically
     * @param flipDiagonally Whether to flip diagonally
     */
    public void setTileFlip(TiledMapTileLayer layer, int tx, int ty, boolean flipHorizontally, boolean flipVertically, boolean flipDiagonally) {
        if (layer == null) return;
        if (tx < 0 || ty < 0 || tx >= layer.getWidth() || ty >= layer.getHeight()) return;

        TiledMapTileLayer.Cell cell = layer.getCell(tx, ty);
        if (cell == null) return; // Cannot set flip on non-existent tile

        cell.setFlipHorizontally(flipHorizontally);
        cell.setFlipVertically(flipVertically);
        cell.setRotation(flipDiagonally ? TiledMapTileLayer.Cell.ROTATE_90 : TiledMapTileLayer.Cell.ROTATE_0);
    }

    /**
     * Sets the flip properties using a bitmask
     * @param layer The tile layer
     * @param tx Tile x coordinate
     * @param ty Tile y coordinate
     * @param flipMask Bitmask containing flip flags (FLIP_H, FLIP_V, FLIP_D)
     */
    public void setTileFlipMask(TiledMapTileLayer layer, int tx, int ty, long flipMask) {
        boolean flipH = (flipMask & FLIP_H) != 0;
        boolean flipV = (flipMask & FLIP_V) != 0;
        boolean flipD = (flipMask & FLIP_D) != 0;
        setTileFlip(layer, tx, ty, flipH, flipV, flipD);
    }

    /**
     * Gets the current flip mask for a tile
     * @param layer The tile layer
     * @param tx Tile x coordinate
     * @param ty Tile y coordinate
     * @return Bitmask containing current flip flags, or 0 if tile doesn't exist
     */
    public long getTileFlipMask(TiledMapTileLayer layer, int tx, int ty) {
        if (layer == null) return 0;
        if (tx < 0 || ty < 0 || tx >= layer.getWidth() || ty >= layer.getHeight()) return 0;

        TiledMapTileLayer.Cell cell = layer.getCell(tx, ty);
        if (cell == null) return 0;

        long mask = 0;
        if (cell.getFlipHorizontally()) mask |= FLIP_H;
        if (cell.getFlipVertically()) mask |= FLIP_V;
        if (cell.getRotation() == TiledMapTileLayer.Cell.ROTATE_90) mask |= FLIP_D;

        return mask;
    }

    /**
     * Sets a tile with specified flip properties in one operation
     * @param layer The tile layer
     * @param tx Tile x coordinate
     * @param ty Tile y coordinate
     * @param tile The tile to set
     * @param flipHorizontally Whether to flip horizontally
     * @param flipVertically Whether to flip vertically
     * @param flipDiagonally Whether to flip diagonally
     */
    public void setTileWithFlip(TiledMapTileLayer layer, int tx, int ty, TiledMapTile tile, boolean flipHorizontally, boolean flipVertically, boolean flipDiagonally) {
        if (layer == null) return;
        if (tx < 0 || ty < 0 || tx >= layer.getWidth() || ty >= layer.getHeight()) return;

        TiledMapTileLayer.Cell cell = layer.getCell(tx, ty);
        if (cell == null) {
            cell = new TiledMapTileLayer.Cell();
        }

        cell.setTile(tile);
        cell.setFlipHorizontally(flipHorizontally);
        cell.setFlipVertically(flipVertically);
        cell.setRotation(flipDiagonally ? TiledMapTileLayer.Cell.ROTATE_90 : TiledMapTileLayer.Cell.ROTATE_0);

        layer.setCell(tx, ty, cell);
    }

    /**
     * Sets a tile with flip mask in one operation
     * @param layer The tile layer
     * @param tx Tile x coordinate
     * @param ty Tile y coordinate
     * @param tile The tile to set
     * @param flipMask Bitmask containing flip flags (FLIP_H, FLIP_V, FLIP_D)
     */
    public void setTileWithFlipMask(TiledMapTileLayer layer, int tx, int ty, TiledMapTile tile, long flipMask) {
        boolean flipH = (flipMask & FLIP_H) != 0;
        boolean flipV = (flipMask & FLIP_V) != 0;
        boolean flipD = (flipMask & FLIP_D) != 0;
        setTileWithFlip(layer, tx, ty, tile, flipH, flipV, flipD);
    }

    /**
     * Clears all flip properties for a tile (resets to no flipping)
     * @param layer The tile layer
     * @param tx Tile x coordinate
     * @param ty Tile y coordinate
     */
    public void clearTileFlip(TiledMapTileLayer layer, int tx, int ty) {
        setTileFlip(layer, tx, ty, false, false, false);
    }

    /**
     * Checks if a tile has any flip properties set
     * @param layer The tile layer
     * @param tx Tile x coordinate
     * @param ty Tile y coordinate
     * @return true if the tile has any flip properties, false otherwise
     */
    public boolean hasTileFlip(TiledMapTileLayer layer, int tx, int ty) {
        return getTileFlipMask(layer, tx, ty) != 0;
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
