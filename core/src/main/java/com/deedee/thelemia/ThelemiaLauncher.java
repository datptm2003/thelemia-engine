package com.deedee.thelemia;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.deedee.thelemia.core.EngineConfig;
import com.deedee.thelemia.core.Engine;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.RenderAnimatedSpriteEvent;
import com.deedee.thelemia.event.common.RenderFragmentEvent;
import com.deedee.thelemia.graphics.AnimatedSprite;
import com.deedee.thelemia.graphics.Fragment;
import com.deedee.thelemia.physics.PhysicsConfig;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.Scene;
import com.deedee.thelemia.scene.component.AnimatedSpriteComponent;
import com.deedee.thelemia.scene.component.WidgetComponent;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class ThelemiaLauncher extends ApplicationAdapter {
    private final EngineConfig config = new EngineConfig(1920, 1048, "MyThelemiaEngine", false);
    private final PhysicsConfig physicsConfig = new PhysicsConfig(new Vector2());
    private final Engine engine = new Engine(config, physicsConfig);

    @Override
    public void create() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        engine.create();

        DebugSample debugSample = new DebugSample(engine);
        debugSample.setup();
    }

    @Override
    public void render() {
        engine.render();
    }

    @Override
    public void resize(int width, int height) {
        engine.resize(width, height);
    }

    @Override
    public void dispose() {
        engine.dispose();
    }
}
