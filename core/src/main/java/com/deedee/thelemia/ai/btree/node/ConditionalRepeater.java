package com.deedee.thelemia.ai.btree.node;

import com.deedee.thelemia.ai.btree.Blackboard;
import com.deedee.thelemia.ai.btree.Condition;
import com.deedee.thelemia.ai.btree.Node;
import com.deedee.thelemia.ai.enumerate.ActionStatus;

public class ConditionalRepeater extends Node {
    private final Node child;
    private final Condition condition;

    public ConditionalRepeater(String name, Node child, Condition condition) {
        super(name);
        this.child = child;
        this.condition = condition;
    }

    @Override
    public ActionStatus execute(Blackboard blackboard) {
        while (condition.check(blackboard)) {
            ActionStatus status = child.execute(blackboard);
            if (status != ActionStatus.SUCCESSFUL) {
                return status;
            }
        }
        return ActionStatus.FAILED;
    }


}
