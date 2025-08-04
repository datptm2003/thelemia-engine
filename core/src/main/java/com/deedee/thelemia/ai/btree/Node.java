package com.deedee.thelemia.ai.btree;

import com.deedee.thelemia.ai.enumerate.ActionStatus;

public abstract class Node implements INode {
    String name;

    public Node(String name) {
        this.name = name;
    }

    @Override
    public abstract ActionStatus execute(Blackboard blackboard);

    public String getName() {
        return name;
    }
}
