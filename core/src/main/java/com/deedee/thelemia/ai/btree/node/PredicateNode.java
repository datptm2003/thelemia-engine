package com.deedee.thelemia.ai.btree.node;

import com.deedee.thelemia.ai.btree.Blackboard;
import com.deedee.thelemia.ai.btree.Condition;
import com.deedee.thelemia.ai.btree.Node;
import com.deedee.thelemia.ai.enumerate.ActionStatus;

public class PredicateNode extends Node {
    protected final Condition condition;

    public PredicateNode(String name, Condition condition) {
        super(name);
        this.condition = condition;
    }

    @Override
    public ActionStatus execute(Blackboard blackboard) {
        return condition.check(blackboard) ? ActionStatus.SUCCESSFUL : ActionStatus.FAILED;
    }
}
