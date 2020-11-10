package models;

import java.awt.Graphics;

import handlers.ImageAsset;

public class Background extends GameObject {

	public Background(int ID, int x, int y, int width, int height, ImageAsset image) {
		super(ID, x, y, width, height, image);
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(this.image.getImage(), this.x, this.y, this.width, this.height, null);
	}

	@Override
	public void tick() {
		// do nothing
	}

}
