package com.orbusoft.ourfirstgame;

public class FlyingAlly extends AlliedCreature
{
	float liveTime = 0;

	
	public void tick(float delta)
	{
		liveTime += delta*7;
		y += (float)Math.sin(liveTime) * 0.8f;
		super.tick(delta);
	}
	
}