package com.deedee.thelemia.lwjgl3;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.deedee.thelemia.Thelemia;

/** Launches the desktop (LWJGL3) application. */
public class Lwjgl3Launcher {
    public static void main(String[] args) {
        if (StartupHelper.startNewJvmIfRequired()) return; // This handles macOS support and helps on Windows.
        Lwjgl3Application application = createApplication();
    }

    private static Lwjgl3Application createApplication() {
        return new Lwjgl3Application(new Thelemia(), getDefaultConfiguration());
    }

    private static Lwjgl3ApplicationConfiguration getDefaultConfiguration() {
        Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
        // Window title
        configuration.setTitle("MyBalatroGame");

        // Enable VSync
        configuration.useVsync(true);

        // Get the primary display mode (current screen resolution)
        Graphics.DisplayMode displayMode = Lwjgl3ApplicationConfiguration.getDisplayMode();

        // Set the window size to screen size
        configuration.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());

        // Set the foreground FPS to match refresh rate (plus one)
        configuration.setForegroundFPS(displayMode.refreshRate + 1);

        // Allow resizing the window
        configuration.setDecorated(false);  // Removes window borders/title bar
        configuration.setResizable(false);  // Optional: prevents resizing

        // Center the window on screen (only works in windowed mode)
        configuration.setWindowPosition(0, 0);

        // Set window icons
        configuration.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png");

        return configuration;
    }
}
