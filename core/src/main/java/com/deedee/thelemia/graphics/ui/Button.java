package com.deedee.thelemia.graphics.ui;

import com.deedee.thelemia.graphics.utils.IClickable;
import com.deedee.thelemia.graphics.ui.context.ButtonContext;
import com.deedee.thelemia.graphics.ui.context.CanvasContext;
import com.deedee.thelemia.graphics.ui.context.LabelContext;
import com.deedee.thelemia.graphics.ui.style.ButtonStyle;
import com.deedee.thelemia.graphics.ui.style.CanvasStyle;
import com.deedee.thelemia.graphics.ui.style.LabelStyle;

public class Button extends CompositeWidget implements IClickable {
    public Button(ButtonContext context, ButtonStyle style) {
        super(context, style);

        CanvasStyle canvasStyle = style.getSubstyle(CanvasStyle.class);
        LabelStyle labelStyle = style.getSubstyle(LabelStyle.class);

        CanvasContext canvasContext = context.getCanvasContext();
        LabelContext labelContext = context.getLabelContext();

        this.addChild("background", new Canvas(canvasContext, canvasStyle), (int) canvasContext.getRelativePosition().x, (int) canvasContext.getRelativePosition().y);
        this.addChild("label", new Label(labelContext, labelStyle), (int) labelContext.getRelativePosition().x, (int) labelContext.getRelativePosition().y);
    }

    @Override
    public void onClick(int x, int y) {
        this.getContext().getCallback().run();
    }

    @Override
    public ButtonContext getContext() {
        return (ButtonContext) super.getContext();
    }

}
