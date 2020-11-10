package handlers;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import models.Background;
import models.GameObject;
import models.GoldFish;

public class GameObjectLoader {

	public static GameObject loadGameObject(String csvLine) {
		String[] csv = csvLine.split(", ");
		GameObject gObj = createGameObject(csv);
		return gObj;
	}

	private static GameObject createGameObject(String[] csv) {
		int ID = Integer.parseInt(csv[0]);
		String type = csv[1];
		ImageAsset image = null;
		try {
			image = new ImageAsset(ImageIO.read(new File(csv[2])));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int x = Integer.parseInt(csv[3]);
		int y = Integer.parseInt(csv[4]);
		int width = Integer.parseInt(csv[5]);
		int height = Integer.parseInt(csv[6]);
		
		switch (type) {
		case "Fish":
			return new GoldFish(ID, x, y, width, height, image);
		case "Background":
			return new Background(ID, x, y, width, height, image);
		default:
			return null;
		}
	}

}
