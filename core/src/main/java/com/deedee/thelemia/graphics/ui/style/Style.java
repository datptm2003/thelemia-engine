package com.deedee.thelemia.graphics.ui.style;

import java.util.HashMap;
import java.util.Map;

public abstract class Style implements IStyle {
    protected final Map<Class<? extends Style>, Style> substyles = new HashMap<>();

    @Override
    public Style getSubstyle(Class<? extends Style> styleType) {
        return substyles.get(styleType);
    }
}
