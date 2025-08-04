package com.deedee.thelemia.ai.btree.node;

import com.deedee.thelemia.ai.btree.Blackboard;
import com.deedee.thelemia.ai.btree.CompositeNode;
import com.deedee.thelemia.ai.btree.Node;
import com.deedee.thelemia.ai.enumerate.ActionStatus;

public class Selector extends CompositeNode {
    public Selector(String name) {
        super(name);
    }

    @Override
    public ActionStatus execute(Blackboard blackboard) {
        for (Node child : children) {
            ActionStatus status = child.execute(blackboard);
            if (status != ActionStatus.FAILED) {
                return status;
            }
        }
        return ActionStatus.FAILED;
    }
}
