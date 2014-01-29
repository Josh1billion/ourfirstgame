package com.orbusoft.ourfirstgame;

import com.badlogic.gdx.Input.Keys;
import com.josh.graphicsengine2d.*;

public class Player
{
	private Image image;
	private float x, y;
	private float velX, velY;
	private float width = 32.0f;
	private float height = 32.0f;
	
	
	
	int frame;
	
	int frame;
	
	int frame;
	
	public Player()
	{
		image = new Image("assets/test.png", 32, 32);
		image.setFrame(0);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
		y = -500;
		x = 0;
		velX = 0;
		velY = 0;
=======
		
		frame = 0;
>>>>>>> 9970be2a8162fb01c1516647e01a3c49ca4005f6
=======
		
		frame = 0;
>>>>>>> 9970be2a8162fb01c1516647e01a3c49ca4005f6
=======
		
		frame = 0;
>>>>>>> 9970be2a8162fb01c1516647e01a3c49ca4005f6
	}
	
	public void tick(float delta)
	{
<<<<<<< HEAD
		
		
		
		////////////////////////////START PHYSICS 01!\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		/*			
						
		//player movement is at a constant speed in this one. 
		//he does not need to spend time accelerating or slowing down.
 
		float gravity = 50;		//TODO: move these variable declarations out of the tick function
		float jump = 14;		//TODO: when we've decided which numbers we're using.
		float maxRunSpeed = 200;
		velY += gravity*delta;
		
		if(Input.keys[Keys.W] == 1){
			velY -= jump;
		}
		if(Input.keys[Keys.A] > 0){
			//if(velX >= maxRunSpeed * delta * -1){
			 	//TODO: Fix the above line of code such that the player doesn't keep running at above-max speed
			 	//		after getting an FPS drop for one frame.
			 	 
				velX = maxRunSpeed * delta * -1;
			//}
		}
		else if(Input.keys[Keys.D] > 0){
			//if(velX <= maxRunSpeed*delta){	//So the player doesn't lose excess speed from slopes or whatever, 
												//which he might want to use.
				velX = maxRunSpeed*delta;
			//}
		} 
		else{	//if player isn't pressing A or D
			if(y >= -485 - velY){
				velX = 0;
			}
		}
		if(Input.keys[Keys.S] > 0){
			//crouch or move down ladder or whatever
		}
		
		////////////////////////////END PHYSICS 01!\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		*/
		
		
		
		
		////////////////////////////START PHYSICS 02!\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		//player movement is more organic in this one - you spend a fraction of a second speeding up 
		//when you start running, and when you stop running your speed has to slow down a little.
		//I made sure it doesn't feel like you're running on ice, but it's a subtle touch which, if i did it right
		//should help make the movement feel more "real". 
		
		//Since the player doesn't move at max speed instantly in this one, i was able to increase 
		//the max speed slightly. In physics01, having a max speed of 300 just made it feel weird when you
		//initially pressed the D button; the acceleration was too high. With the more natural acceleration in 
		//physics02, i think we can let the player achieve higher top speeds without making it feel too 
		//mechanical or clunky.
		
		
		float gravity = 45;		//TODO: move these variable declarations out of the tick function
		float jump = 13;		// when we've decided which numbers we're using.
		float friction = 30;
		float airResistance = 5;
		float acceleration = 150;
		float maxRunSpeed = 300;
		velY += gravity*delta;
		
		if(Input.keys[Keys.W] == 1){
			velY -= jump;
		}
		if(Input.keys[Keys.A] > 0){
			//if(velX >= maxRunSpeed * delta * -1){
			//TODO: Fix the above line of code such that the player doesn't keep running at above-max speed
			//		after getting an FPS drop for one frame.
				if(velX > maxRunSpeed*delta*-1 - acceleration*delta*-1){
					velX += acceleration*delta*-1;
				}
				else{
					velX = maxRunSpeed*delta*-1;
				}
			//}
		}
		else if(Input.keys[Keys.D] > 0){
			//if(velX <= maxRunSpeed*delta){	//So the player doesn't lose excess speed from slopes or whatever, 
				//which he might want to use.
				if(velX < maxRunSpeed*delta - acceleration*delta){
					velX += acceleration*delta;
				}
				else{
					velX = maxRunSpeed*delta;
				}
			//}
		} 
		else{	
			//if player isn't pressing A or D
			if(y >= -485 - velY){
				//player is on the ground; apply friction!
				if(velX > friction*delta){
					velX -= friction*delta;
				}
				else if(velX < -1*friction*delta){
					velX += friction*delta;
				}
				else{
					velX = 0;
				}
			}
			else{
				//player is not on the ground, but in the air.
				//do not apply friction, apply air resistance instead (which is the same as friction but a lower number)
				if(velX > airResistance*delta){
					velX -= airResistance*delta;
				}
				else if(velX < -1*airResistance*delta){
					velX += airResistance*delta;
				}
				else{
					velX = 0;
				}
			}
		}
		if(Input.keys[Keys.S] > 0){
			//crouch or move down ladder or whatever
		}
		
		////////////////////////////END PHYSICS 02!\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		
		
		
		if(y >= -485 - velY){
			y = -485; 		//the whole world is basically a flat piece of ground.
							//This is done to easily test the different physics settings.
			if(velY > 0){
				velY = 0;
			}
		}
		
		x += velX;
		y += velY;
=======
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
		
		frame++;
		image.setFrame(frame);
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 9970be2a8162fb01c1516647e01a3c49ca4005f6
=======
>>>>>>> 9970be2a8162fb01c1516647e01a3c49ca4005f6
=======
>>>>>>> 9970be2a8162fb01c1516647e01a3c49ca4005f6
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
