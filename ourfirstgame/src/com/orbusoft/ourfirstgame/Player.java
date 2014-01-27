package com.orbusoft.ourfirstgame;

import com.badlogic.gdx.Input.Keys;
import com.josh.graphicsengine2d.*;

public class Player
{
	private Image images[];
	
	private float x, y;
	private float velX, velY;
	
	private float width = 64.0f;
	private float height = 64.0f;
	
	public Player()
	{
		images = new Image[1];
		images[0] = new Image("assets/test.png");
	}
	
	public void tick(float delta)
	{
		float speed = 100.0f;
		
		// movement
		if (Input.keys[Keys.LEFT] > 0)
			x -= speed * delta;
		if (Input.keys[Keys.RIGHT] > 0)
			x += speed * delta;
		if (Input.keys[Keys.UP] > 0)
			y -= speed * delta;
		if (Input.keys[Keys.DOWN] > 0)
			y += speed * delta;
	}
	
	public void draw(Graphics g, float screenX, float screenY)
	{
		g.drawImage(images[0], x - screenX, y - screenY, 1.0f);
	}

	public float getX() { return x; }
	public float getY() { return y; }
	public float getWidth() { return width; }
	public float getHeight() { return height; }
	
}
