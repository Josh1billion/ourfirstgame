package com.josh.graphicsengine2d;

import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector3;

public class Light
{
	public enum LightType { LIGHT_DIFFUSE, LIGHT_SPECULAR };
	
	private Graphics g;
	private LightType type = LightType.LIGHT_DIFFUSE;
	private int index;
	private float x, y;
	private float red, green, blue;
	private float innerRadius, outerRadius;
	
	
	public Light(Graphics g, int index, LightType type, float x, float y, float r0to255, float g0to255, float b0to255, float innerRadius, float outerRadius)
	{ // should not be called directly!  use Graphics.createDiffuseLight() or Graphics.createSpecularLight() instead.
		this.g = g;
		this.type = type;
		this.x = x;
		this.y = y;
		this.red = r0to255 / 255.0f;
		this.green = g0to255 / 255.0f;
		this.blue = b0to255 / 255.0f;
		this.innerRadius = innerRadius;
		this.outerRadius = outerRadius;
		this.index = index;
	}
	
	public void activateOnShader(ShaderProgram shader)
	{ // called internally by Graphics.
		shader.setUniformf("lightPositions[" + index + "]", new Vector3(x, y, 0.0f));
		shader.setUniformf("lightColors[" + index + "]", new Vector3(red, green, blue));
		shader.setUniformf("lightInnerRadiuses[" + index + "]", innerRadius);
		shader.setUniformf("lightOuterRadiuses[" + index + "]", outerRadius);		
	}
	
	public void remove() throws Exception
	{
		g.removeLight(this);
	}
}
