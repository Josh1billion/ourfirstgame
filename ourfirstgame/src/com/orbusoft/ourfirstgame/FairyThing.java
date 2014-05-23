package com.orbusoft.ourfirstgame;
import com.josh.graphicsengine2d.*;	


//this is just a test class, used to test inheritence and what not.

public class FairyThing extends FlyingAlly{
	private Image image;
	private float width = 40.0f;
	private float height = 40.0f;
	private float x, y;
	private float velX, velY; 	
	
	public float liveTime;
	
	public FairyThing(){
		image = new Image("assets/flything.png", 40, 40);
		image.setFrame(0);
		y = 500;
		x = 450;
		liveTime = 0;
	}
	
	
	public void tick(float delta)
	{
		
		
		x += velX;
		y += velY;
		liveTime += delta*7;
		y += (float)Math.sin(liveTime) * 0.8f;
	}
	
	public void draw(Graphics g, float scrollX, float scrollY)
	{
		g.drawImage(image, x - scrollX, y - scrollY, 1.0f, 1.0f, 1.0f);
	}
	
	public float getX() { return x; }
	public float getY() { return y; }
	public float getVelX(){ return velX;}
	public float getVelY(){ return velY;}
	public float getWidth() { return width; }
	public float getHeight() { return height; }
}
