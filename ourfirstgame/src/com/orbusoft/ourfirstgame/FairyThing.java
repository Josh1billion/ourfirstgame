package com.orbusoft.ourfirstgame;
import com.josh.graphicsengine2d.*;	


public class FairyThing extends FlyingAlly
{

	
	public FairyThing(){
		image = new Image("assets/flything.png", 40, 40);
		image.setFrame(0);
		y = 500;
		x = 450;
		width = 40;
		height = 40;
	}
	
	
	public void tick(float delta)
	{
		x += velX * delta;
		y += velY * delta;
		super.tick(delta);
	}
	
	public void draw(Graphics g, float scrollX, float scrollY)
	{
		g.drawImage(image, x - scrollX, y - scrollY, 1.0f, 1.0f, 1.0f, (deltaX(Globals.game.getPlayer()) > 0), false);
	}
	
	public float getX() { return x; }
	public float getY() { return y; }
	public float getVelX(){ return velX;}
	public float getVelY(){ return velY;}
	public float getWidth() { return width; }
	public float getHeight() { return height; }
}
