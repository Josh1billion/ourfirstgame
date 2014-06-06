package com.orbusoft.ourfirstgame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main
{
	public static void main(String[] args)
	{
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
		cfg.title = "Our First Game";
		cfg.useGL20 = true;
		cfg.width = 1920;
		cfg.height = 1080;
		
		new LwjglApplication(new OurFirstGame(), cfg);
	}
}
