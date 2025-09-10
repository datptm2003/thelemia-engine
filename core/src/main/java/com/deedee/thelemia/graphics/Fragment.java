package com.deedee.thelemia.graphics;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;

public class Fragment extends RenderableObject {
    protected WidgetGroup widgetGroup;
    protected final float parentAlpha;

    public Fragment(Skin skin, WidgetGroup widgetGroup, float parentAlpha) {
        super(skin);
        this.widgetGroup = widgetGroup;
        this.parentAlpha = parentAlpha;
    }
    public Fragment(Skin skin, float parentAlpha) {
        super(skin);
        this.widgetGroup = null;
        this.parentAlpha = parentAlpha;
    }

    @Override
    public void create() {
        super.create();
    }
    @Override
    public void start() {
        super.start();
    }
    @Override
    public void update(float delta) {
        if (!isStarted) start();
        if (isStopped) stop();

    }
    @Override
    public void dispose() {
        super.dispose();
    }

    public WidgetGroup getWidget() {
        return widgetGroup;
    }
}
