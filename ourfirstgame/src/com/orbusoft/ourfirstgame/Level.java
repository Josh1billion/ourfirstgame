package com.orbusoft.ourfirstgame;

import com.josh.graphicsengine2d.Graphics;
import com.josh.graphicsengine2d.Image;

public class Level
{
	final static int TILE_WIDTH = 64;
	final static int TILE_HEIGHT = 64;
	
	int widthInTiles = 50;
	int heightInTiles = 50;
	
	private Tile tiles[][];
	
	public Level()
	{
		Image tilesetImage = new Image("assets/tilesets/1.png", TILE_WIDTH, TILE_HEIGHT);
		
		tiles = new Tile[widthInTiles][heightInTiles];
		for (int x = 0; x < tiles.length; x++)
			for (int y = 0; y < tiles[x].length; y++)
				tiles[x][y] = new Tile(tilesetImage, (int)(Math.random()*10));
	}

	
	public void draw(Graphics g, float scrollX, float scrollY)
	{
		for (int x = 0; x < tiles.length; x++)
			for (int y = 0; y < tiles[x].length; y++)
				tiles[x][y].draw(g, x * TILE_WIDTH, y * TILE_HEIGHT, scrollX, scrollY);
	}

	public int getWidthInPixels() { return widthInTiles * TILE_WIDTH; }
	public int getHeightInPixels() { return heightInTiles * TILE_HEIGHT; }
	
	public int getWidthInTiles() { return widthInTiles; }
	public int getHeightInTiles() { return heightInTiles; }
}
