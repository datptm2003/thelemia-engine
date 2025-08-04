package com.deedee.thelemia.ai.btree.node;

import com.deedee.thelemia.ai.btree.Blackboard;
import com.deedee.thelemia.ai.btree.Node;
import com.deedee.thelemia.ai.enumerate.ActionStatus;

public class Inverter extends Node {
    private final Node child;

    public Inverter(String name, Node child) {
        super(name);
        this.child = child;
    }

    @Override
    public ActionStatus execute(Blackboard blackboard) {
        ActionStatus status = child.execute(blackboard);
        if (status == ActionStatus.FAILED) return ActionStatus.SUCCESSFUL;
        else return ActionStatus.FAILED;
    }
}
