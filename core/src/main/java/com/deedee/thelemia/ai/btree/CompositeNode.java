package com.deedee.thelemia.ai.btree;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositeNode extends Node {
    protected final List<Node> children = new ArrayList<>();

    public CompositeNode(String name) {
        super(name);
    }

    public void addChild(Node child) {
        children.add(child);
    }
    public void removeChild(Node child) {
        children.remove(child);
    }
}
