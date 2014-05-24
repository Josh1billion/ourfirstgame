package com.orbusoft.ourfirstgame;

import com.josh.graphicsengine2d.*;
import com.josh.graphicsengine2d.Light.LightType;
import com.badlogic.gdx.Input.Keys;

public class Game
{
	public Graphics g;
    
    public static final int		SCREEN_WIDTH = 1920;
    public static final int		SCREEN_HEIGHT = 1080; // former resolution: 512x416
    
    private Player player;
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
			
			Light alert = new AlertLight(g, 1, 4.0f, -1375, 700, 150, 250);
			g.addLight(alert, LightType.LIGHT_DIFFUSE);
			//create the player's torch
			lampyGlow = g.createDiffuseLight(0, 0, 230, 230, 230, 30, 300);
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
			lampyGlow.increaseColors(-150*delta,-150*delta,-150*delta);
		}
	
		
//		zoom += delta * 0.1f;
	//	if (zoom > 1.0f)
			zoom = 1.0f;
		g.setZoom(zoom);
		
		player.tick(delta);
		lampy.tick(delta);
		//Lampy's glow follows Lampy!
		lampyGlow.setPosition(lampy.getX() + (lampy.getWidth()/2), lampy.getY() + (lampy.getHeight()/2));
		/*lampy's glow flickers.
		 *red/green/blue values change independently, based on a sine function, at separate frequencies but 
		 *with equal amplitude
		 */
		lampyGlow.increaseColors((float)Math.sin(lampy.liveTime*7)*3, (float)Math.sin(lampy.liveTime*3)*3, (float)Math.sin(lampy.liveTime*5)*3);
		
		scrollX = player.getX() - SCREEN_WIDTH / 2 + player.getWidth() / 2;
		scrollY = player.getY() - SCREEN_HEIGHT / 2 + player.getHeight() / 2;
		
		g.tick(delta);
	}
	
	public void draw()
	{
		for (int x = -10; x < 11; x++)
				g.drawImage(background, x * 1920 - scrollX, 0 - scrollY, 1.0f);
		player.draw(g, scrollX, scrollY);
		lampy.draw(g,scrollX,scrollY);

	}
	
	
	// getters and setters
	public Player getPlayer() { return player; }
}
