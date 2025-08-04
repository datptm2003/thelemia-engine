package com.deedee.thelemia.scene.component;

import com.deedee.thelemia.ai.btree.BehaviorTree;
import com.deedee.thelemia.scene.Component;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

public class BehaviorTreeComponent extends Component implements IControlComponent {
    private final BehaviorTree behaviorTree;

    public BehaviorTreeComponent(BehaviorTree behaviorTree) {
        this.behaviorTree = behaviorTree;
    }

    @Override
    public void update(float delta) {
        behaviorTree.execute();
    }

    @Override
    public void reset() {
        behaviorTree.reset();
    }

    @Override
    public ComponentGroup getGroup() {
        return ComponentGroup.CONTROL;
    }

    public BehaviorTree getBehaviorTree() {
        return behaviorTree;
    }
}
