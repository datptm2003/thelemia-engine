package com.deedee.thelemia.ai.btree;

import com.deedee.thelemia.ai.enumerate.ActionStatus;
import com.deedee.thelemia.scene.Entity;

public class BehaviorTree implements IBehaviorTree {
    private final Entity owner;

    private Node root;
    private Blackboard blackboard;

    public BehaviorTree(Entity owner, Node root, Blackboard blackboard) {
        this.owner = owner;
        this.root = root;
        this.blackboard = blackboard;
    }
    public BehaviorTree(Entity owner, Node root) {
        this.owner = owner;
        this.root = root;
        this.blackboard = new Blackboard(owner);
    }
    public BehaviorTree(Entity owner) {
        this.owner = owner;
        this.root = null;
        this.blackboard = new Blackboard(owner);
    }

    @Override
    public ActionStatus execute() {
        if (root == null) return ActionStatus.FAILED;

        return root.execute(blackboard);
    }
    @Override
    public void reset() {

    }
    @Override
    public void release() {

    }

    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }

    public Blackboard getBlackboard() {
        return blackboard;
    }
    public void setBlackboard(Blackboard blackboard) {
        this.blackboard = blackboard;
    }

}
