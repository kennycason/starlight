package com.kennycason.starlight.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.config.Configuration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		final Configuration configuration = new Configuration();
		configuration.title = "Star Light";
		configuration.width = 800;
		configuration.height = 600;

		final LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = configuration.title;
		config.width = configuration.width;
		config.height = configuration.height;
		new LwjglApplication(new StarLight(configuration), config);
	}
}
