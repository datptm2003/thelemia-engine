package com.deedee.thelemia.graphics;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.deedee.thelemia.graphics.ui.style.Style;

import java.util.HashMap;
import java.util.Map;

public class StyleManager implements IStyleManager {
    private final Skin skin;
    private final Map<String, Style> styles = new HashMap<>();

    public StyleManager(Skin skin) {
        this.skin = skin;
        loadDefaultStyles(); // or load dynamically
    }

    private void loadDefaultStyles() {

    }

    @Override
    public void loadStyle(String name, Style style) {
        styles.put(name, style);
    }
    @Override
    public Style getStyle(String name) {
        Style style = styles.get(name);
        if (style == null) {
            throw new IllegalArgumentException("Style not found: " + name);
        }
        return style;
    }
}
