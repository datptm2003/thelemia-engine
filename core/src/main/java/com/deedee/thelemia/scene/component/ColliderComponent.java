package com.deedee.thelemia.scene.component;

import com.deedee.thelemia.physics.RigidBody;
import com.deedee.thelemia.scene.Component;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

public class ColliderComponent extends Component implements IPhysicsComponent {
    protected final RigidBody body;

    public ColliderComponent(Entity owner, RigidBody body) {
        super(owner);
        this.body = body;
    }

    @Override
    public void reset() {

    }

    @Override
    public ComponentGroup getGroup() {
        return ComponentGroup.PHYSICS;
    }

    public RigidBody getRigidBody() {
        return body;
    }
}
