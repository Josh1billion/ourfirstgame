package com.orbusoft.ourfirstgame;

import com.badlogic.gdx.Input.Keys;
import com.josh.graphicsengine2d.*;		//TODO: move this import to the Entity.java base class, such that not every entity in the game needs to import it on their own.
										//TODO: give the above TODO statement a more sane length, so it does not go off the side of the screen.
public class Player extends Entity
{	
	int frame = 0;
	float gravity = 5000;
	float jump = -60000;
	float friction = 5000;
	float airResistance = 2000;
	float acceleration = 4500;
	float maxRunSpeed = 600;
	
	public Player()
	{
		
		image = new Image("assets/player.png", 128, 192);
		image.setFrame(0);
		y = 500;
		x = 0;
		velX = 0;
		velY = 0;
		frame = 0;
		width = 128;
		height = 192;
	}
	
	public void tick(float delta)
	{
		
		
		
		velY += gravity*delta;
		
		if (Input.keys[Keys.W] > 0 && Input.keys[Keys.W] < 10)
			velY = jump*delta;
		
		if (Input.keys[Keys.A] > 0)
		{
			//if(velX >= maxRunSpeed * delta * -1){
			//TODO: Fix the above line of code such that the player doesn't keep running at above-max speed
			//		after getting an FPS drop for one frame.
				if (velX > maxRunSpeed*-1 + acceleration*delta)
					velX += acceleration*delta*-1;
				else
					velX = maxRunSpeed*-1;
			//}
		}
		else if (Input.keys[Keys.D] > 0)
		{
			//if(velX <= maxRunSpeed*delta){	//So the player doesn't lose excess speed from slopes or whatever, 
				//which he might want to use.
				if(velX < maxRunSpeed - acceleration*delta)
					velX += acceleration*delta;
				else
					velX = maxRunSpeed;
			//}
		} 
		else
		{	
			//if player isn't pressing A or D
			if (y >= 500 - velY*delta)
			{
				//player is on the ground; apply friction!
				if (velX > friction*delta)
					velX -= friction*delta;
				else if (velX < -1*friction*delta)
					velX += friction*delta;
				else
					velX = 0;
			}
			else
			{
				//player is not on the ground, but in the air.
				//do not apply friction, apply air resistance instead (which is the same as friction but a lower number)
				if (velX > airResistance*delta)
					velX -= airResistance*delta;
				else if (velX < -1*airResistance*delta)
					velX += airResistance*delta;
				else
					velX = 0;
			}
		}
		if (Input.keys[Keys.S] > 0)
		{
			//crouch or move down ladder or whatever
		}
		
		
		
		
		if (y >= 500 - velY*delta)
		{
			y = 500; 		//the whole world is basically a flat piece of ground.
							//This is done to easily test the different physics settings.
			if (velY > 0)
				velY = 0;
		}
		
		x += velX * delta;
		y += velY * delta;
		
		
		frame++;
		image.setFrame(0);
		if (velX != 0)
			image.setFrame(8);
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
