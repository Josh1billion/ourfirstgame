package com.orbusoft.ourfirstgame;

import com.josh.graphicsengine2d.Image;

public class Entity
{
	/*
	 * Base class for all entities in the game.
	 * Entities include things like moving enemies, the player character,
	 * immobile NPCs like shopkeepers and questgivers - basically anything
	 * which is an actual "thing" in the game world.
	 * 
	 * ((should things like menu items, inventory icons, attack projectiles and such
	 * inherit from this as well? I'll let you decide this, Josh, since you have more experience than me [Psaiken])).
	 */
	
	//private float x, y;		//position
	protected Image image;
	protected float x, y;
	protected float velX, velY; 	
	protected int width, height;
	
	protected void tick()
	{
	}
	
	public float distanceTo(Entity other)
	{
		return (float) Math.sqrt(Math.pow((this.x + (this.width/2)) - (other.getX() + (other.getWidth()/2)), 2) + Math.pow((this.x + (this.width/2)) - (other.getX() + (other.getWidth()/2)), 2));
	}
	public float deltaX(Entity other)
	{
		return (float) this.x + (this.width/2) - other.getX() + (other.getWidth()/2);
	}
	public float deltaY(Entity other)
	{
		return (float) this.y + (this.height/2) - other.getY() + (other.getHeight()/2);
	}
	
	public float getWidth(){
		return width;
	}
	public float getHeight(){
		return height;
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
}
