package com.deedee.thelemia.ai.btree.node;

import com.deedee.thelemia.ai.btree.Blackboard;
import com.deedee.thelemia.ai.btree.Node;
import com.deedee.thelemia.ai.enumerate.ActionStatus;

public class FiniteRepeater extends Node {
    private final Node child;
    private final int maxRepeats;

    public FiniteRepeater(String name, Node child, int maxRepeats) {
        super(name);
        this.child = child;
        this.maxRepeats = maxRepeats;
    }

    @Override
    public ActionStatus execute(Blackboard blackboard) {
        for (int i = 0; i < maxRepeats; i++) {
            ActionStatus status = child.execute(blackboard);
            if (status != ActionStatus.SUCCESSFUL) {
                return status;
            }
        }
        return ActionStatus.SUCCESSFUL;
    }


}
