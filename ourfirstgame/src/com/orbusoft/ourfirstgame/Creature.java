package com.orbusoft.ourfirstgame;

public class Creature extends Entity{
	
	/* base class for all moving creatures in the world,
	 * including the player, any hostile monsters,
	 * the allied pets which the player use, and anything else which might
	 * need basic stuff like map tile collision tests or damage calculations
	 * used on them.
	*/
	
	/*
	 * TODO: put things like takeDamage() functions and similliar in here.
	 * Fundamental stuff that will apply to any creature in our game.
	 */
	
	/*
	 * AVOID: all things which are specific to any set of classes other than all creatures.
	 * Things which apply only to a subset of creatures should have their own sub-base-class 
	 * (there is probably a more correct terminology for this sort of thing, i don't know).
	 * e.g. all enemy creatures should inherit from the HostileCreature class, where the 
	 * HostileCreature class inherits from this Creature class.
	 */
	
}
