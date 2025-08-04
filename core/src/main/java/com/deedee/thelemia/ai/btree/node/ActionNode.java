package com.deedee.thelemia.ai.btree.node;

import com.deedee.thelemia.ai.btree.Blackboard;
import com.deedee.thelemia.ai.btree.Node;
import com.deedee.thelemia.ai.enumerate.ActionStatus;

public class ActionNode extends Node {
    protected final Runnable action;
    public ActionNode(String name, Runnable action) {
        super(name);
        this.action = action;
    }

    @Override
    public ActionStatus execute(Blackboard blackboard) {
        try {
            action.run();
        }
        catch (Exception e) {
            return ActionStatus.FAILED;
        }
        return ActionStatus.SUCCESSFUL;
    }
}
