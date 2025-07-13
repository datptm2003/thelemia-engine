package com.deedee.thelemia;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.deedee.thelemia.core.EngineConfig;
import com.deedee.thelemia.core.Engine;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class ThelemiaLauncher extends ApplicationAdapter {
    private final EngineConfig config = new EngineConfig(1920, 1048, "MyThelemiaEngine", false);
    private final Engine engine = new Engine(config);

    @Override
    public void create() {
        engine.create();
    }
    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        engine.render();
    }
    @Override
    public void dispose() {
        engine.dispose();
    }
}
