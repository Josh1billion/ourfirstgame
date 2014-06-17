package com.orbusoft.ourfirstgame;

import com.badlogic.gdx.Gdx;
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
		
		// get user's desktop screen resolution
		int desktopWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width; 
		int desktopHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		// calculate window size...
		int gameWidth = 1920; // default to 1920x1080
		int gameHeight = 1080;
		float gameAspectRatio = (float)gameWidth / (float)gameHeight;
		// if the user doesn't support 1920x1080, go for the greatest width possible (and retain the widescreen aspect ratio)
		if (gameWidth > desktopWidth)
		{
			gameWidth = desktopWidth;
			gameHeight = (int)((1.0f / gameAspectRatio) * gameWidth);
		}
		
		// handle an unlikely scenario where the user has a really high screen resolution (something weird like 500x1500)
		if (gameHeight > desktopHeight)
		{
			gameWidth = (int)(desktopWidth * gameAspectRatio);
			gameHeight = desktopHeight;
		}
		
		cfg.width = gameWidth;
		cfg.height = gameHeight;
		
		new LwjglApplication(new OurFirstGame(), cfg);
	}
}
