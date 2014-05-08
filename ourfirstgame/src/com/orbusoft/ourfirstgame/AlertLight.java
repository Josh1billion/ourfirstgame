package com.orbusoft.ourfirstgame;

import com.josh.graphicsengine2d.Graphics;
import com.josh.graphicsengine2d.Light;

// This is great fun much excitement :D
public class AlertLight extends Light
{
	private float redTimer = 0.0f;
	private float speed = 1.0f;

	public AlertLight(Graphics g, int index, float speed, float x, float y, float innerRadius, float outerRadius)
	{
		super(g, index, LightType.LIGHT_DIFFUSE, x, y, 10, 10, 10, innerRadius, outerRadius);
		this.speed = speed;
	}
	
	@Override
	public void tick(float delta)
	{
		redTimer += delta * Math.PI * speed;
		while (redTimer > Math.PI * 2)
			redTimer -= Math.PI * 2;
		double test = (Math.sin(redTimer) + 1.0f) * 0.5f;
		red = (float)test;
		blue = 0.0f;
		green = 0.0f;
	}

}
