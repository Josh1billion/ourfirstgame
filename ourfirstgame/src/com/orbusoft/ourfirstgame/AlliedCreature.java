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
	
	AlliedCreature()
	{
	}
	
	public void tick(float delta)
	{
		followPlayer(delta);
		super.tick();
	}
	
	public void followPlayer(float delta)
	{
		float followIfFartherThan = 200.0f;
		
		Player player = Globals.game.getPlayer();
		if (this.distanceTo(player) < followIfFartherThan)
		{
			if (velX > player.getVelX() + 1000*delta)
			{
				velX -= 1000 * delta;
				if (velX < 0.0f)
					velX = 0.0f;
			}
			else if (velX < player.getVelX() - 1000*delta)
			{
				velX += 1000 * delta;
				if (velX > 0.0f)
					velX = 0.0f;
			}
			return;
		}

		if (player.getX() > this.x)
			velX += 3 * this.distanceTo(player) * delta;
		if (player.getX() < this.x)
			velX -= 3 * this.distanceTo(player) * delta;
		if (velX > 1000.0f)
			velX = 1000.0f;
		if (velX < -1000.0f)
			velX = -1000.0f;
	}
}

