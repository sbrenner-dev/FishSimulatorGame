package models;

import java.awt.Graphics;
import java.util.Random;

import handlers.ImageAsset;
import main.FishSimulatorGame;

public class GoldFish extends GameObject {

	private int startX, startY, destinationX, destinationY;
	
	private double dX, dY;

	private boolean sleeping;

	private Random seeder;

	private int ticksAsleep, sleepLength;

	public GoldFish(int ID, int x, int y, int width, int height, ImageAsset image) {
		super(ID, x, y, width, height, image);
		this.destinationX = 0;
		this.destinationY = 0;
		this.startX = 0;
		this.startY = 0;
		this.sleeping = false;
		this.seeder = new Random();
		this.ticksAsleep = 0;
		this.sleepLength = 0;
		this.changeDirection();
		this.dX = 2;
		this.dY = 2;
	}

	@Override
	public void draw(Graphics g) {
//		System.out.println(
//				"drawing fish at (" + x + ", " + y + ") to get to (" + destinationX + ", " + destinationY + ")");
		if (goingLeft()) {
			g.drawImage(this.image.getImage(), this.x, this.y, this.width, this.height, null);
		} else {
			g.drawImage(this.image.getImage(), this.x + this.width, this.y, -this.width, this.height, null);
		}
	}
	
	private boolean goingLeft() {
		return this.startX > this.destinationX;
	}
	
	private double slope() {
		return ((double)(this.destinationY - this.startY)) / (this.destinationX - this.startX);
	}

	private void move() {
		if (!this.sleeping) {
			boolean moveX = this.moveTowardsX();
			boolean moveY = this.moveTowardsY();
			if (moveX && moveY) {
				this.changeDirection();
//				if (seeder.nextInt(50) != 0) {
//					this.changeDirection();
//				} else {
//					this.sleeping = true;
//					this.sleepLength = seeder.nextInt(1000000);
//				}
			}
		} else {
			this.ticksAsleep++;
			if (this.ticksAsleep >= this.sleepLength) {
				this.sleeping = false;
			}
		}
	}

	private boolean moveTowardsX() {
		if (this.destinationX > this.x) {
			this.x += this.dX;
		} else if (this.destinationX < this.x) {
			this.x -= this.dX;
		}
		return inRange(this.x, this.destinationX, this.dX);
	}

	private boolean moveTowardsY() {
		double slope = slope();
		this.y = (int) (slope * (this.x - this.startX) + this.startY);

		return inRange(this.y, this.destinationY, this.dY);
	}

	private boolean inRange(int o, int t, double r) {
		return Math.abs(t - o) <= r;
	}

	private void changeDirection() {
		int randX = seeder.nextInt(FishSimulatorGame.WIDTH - width);
		int randY = seeder.nextInt(FishSimulatorGame.HEIGHT - height - 10) + 10; // offset by 10

		this.startX = this.x;
		this.startY = this.y;
		this.destinationX = randX;
		this.destinationY = randY;
	}

	@Override
	public void tick() {
		this.move();
	}

}
