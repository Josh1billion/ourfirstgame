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
    FairyThing lampy;
    Image background;
    Light torch, lampyGlow;
    
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
			
			Light alert = new AlertLight(g, 1, 4.0f, 0, 500, 150, 250);
			g.addLight(alert, LightType.LIGHT_DIFFUSE);
			//create the player's torch
			torch = g.createDiffuseLight(0, 0, 255, 255, 255, 200, 200);
			lampyGlow = g.createDiffuseLight(0, 0, 175, 175, 0, 60, 90);
        }
        catch (Exception e)
        {
			e.printStackTrace();
		}

        background = new Image("assets/background.jpg");
        player = new Player();
        lampy = new FairyThing();
	}
	
	public void tick(float delta)
	{
		
		if(Input.keys[Keys.S] > 0){
			torch.increaseColors(-150*delta,-150*delta,-150*delta);
		}
	
		
//		zoom += delta * 0.1f;
	//	if (zoom > 1.0f)
			zoom = 1.0f;
		g.setZoom(zoom);
		
		player.tick(delta);
		//make the player's torch follow player:
		torch.setPosition(player.getX() + (player.getWidth()/2), player.getY() + (player.getHeight()/2));
		
		lampyGlow.setPosition(lampy.getX() + (lampy.getWidth()/2), lampy.getY() + (lampy.getHeight()/2));
		
		scrollX = player.getX() - SCREEN_WIDTH / 2 + player.getWidth() / 2;
		scrollY = player.getY() - SCREEN_HEIGHT / 2 + player.getHeight() / 2;
		
		g.tick(delta);
	}
	
	public void draw()
	{
		for (int x = -10; x < 11; x++)
				g.drawImage(background, x * 1920 - scrollX, 0 - scrollY, 1.0f);
		player.draw(g, scrollX, scrollY);
		lampy.draw(g, scrollX, scrollY);

	}
}
