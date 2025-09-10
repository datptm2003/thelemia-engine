package com.deedee.thelemia.ai.btree;

import com.deedee.thelemia.ai.enumerate.ActionStatus;

public abstract class Node {
    String name;

    public Node(String name) {
        this.name = name;
    }

    public abstract ActionStatus execute(Blackboard blackboard);

    public String getName() {
        return name;
    }
}
