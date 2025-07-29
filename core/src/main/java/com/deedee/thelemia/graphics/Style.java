package com.deedee.thelemia.graphics;

import java.util.HashMap;
import java.util.Map;

public abstract class Style implements IStyle {
    protected final Map<Class<? extends Style>, Style> substyles = new HashMap<>();

    public Style getSubstyle(Class<? extends Style> styleType) {
        return substyles.get(styleType);
    }
}
