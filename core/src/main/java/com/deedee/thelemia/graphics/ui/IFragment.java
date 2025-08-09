package com.deedee.thelemia.graphics.ui;

public interface IFragment {
    <T extends Widget> T getWidgetByName(String name, Class<T> type);
}
