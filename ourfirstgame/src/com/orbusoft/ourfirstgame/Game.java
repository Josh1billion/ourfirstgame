package com.orbusoft.ourfirstgame;

import com.josh.graphicsengine2d.*;

import com.badlogic.gdx.Input.Keys;

public class Game
{
	public Graphics g;
    
    public static final int		SCREEN_WIDTH = 800;
    public static final int		SCREEN_HEIGHT = 600; // former resolution: 512x416
    
    Player player;
    Image background;
    Light torch;
    
    float scrollX, scrollY; // camera location
    
    float zoom = 0.05f;
    
    public float getScrollX() { return scrollX; }
    public float getScrollY() { return scrollY; }
	
	public void init()
	{
		g = new Graphics();
		
        g.setAmbientLight(150, 150, 150);

        try
        {
			//g.createDiffuseLight(30, 30, 255, 255, 255, 100, 500);
			// create a white (RGB: 255, 255, 255) diffuse light at point 30, 30 with an inner radius of 100 and outer radius of 500.
			// note: the inner radius is the radius that is always 100% lit, and the outer radius is the radius that is gradually dimmed.  play around with the values and see...
			
			//create the player's torch:
			torch = g.createDiffuseLight(0,-500, 255, 147, 59, 10, 250);
        }
        catch (Exception e)
        {
			e.printStackTrace();
		}

        background = new Image("assets/background.jpg");
        player = new Player();
	}
	
	public void tick(float delta)
	{
		//make the player's torch follow player:
		torch.setXY(player.getX() + player.getVelX() + (player.getWidth()/2), player.getY() + player.getVelY() + (player.getHeight()/2));
		
		if(Input.keys[Keys.S] > 0){
			torch.increaseColors(-150*delta,-150*delta,-150*delta);
		}
	
		
//		zoom += delta * 0.1f;
	//	if (zoom > 1.0f)
			zoom = 1.0f;
		g.setZoom(zoom);
		
		player.tick(delta);

		scrollX = player.getX() - SCREEN_WIDTH / 2 + player.getWidth() / 2;
		scrollY = -925;
		//scrollY = player.getY() - SCREEN_HEIGHT / 2 + player.getHeight() / 2;
	}
	
	public void draw()
	{
		for (int x = -10; x < 11; x++)
			for (int y = -10; y < 11; y++)
				g.drawImage(background, x * background.getWidth() - scrollX, y * background.getHeight() - scrollY, 1.0f);
		player.draw(g, scrollX, scrollY);

	}
}
