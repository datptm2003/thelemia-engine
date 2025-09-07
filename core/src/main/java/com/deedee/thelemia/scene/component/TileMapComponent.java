package com.deedee.thelemia.scene.component;

import com.deedee.thelemia.graphics.TileMap;
import com.deedee.thelemia.scene.Component;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

public class TileMapComponent extends Component implements IGraphicsComponent {
    private final TileMap tileMap;
    private boolean visible = true;

    public TileMapComponent(Entity owner, TileMap tileMap) {
        super(owner);
        this.tileMap = tileMap;
    }

    @Override
    public void reset() {
        visible = true;
        enabled = true;
    }

    @Override
    public void dispose() {
        tileMap.dispose();
    }

    @Override
    public boolean isVisible() {
        return visible;
    }
    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public ComponentGroup getGroup() {
        return ComponentGroup.GRAPHICS;
    }
    @Override
    public TileMap getGraphicsObject() {
        return tileMap;
    }

}
