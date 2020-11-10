package models;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import handlers.ImageAsset;

public abstract class GameObject {
	
	protected int ID, x, y, width, height;
	
	protected ImageAsset image;
	
	public GameObject(int ID, int x, int y, int width, int height, ImageAsset image) {
		this.ID = ID;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
	}
	
	public abstract void draw(Graphics g);
	
	public abstract void tick();
	
	public BufferedImage getImage() {
		return this.image.getImage();
	}
	
	@Override
	public int hashCode() {
		return this.ID;
	}

}
