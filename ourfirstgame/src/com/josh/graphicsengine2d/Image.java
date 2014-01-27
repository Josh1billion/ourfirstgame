package com.josh.graphicsengine2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix4;


public class Image
{
	private Texture texture = null;
	
	private Mesh quad = null;
	
	float width = 0.0f;
	float height = 0.0f;
	
	public Image(Texture texture)
	{
		this.texture = texture;
		
		width = texture.getWidth();
		height = texture.getHeight();
		
		float repeatCountX = 1.0f;
		float repeatCountY = 1.0f;
		
		quad = new Mesh(true, 4, 6, VertexAttribute.Position(), VertexAttribute.ColorUnpacked(), VertexAttribute.TexCoords(0));
		quad.setVertices(new float[] 
		{-width/2.0f, -height/2.0f, 0, 1, 1, 1, 1, 0, -repeatCountY,
		width/2.0f, -height/2.0f, 0, 1, 1, 1, 1, repeatCountX, -repeatCountY,
		width/2.0f, height/2.0f, 0, 1, 1, 1, 1, repeatCountX, 0,
		-width/2.0f, height/2.0f, 0, 1, 1, 1, 1, 0, 0});
		quad.setIndices(new short[] {0, 1, 2, 0, 2, 3});
	}
	
	public Image(String filename)
	{
		this(new Texture(Gdx.files.internal(filename)));
	}
	
	public Image(float width, float height)
	{ // to-do: this (create a new Image for drawing upon).  partially done, but none of the render functions right now draw onto its Pixmap...
		this.width = width;
		this.height = height;
		this.texture = new Texture((int)width, (int)height, Pixmap.Format.RGBA4444);
	}
	
	public void render(Graphics g, GL20 gl, ShaderProgram shader, OrthographicCamera camera, float x, float y, float alpha)
	{
		render(g, gl, shader, camera, x, y, 1.0f, 1.0f, alpha);
	}
	
	public void render(Graphics g, GL20 gl, ShaderProgram shader, OrthographicCamera camera, float x, float y, float scaleX, float scaleY, float alpha)
	{
		gl.glActiveTexture(GL20.GL_TEXTURE0);
		gl.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_WRAP_S, GL20.GL_REPEAT);
		gl.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_WRAP_T, GL20.GL_REPEAT);
		
		texture.bind();
		
		Matrix4 quadTranslation = new Matrix4(new float[] { 1, 0, 0, x + width/2.0f*scaleX + 0.5f,
														   0, 1, 0, y + height/2.0f*scaleY + 0.5f,
														   0, 0, 1, 0,
														   0, 0, 0, 1});
		
		gl.glUniform1i(gl.glGetUniformLocation(0, "u_texture"), 0);
		shader.begin();
	//	shader.setAttributef("a_color2", 1, 1, 1, 1.0f); // color adjustment (for fading/tinting, etc.).  r,g,b,1.0f
		g.uploadLightsToShader(shader); // prepare lights
		g.uploadFadeLevelToShader(shader); // prepare fading
		shader.setUniformf("scaleX", scaleX);
		shader.setUniformf("scaleY", scaleY);
		shader.setUniformf("alpha", alpha);
		shader.setUniformMatrix("u_transformation", quadTranslation );
		shader.setUniformMatrix("u_worldView", camera.combined );
		quad.render(shader, GL20.GL_TRIANGLES);
		shader.end();
		
		// the following three lines fix a weird bug where only all but the last image having its render() method called were being rendered...
		gl.glActiveTexture(GL20.GL_TEXTURE0);
		gl.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_WRAP_S, GL20.GL_REPEAT);
		gl.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_WRAP_T, GL20.GL_REPEAT);
	}
	
	
	public void dispose()
	{
		texture.dispose();
	}
	
	public int getWidth()
	{
		return texture.getWidth();
	}
	
	public int getHeight()
	{
		return texture.getHeight();
	}
}
