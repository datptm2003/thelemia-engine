package com.deedee.thelemia;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.deedee.thelemia.core.EngineConfig;
import com.deedee.thelemia.core.Engine;
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

//        Skin skin = new Skin(Gdx.files.internal("skins/metal-ui.json"));
//        AnimatedSprite testAnimatedSprite = new AnimatedSprite(skin);
//        testAnimatedSprite.load("textures/scareton.png", "test", 3, 3, 0.2f);
//        testAnimatedSprite.setAnimation("test");
//        Entity testAnimatedSpriteEntity = new Entity();
//
//        Fragment testFragment = getSimpleFragment(skin);
//        Entity testFragmentEntity = new Entity();
//
//        WidgetComponent widgetComponent = new WidgetComponent(testFragmentEntity, engine.getRenderer().getRoot(), testFragment);
//        testFragmentEntity.addComponent(widgetComponent);
//
//        AnimatedSpriteComponent animatedSpriteComponent = new AnimatedSpriteComponent(testAnimatedSpriteEntity, testAnimatedSprite);
//        testAnimatedSpriteEntity.addComponent(animatedSpriteComponent);
//
//        Scene testScene = engine.getSceneManager().createNewScene("test");
//        testScene.addEntity(testAnimatedSpriteEntity);
//        testScene.addEntity(testFragmentEntity);
//        testScene.onShow(() -> {
//            widgetComponent.render();
//            animatedSpriteComponent.render();
//        });
//
//        engine.getSceneManager().loadScene("test");
    }

//    private Fragment getSimpleFragment(Skin skin) {
//        return new Fragment(skin,1.0f) {
//            @Override
//            public void create() {
//                super.create();
//                Table table = new Table();
//                engine.getRenderer().getRoot().add(table).width(300f).expand();
//
//                Slider slider = new Slider(0, 100, 1, false, skin);
//                TextButton textButton = new TextButton("Test", skin);
//                textButton.addListener(new ChangeListener() {
//                    @Override
//                    public void changed(ChangeEvent event, Actor actor) {
//                        System.out.println("Button clicked!");
//                    }
//                });
//                TextButton textButton2 = new TextButton("Test2", skin);
//                textButton2.addListener(new ChangeListener() {
//                    @Override
//                    public void changed(ChangeEvent event, Actor actor) {
//                        System.out.println("Button clicked!");
//                    }
//                });
//                table.add(textButton).pad(10f);
//                table.add(textButton2).pad(10f);
//                table.row();
//                table.add(slider).colspan(2).expand().fill().pad(10f);
//
//                table.setDebug(true, true);
//
//                widgetGroup = table;
//            }
//
//        };
//    }

    @Override
    public void render() {
        engine.render();
    }
    @Override
    public void dispose() {
        engine.dispose();
    }
}
