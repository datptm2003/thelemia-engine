package com.deedee.thelemia.graphics.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.deedee.thelemia.graphics.utils.IClickable;
import com.deedee.thelemia.graphics.ui.context.ButtonContext;
import com.deedee.thelemia.graphics.ui.context.CanvasContext;
import com.deedee.thelemia.graphics.ui.context.LabelContext;
import com.deedee.thelemia.graphics.ui.style.ButtonStyle;
import com.deedee.thelemia.graphics.ui.style.CanvasStyle;
import com.deedee.thelemia.graphics.ui.style.LabelStyle;

public class Button extends CompositeWidget<ButtonContext, ButtonStyle> implements IClickable {
    public Button(ButtonContext context, ButtonStyle style) {
        super(context, style);

        CanvasStyle canvasStyle = new CanvasStyle(style.background);
        LabelStyle labelStyle = new LabelStyle(style.font, style.fontColor);

        CanvasContext canvasContext = new CanvasContext(context.getWidth(), context.getHeight());
        LabelContext labelContext = new LabelContext(context.getWidth(), context.getHeight(), context.getText(), context.getAnchor(), context.getFontSize());

        addChild("background", new Canvas(canvasContext, canvasStyle), canvasContext.getPosition());
        addChild("label", new Label(labelContext, labelStyle), labelContext.getPosition());
    }
    public Button(ButtonContext context, Skin skin, String styleName) {
        this(context, skin.get(styleName, ButtonStyle.class));
    }
    public Button(ButtonContext context, Skin skin) {
        this(context, skin, "default");
    }

    @Override
    public void onClick(int x, int y) {
        getContext().getCallback().run();
    }

    @Override
    public Drawable getDrawable(SpriteBatch batch, FrameBuffer fbo, boolean transparent) {
        // Begin drawing to FBO
        fbo.begin();

        if (transparent) {
            Gdx.gl.glClearColor(0, 0, 0, 0); // transparent
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        }

        batch.begin();

        Drawable canvasDrawable = getCanvas().getDrawable(batch, fbo, transparent);
        if (canvasDrawable != null) {
            canvasDrawable.draw(batch, 0, 0, fbo.getWidth(), fbo.getHeight());
        }
        Drawable labelDrawable = getLabel().getDrawable(batch, fbo, false);
        if (labelDrawable != null) {
            labelDrawable.draw(batch, 0, 0, fbo.getWidth(), fbo.getHeight());
        }

        batch.end();
        fbo.end();

        // Flip FBO texture vertically to make it render correctly
        TextureRegion region = new TextureRegion(fbo.getColorBufferTexture());
        region.flip(false, true);

        return new TextureRegionDrawable(region);
    }

    public Canvas getCanvas() {
        return getChildByName("background", Canvas.class);
    }
    public Label getLabel() {
        return getChildByName("label", Label.class);
    }
}
