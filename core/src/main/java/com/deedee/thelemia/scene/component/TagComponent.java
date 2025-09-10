package com.deedee.thelemia.scene.component;

import com.deedee.thelemia.scene.Component;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

public class TagComponent extends Component implements ICoreComponent {
    private String tag;

    public TagComponent(Entity owner, String tag) {
        super(owner);
        this.tag = tag;
    }

    @Override
    public void reset() {

    }
    @Override
    public ComponentGroup getGroup() {
        return ComponentGroup.CORE;
    }

    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
}
