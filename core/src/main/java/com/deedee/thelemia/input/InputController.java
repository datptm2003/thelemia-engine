package com.deedee.thelemia.input;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.IntMap;
import com.badlogic.gdx.utils.IntSet;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * InputController wraps an InputAdapter (delegate) and records input state:
 * - which keys/buttons are currently pressed
 * - which keys/buttons were just pressed / just released (transient, cleared by update)
 * - touches/pointers positions and which pointers are down
 * - mouse scroll accumulation (cleared by update)
 * - queue of typed characters
 *
 * Usage:
 *   InputController controller = new InputController(yourAdapter);
 *   Gdx.input.setInputProcessor(controller);
 *   // each frame:
 *   controller.update(delta);
 *   if (controller.isKeyJustPressed(Keys.SPACE)) { ... }
 */
public class InputController<T extends InputAdapter> implements InputProcessor {
    private final T delegate;

    // Key state
    private final IntSet keysDown = new IntSet();
    private final IntSet keysJustPressed = new IntSet();
    private final IntSet keysJustReleased = new IntSet();

    // Mouse / button state (use Buttons.* codes)
    private final IntSet buttonsDown = new IntSet();
    private final IntSet buttonsJustPressed = new IntSet();
    private final IntSet buttonsJustReleased = new IntSet();

    // Touch/pointer state: positions keyed by pointer id
    private final IntMap<Vector2> pointerPositions = new IntMap<>();
    private final IntSet pointersDown = new IntSet();

    // Scroll (accumulated since last update); positive = up, negative = down
    private float scrollAmount = 0f;

    // Typed characters queue (keyTyped events)
    private final Queue<Character> typedChars = new ArrayDeque<>();

    public InputController(T inputAdapter) {
        this.delegate = inputAdapter;
    }

    public void update(float delta) {
        keysJustPressed.clear();
        keysJustReleased.clear();
        buttonsJustPressed.clear();
        buttonsJustReleased.clear();
        typedChars.clear();
        scrollAmount = 0f;
    }

    public boolean isKeyPressed(int keycode) {
        return keysDown.contains(keycode);
    }
    public boolean isKeyJustPressed(int keycode) {
        return keysJustPressed.contains(keycode);
    }
    public boolean isKeyJustReleased(int keycode) {
        return keysJustReleased.contains(keycode);
    }

    public boolean isButtonPressed(int button) {
        return buttonsDown.contains(button);
    }
    public boolean isButtonJustPressed(int button) {
        return buttonsJustPressed.contains(button);
    }
    public boolean isButtonJustReleased(int button) {
        return buttonsJustReleased.contains(button);
    }

    public boolean isPointerDown(int pointer) {
        return pointersDown.contains(pointer);
    }
    public Vector2 getPointerPosition(int pointer) {
        return pointerPositions.get(pointer);
    }

    public float getScrollAmount() {
        return scrollAmount;
    }

    public Character pollTypedChar() {
        return typedChars.poll();
    }

    public void resetAll() {
        keysDown.clear();
        keysJustPressed.clear();
        keysJustReleased.clear();
        buttonsDown.clear();
        buttonsJustPressed.clear();
        buttonsJustReleased.clear();
        pointersDown.clear();
        pointerPositions.clear();
        typedChars.clear();
        scrollAmount = 0f;
    }

    public InputAdapter getDelegateAdapter() {
        return delegate;
    }

    // ------------------------
    // InputProcessor callbacks (we update state, then call delegate and return delegate result)
    // ------------------------
    @Override
    public boolean keyDown(int keycode) {
        if (!keysDown.contains(keycode)) {
            keysDown.add(keycode);
            keysJustPressed.add(keycode);
        }
        return delegate != null && delegate.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keysDown.contains(keycode)) {
            keysDown.remove(keycode);
            keysJustReleased.add(keycode);
        } else {
            // still mark as just released to be safe
            keysJustReleased.add(keycode);
        }
        return delegate != null && delegate.keyUp(keycode);
    }

    @Override
    public boolean keyTyped(char character) {
        typedChars.add(character);
        return delegate != null && delegate.keyTyped(character);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        pointersDown.add(pointer);
        pointerPositions.put(pointer, new Vector2(screenX, screenY));
        if (button >= 0) {
            if (!buttonsDown.contains(button)) {
                buttonsDown.add(button);
                buttonsJustPressed.add(button);
            }
        }
        return delegate != null && delegate.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        pointersDown.remove(pointer);
        pointerPositions.put(pointer, new Vector2(screenX, screenY)); // update last position
        if (button >= 0) {
            buttonsDown.remove(button);
            buttonsJustReleased.add(button);
        }
        return delegate != null && delegate.touchUp(screenX, screenY, pointer, button);
    }

    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Vector2 pos = pointerPositions.get(pointer);
        if (pos == null) {
            pos = new Vector2();
            pointerPositions.put(pointer, pos);
        }
        pos.set(screenX, screenY);
        return delegate != null && delegate.touchDragged(screenX, screenY, pointer);
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        // use pointer 0 for mouse position
        Vector2 pos = pointerPositions.get(0);
        if (pos == null) {
            pos = new Vector2();
            pointerPositions.put(0, pos);
        }
        pos.set(screenX, screenY);
        return delegate != null && delegate.mouseMoved(screenX, screenY);
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        // accumulate vertical scroll (amountY). Some platforms use amountX too.
        scrollAmount += amountY;
        return delegate != null && delegate.scrolled(amountX, amountY);
    }

    public T getInputAdapter() {
        return delegate;
    }
}
