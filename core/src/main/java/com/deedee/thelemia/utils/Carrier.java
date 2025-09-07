package com.deedee.thelemia.utils;

public class Carrier<T> {
    private final T item;
    public Carrier(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
