package com.orbusoft.ourfirstgame;

/*
 * Note: This class shouldn't need to be modified much, if at all.
 * 		 See Game.java for the actual game logic and drawing code.
 */

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.josh.graphicsengine2d.Globals;

public class OurFirstGame implements ApplicationListener
{
	@Override
	public void create()
	{
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		Globals.game = new Game();
		Globals.game.init();
		
		Globals.SCREEN_WIDTH = (int)w;
		Globals.SCREEN_HEIGHT = (int)h;
		
        
        Input.init();
	}

	@Override
	public void dispose()
	{
	}

	
	public void tick(float delta)
	{
		Input.poll();
		
		// tick the game
		Globals.game.tick(delta);
	}

	@Override
	public void render()
	{
		// perform the game logic
		tick(Gdx.graphics.getDeltaTime());
		
		// draw a black background
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		
		// call the game's drawing code
		//Globals.game.g.batch.begin();
		Globals.game.draw();
		//Globals.game.g.batch.end();

	}

	@Override
	public void resize(int width, int height)
	{ // this gets called automatically whenever the window gets resized.  probably won't add anything here.
	}

	@Override
	public void pause()
	{ // this gets called automatically if the game gets paused, particularly on Android (if the game gets minimized)
	}

	@Override
	public void resume()
	{ // and this is just called automatically when the game gets resumed.
	}
}
