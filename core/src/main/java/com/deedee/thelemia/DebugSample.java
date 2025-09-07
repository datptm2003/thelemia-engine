package com.deedee.thelemia;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.deedee.thelemia.audio.effect.FadeInEffect;
import com.deedee.thelemia.audio.effect.FadeOutEffect;
import com.deedee.thelemia.audio.effect.RandomGlitchEffect;
import com.deedee.thelemia.core.Engine;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.*;
import com.deedee.thelemia.graphics.AnimatedSprite;
import com.deedee.thelemia.graphics.Fragment;
import com.deedee.thelemia.graphics.Particles;
import com.deedee.thelemia.graphics.TileMap;
import com.deedee.thelemia.input.InputController;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.Scene;
import com.deedee.thelemia.scene.component.*;
import com.deedee.thelemia.time.Timer;

public class DebugSample {
    private static class CustomInputAdapter extends InputAdapter {
        private final Entity player;
        public CustomInputAdapter(Entity player) {
            this.player = player;
        }

        public Entity getPlayer() {
            return player;
        }
    }

    private static class CustomInputController extends InputController<CustomInputAdapter> {
        // Tweak these values to taste:
        private static final float MAX_SPEED = 300f;         // pixels per second
        private static final float ACCELERATION = 4000f;     // "how fast we reach max speed" (units/sec^2)
        // The lerp factor controls smoothness — higher = snappier, lower = softer stop/start.
        // We'll compute a per-frame alpha from this (not a raw constant).
        // You can think of ACCELERATION/MAX_SPEED as a base for the lerp alpha.

        private final Vector2 velocity = new Vector2();

        public CustomInputController(CustomInputAdapter inputAdapter) {
            super(inputAdapter);
        }

        @Override
        public void update(float delta) {
            // call super first (so input state is updated inside InputController if it does that)
            super.update(delta);

            // Get the player entity from the input adapter (same design as your snippet)
            CustomInputAdapter adapter = getInputAdapter(); // assume InputController exposes this
            if (adapter == null) return;

            Entity player = adapter.player;
            if (player == null) return;

            TransformComponent transform = player.getComponentByType(TransformComponent.class);
            if (transform == null) return;

            // Build desired direction from key state
            float dirX = 0f;
            float dirY = 0f;

            if (isKeyPressed(Input.Keys.LEFT) || isKeyPressed(Input.Keys.A))  dirX -= 5f;
            if (isKeyPressed(Input.Keys.RIGHT) || isKeyPressed(Input.Keys.D)) dirX += 5f;
            if (isKeyPressed(Input.Keys.UP) || isKeyPressed(Input.Keys.W))    dirY += 5f;
            if (isKeyPressed(Input.Keys.DOWN) || isKeyPressed(Input.Keys.S))  dirY -= 5f;

            if (isKeyPressed(Input.Keys.Q)) {
                transform.setScale(transform.getScale().x * 0.8f, transform.getScale().y * 0.8f);
            }
            if (isKeyPressed(Input.Keys.E)) {
                transform.setScale(transform.getScale().x * 1.25f, transform.getScale().y * 1.25f);
            }
            if (isKeyPressed(Input.Keys.SPACE)) {
                transform.setRotation(transform.getRotation() + 45f);
            }

            Vector2 desiredDir = new Vector2(dirX, dirY);
            if (desiredDir.len2() > 1e-6f) {
                desiredDir.nor(); // normalize so diagonal isn't faster
            } else {
                desiredDir.setZero();
            }

            // Desired velocity = direction * max speed
            Vector2 desiredVel = desiredDir.scl(MAX_SPEED);

            // Compute per-frame lerp alpha from acceleration.
            // We want alpha in [0,1]; larger ACCELERATION -> faster approach to desiredVel.
            float alpha = MathUtils.clamp((ACCELERATION * delta) / MAX_SPEED, 0f, 1f);

            // Smoothly move current velocity toward desired velocity
            velocity.lerp(desiredVel, alpha);

            // Apply movement
            float newX = transform.getPosition().x + velocity.x * delta;
            float newY = transform.getPosition().y + velocity.y * delta;
            transform.setPosition(newX, newY);
        }
    }

    private final Engine engine;

    public DebugSample(Engine engine) {
        this.engine = engine;
    }

    public void setup() {
        Skin skin = new Skin(Gdx.files.internal("skins/metal-ui.json"));

        // Entity setup
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

        // Component setup
        WidgetComponent widgetComponent = new WidgetComponent(testFragmentEntity, engine.getRenderer().getRoot(), testFragment);
        testFragmentEntity.addComponent(widgetComponent);

        AnimatedSpriteComponent animatedSpriteComponent = new AnimatedSpriteComponent(testAnimatedSpriteEntity, testAnimatedSprite);
        testAnimatedSpriteEntity.addComponent(animatedSpriteComponent);

        TileMapComponent tileMapComponent = new TileMapComponent(testTileMapEntity, testTileMap);
        testTileMapEntity.addComponent(tileMapComponent);

        ParticlesComponent particlesComponent = new ParticlesComponent(testParticlesEntity, testParticles);
        testParticlesEntity.addComponent(particlesComponent);

        Scene testScene = getSampleScene(testAnimatedSpriteEntity);

        testScene.addEntity(testAnimatedSpriteEntity);
        testScene.addEntity(testFragmentEntity);
        testScene.addEntity(testTileMapEntity);
        testScene.addEntity(testParticlesEntity);

        engine.getSceneManager().addScene(testScene);
        engine.getSceneManager().loadScene("test");
    }

    private Scene getSampleScene(Entity testAnimatedSpriteEntity) {
        CustomInputAdapter testInputAdapter = new CustomInputAdapter(testAnimatedSpriteEntity);

        return new Scene("test", new CustomInputController(testInputAdapter), engine.getSceneManager()) {
            @Override
            public void show() {
                super.show();
                Entity testFragmentEntity = getEntityById("fragment");
                Entity testAnimatedSpriteEntity1 = getEntityById("animation");
                Entity testTileMapEntity = getEntityById("tilemap");
                Entity testParticlesEntity = getEntityById("particles");

                WidgetComponent widgetComponent = testFragmentEntity.getComponentByType(WidgetComponent.class);
                AnimatedSpriteComponent animatedSpriteComponent = testAnimatedSpriteEntity1.getComponentByType(AnimatedSpriteComponent.class);
                TileMapComponent tileMapComponent = testTileMapEntity.getComponentByType(TileMapComponent.class);
                ParticlesComponent testParticlesComponent = testParticlesEntity.getComponentByType(ParticlesComponent.class);

                EventBus.getInstance().post(new RenderFragmentEvent(widgetComponent, 1.0f));
                EventBus.getInstance().post(new RenderAnimatedSpriteEvent(animatedSpriteComponent));
                EventBus.getInstance().post(new ChangeMapEvent(tileMapComponent));

                Timer particlesTimer = new Timer(5f, false, () -> {
                    EventBus.getInstance().post(new RenderParticlesEvent(testParticlesComponent, 350, 530, false));
                });
                EventBus.getInstance().post(new AddTimerEvent("test", particlesTimer));
            }
        };
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
