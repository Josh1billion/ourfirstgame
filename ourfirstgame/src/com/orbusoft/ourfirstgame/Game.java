package com.orbusoft.ourfirstgame;

import com.josh.graphicsengine2d.*;
import com.josh.graphicsengine2d.Light.LightType;
import com.badlogic.gdx.Input.Keys;

public class Game
{
	public Graphics g;
    
    public static final int		SCREEN_WIDTH = 1920;
    public static final int		SCREEN_HEIGHT = 1080; // former resolution: 512x416
    
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
		
        g.setAmbientLight(10, 10, 50);

        try
        {
			//create the player's torch
			Light alert = new AlertLight(g, -1, 1.0f, 600, -400, 150, 150);
			g.addLight(alert, LightType.LIGHT_DIFFUSE);

			torch = g.createDiffuseLight(0, 0, 255, 255, 255, 200, 200);
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
		torch.setPosition(player.getX() + (player.getWidth()/2), player.getY() + (player.getHeight()/2));
		
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
		
		g.tick(delta);
	}
	
	public void draw()
	{
		for (int x = -10; x < 11; x++)
			for (int y = -10; y < 11; y++)
				g.drawImage(background, x * background.getWidth() - scrollX, y * background.getHeight() - scrollY, 1.0f);
		player.draw(g, scrollX, scrollY);

	}
}
