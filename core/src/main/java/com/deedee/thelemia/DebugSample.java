package com.deedee.thelemia;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.deedee.thelemia.core.Engine;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.ChangeMapEvent;
import com.deedee.thelemia.event.common.RenderAnimatedSpriteEvent;
import com.deedee.thelemia.event.common.RenderFragmentEvent;
import com.deedee.thelemia.event.common.RenderParticlesEvent;
import com.deedee.thelemia.graphics.AnimatedSprite;
import com.deedee.thelemia.graphics.Fragment;
import com.deedee.thelemia.graphics.Particles;
import com.deedee.thelemia.graphics.TileMap;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.Scene;
import com.deedee.thelemia.scene.component.AnimatedSpriteComponent;
import com.deedee.thelemia.scene.component.ParticlesComponent;
import com.deedee.thelemia.scene.component.TileMapComponent;
import com.deedee.thelemia.scene.component.WidgetComponent;

public class DebugSample {
    private static class CustomInputAdapter extends InputAdapter {
        Entity player;
        public CustomInputAdapter(Entity player) {
            this.player = player;
        }

        @Override
        public boolean keyDown(int keycode) {
            switch (keycode) {
                case Input.Keys.UP:
                    System.out.println("UP");
                    break;
                case Input.Keys.DOWN:
                    System.out.println("DOWN");
                    break;
                case Input.Keys.LEFT:
                    System.out.println("LEFT");
                    break;
                case Input.Keys.RIGHT:
                    System.out.println("RIGHT");
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    private final Engine engine;

    public DebugSample(Engine engine) {
        this.engine = engine;
    }

    public void setup() {
        Skin skin = new Skin(Gdx.files.internal("skins/metal-ui.json"));

        AnimatedSprite testAnimatedSprite = new AnimatedSprite(skin);
        testAnimatedSprite.load("textures/scareton.png", "test", 3, 3, 0.2f);
        testAnimatedSprite.setAnimation("test");
        Entity testAnimatedSpriteEntity = new Entity("animation");

        Fragment testFragment = getSimpleFragment(skin);
        Entity testFragmentEntity = new Entity("fragment");

        TileMap testTileMap = new TileMap(skin, "tilemap/gameart2d-desert.tmx");
        Entity testTileMapEntity = new Entity("tilemap");

        Particles testParticles = new Particles(skin, "particles/explosion/explosion.p");
        Entity testParticlesEntity = new Entity("particles");

        WidgetComponent widgetComponent = new WidgetComponent(testFragmentEntity, engine.getRenderer().getRoot(), testFragment);
        testFragmentEntity.addComponent(widgetComponent);

        AnimatedSpriteComponent animatedSpriteComponent = new AnimatedSpriteComponent(testAnimatedSpriteEntity, testAnimatedSprite);
        testAnimatedSpriteEntity.addComponent(animatedSpriteComponent);

        TileMapComponent tileMapComponent = new TileMapComponent(testTileMapEntity, testTileMap);
        testTileMapEntity.addComponent(tileMapComponent);

        ParticlesComponent particlesComponent = new ParticlesComponent(testParticlesEntity, testParticles);
        testParticlesEntity.addComponent(particlesComponent);

        Scene testScene = new Scene("test", new CustomInputAdapter(testAnimatedSpriteEntity), engine.getSceneManager()) {
            @Override
            public void show() {
                super.show();
                Entity testFragmentEntity = getEntityById("fragment");
                Entity testAnimatedSpriteEntity = getEntityById("animation");
                Entity testTileMapEntity = getEntityById("tilemap");
                Entity testParticlesEntity = getEntityById("particles");

                WidgetComponent widgetComponent = testFragmentEntity.getComponentByType(WidgetComponent.class);
                AnimatedSpriteComponent animatedSpriteComponent = testAnimatedSpriteEntity.getComponentByType(AnimatedSpriteComponent.class);
                TileMapComponent tileMapComponent = testTileMapEntity.getComponentByType(TileMapComponent.class);
                ParticlesComponent testParticlesComponent = testParticlesEntity.getComponentByType(ParticlesComponent.class);

                EventBus.getInstance().post(new RenderFragmentEvent(widgetComponent, 1.0f));
                EventBus.getInstance().post(new RenderAnimatedSpriteEvent(animatedSpriteComponent));
                EventBus.getInstance().post(new ChangeMapEvent(tileMapComponent));
                EventBus.getInstance().post(new RenderParticlesEvent(testParticlesComponent, 350, 530, true));
            }

            @Override
            public void update(float delta) {
                Entity testAnimatedSpriteEntity = getEntityById("animation");
                AnimatedSpriteComponent animatedSpriteComponent = testAnimatedSpriteEntity.getComponentByType(AnimatedSpriteComponent.class);

                animatedSpriteComponent.getGraphicsObject().update(delta);
            }
        };

        testScene.addEntity(testAnimatedSpriteEntity);
        testScene.addEntity(testFragmentEntity);
        testScene.addEntity(testTileMapEntity);
        testScene.addEntity(testParticlesEntity);

        engine.getSceneManager().addScene(testScene);
        engine.getSceneManager().loadScene("test");
    }

    private Fragment getSimpleFragment(Skin skin) {
        return new Fragment(skin,1.0f) {
            @Override
            public void create() {
                super.create();
                Table table = new Table();
                engine.getRenderer().getRoot().add(table).width(300f).expand();

                Slider slider = new Slider(0, 100, 1, false, skin);
                TextButton textButton = new TextButton("Test", skin);
                textButton.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                        System.out.println("Button clicked!");
                    }
                });
                TextButton textButton2 = new TextButton("Test2", skin);
                textButton2.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                        System.out.println("Button clicked!");
                    }
                });
                table.add(textButton).pad(10f);
                table.add(textButton2).pad(10f);
                table.row();
                table.add(slider).colspan(2).expand().fill().pad(10f);

                table.setDebug(true, true);

                widgetGroup = table;
            }

        };
    }
}
