package com.deedee.thelemia.ai.btree;

import com.deedee.thelemia.ai.enumerate.ActionStatus;

public interface INode {
    ActionStatus execute(Blackboard blackboard);
}
