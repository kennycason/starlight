package com.kennycason.starlight.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.config.Configuration;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final Configuration configuration = new Configuration();
		configuration.title = "Star Light";
		configuration.width = 486;
		configuration.height = 600;

		final AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useAccelerometer = false;
		config.useCompass = false;
		initialize(new StarLight(configuration), config);
	}
}
