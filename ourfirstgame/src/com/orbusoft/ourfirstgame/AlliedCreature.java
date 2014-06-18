package com.orbusoft.ourfirstgame;

import com.josh.graphicsengine2d.Globals;

public class AlliedCreature extends Creature
{
	/*
	 * This is the base class for all creatures which are allied with the player
	 * that is, they follow the player around and help him in various ways.
	 * 
	 */
	
	/*
	 * Creatures who are non-hostile / "friendly" towards the player, but do not
	 * actively follow him around as something similar to a pet-type character
	 * (such as a shopkeeper NPC, for instance), are not allied creatures but rather
	 * neutral creatures. They should inherit from the NeutralCreature (should we call
	 * it "PassiveCreature" instead maybe?) class.
	 * 
	 * TODO: decide name of PassiveCreature/NeurtralCreature class, and create it.
	 */
	
	float followIfFartherThan = 200.0f;
	
	AlliedCreature()
	{
	}
	
	public void tick(float delta)
	{
		followPlayerX(delta);
		super.tick();
	}
	
	public void followPlayerX(float delta)
	{
		
		
		float followIfFartherThan = 200.0f;
		
		Player player = Globals.game.getPlayer();
		if(this.distanceTo(player) < 50){
			if(this.x + (width/2) < player.getX() + (player.getWidth()/2)){
				velX -= 600*delta;
			}
			else{
				velX += 600*delta;
			}
			return;
		}
		if (this.distanceTo(player) < followIfFartherThan)
		{
			if (velX > player.getVelX() + 1000*delta)
			{
				velX -= 1000 * delta;
				
			}
			else if (velX < player.getVelX() - 1000*delta)
			{
				velX += 1000 * delta;
			}
			return;
		}
		
		if (velX > 800.0f)
		{
			velX = 800.0f;
		}
		if (velX < -800.0f)
		{
			velX = -800.0f;
		}
		if (deltaX(player) < 0){
			velX += 800 * delta;
			if(velX < player.getVelX()){
				velX += 2500 * delta;
				return;
			}
		}
		else if (deltaX(player) > 0){
			velX -= 800 * delta;
			if(velX > player.getVelX()){
				velX -= 2500 * delta;
				return;
			}
		}
	}

}

