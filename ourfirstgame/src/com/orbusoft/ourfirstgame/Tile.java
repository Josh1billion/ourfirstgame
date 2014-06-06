package com.orbusoft.ourfirstgame;

import com.josh.graphicsengine2d.Graphics;
import com.josh.graphicsengine2d.Image;

public class Tile
{
	Image tilesetImage;
	int frameIndex; // index of tile in the tileset

	
	public Tile(Image tilesetImage, int frameIndex)
	{
		this.tilesetImage = tilesetImage;
		this.frameIndex = frameIndex;
	}
	
	public void draw(Graphics g, int x, int y, float scrollX, float scrollY)
	{
		tilesetImage.setFrame(frameIndex);
		g.drawImage(tilesetImage, x - scrollX, y - scrollY, 1.0f, 1.0f, 1.0f);
	}
}
