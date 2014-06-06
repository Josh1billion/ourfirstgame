package com.orbusoft.ourfirstgame;

import com.josh.graphicsengine2d.Graphics;
import com.josh.graphicsengine2d.Image;

public class Level
{
	Tile tiles[][];
	
	public Level()
	{
		Image tilesetImage = new Image("assets/tilesets/1.png", 64, 64);
		
		tiles = new Tile[30][20];
		for (int x = 0; x < tiles.length; x++)
			for (int y = 0; y < tiles[x].length; y++)
				tiles[x][y] = new Tile(tilesetImage, (int)(Math.random()*10));
	}
	
	public void draw(Graphics g, float scrollX, float scrollY)
	{
		for (int x = 0; x < tiles.length; x++)
			for (int y = 0; y < tiles[x].length; y++)
				tiles[x][y].draw(g, x*64, y*64, scrollX, scrollY);
	}
}
