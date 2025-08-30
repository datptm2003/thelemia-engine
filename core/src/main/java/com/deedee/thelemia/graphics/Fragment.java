package com.deedee.thelemia.graphics;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.RenderFragmentEvent;
import com.deedee.thelemia.scene.component.TransformComponent;

public class Fragment extends GraphicsObject implements IFragment {
    protected final WidgetGroup widgetGroup;
    protected final float parentAlpha;

    public Fragment(Skin skin, WidgetGroup widgetGroup, float parentAlpha) {
        super(skin);
        this.widgetGroup = widgetGroup;
        this.parentAlpha = parentAlpha;
    }

    @Override
    public void render(TransformComponent transform) {
        EventBus.getInstance().post(new RenderFragmentEvent(this, transform, parentAlpha));
    }

    public WidgetGroup getWidgetGroup() {
        return widgetGroup;
    }
}
