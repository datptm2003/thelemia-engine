package com.deedee.thelemia.graphics.ui.context;

import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.ui.Widget;

public interface IWidgetContext<T extends Widget> {
    T build();
    void reset();
    Style getStyle();
}
