package com.orbusoft.ourfirstgame;

import com.josh.graphicsengine2d.*;
import com.josh.graphicsengine2d.Light.LightType;

import com.badlogic.gdx.Input.Keys;

public class Game
{
	public Graphics g;
    
    public static final int		SCREEN_WIDTH = 1280;
    public static final int		SCREEN_HEIGHT = 720; // former resolution: 512x416
    
    float x, y;
    float alpha;
    
    Image background, player;
	
	public void init()
	{
		g = new Graphics();
		
        g.setAmbientLight(0, 0, 0);

        try
        {
			g.createDiffuseLight(30, 30, 255, 255, 255, 100, 500); // create a white (RGB: 255, 255, 255) diffuse light at point 30, 30 with an inner radius of 100 and outer radius of 500.
			g.createDiffuseLight(700, 400, 255, 0, 0, 100, 100); // create a red (RGB: 255, 0, 0) diffuse light at point 700, 400 with an inner radius of 100 and outer radius of 100.
			// note: the inner radius is the radius that is always 100% lit, and the outer radius is the radius that is gradually dimmed.  play around with the values and see...
		}
        catch (Exception e)
        {
			e.printStackTrace();
		}

        background = new Image("assets/background.jpg");
        player = new Image("assets/test.jpg");
        alpha = 1.0f;
	}
	
	public void tick(float delta)
	{
		float speed = 300.0f;
		
		// movement
		if (Input.keys[Keys.LEFT] > 0)
			x -= speed * delta;
		if (Input.keys[Keys.RIGHT] > 0)
			x += speed * delta;
		if (Input.keys[Keys.UP] > 0)
			y -= speed * delta;
		if (Input.keys[Keys.DOWN] > 0)
			y += speed * delta;
		
		// adjust transparency with A and Z keys
		if (Input.keys[Keys.A] > 0)
		{
			alpha += 1.0f * delta;
			if (alpha > 1.0f)
				alpha = 1.0f;
		}
		
		if (Input.keys[Keys.Z] > 0)
		{
			alpha -= 1.0f * delta;
			if (alpha < 0.0f)
				alpha = 0.0f;
		}
	}
	
	public void draw()
	{
		g.drawImage(background, 0, 0, 1.0f);
		g.drawImage(player, x, y, alpha);
	}
}
