package com.deedee.thelemia.graphics;

import java.util.HashMap;
import java.util.Map;

public abstract class Style implements IStyle {
    protected final Map<Class<? extends Style>, Style> substyles = new HashMap<>();

    @Override
    public <T extends Style> T getSubstyle(Class<T> styleType) {
        Style style = substyles.get(styleType);
        return styleType.cast(style); // Safe cast
    }
}
