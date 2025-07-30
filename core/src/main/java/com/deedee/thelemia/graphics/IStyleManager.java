package com.deedee.thelemia.graphics;

import com.deedee.thelemia.graphics.ui.style.Style;

public interface IStyleManager {
    void loadStyle(String name, Style style);
    Style getStyle(String name);
}
