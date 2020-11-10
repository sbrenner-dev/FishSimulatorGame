package handlers;

import java.util.HashSet;
import java.util.Iterator;

import containers.GameCanvas;
import models.GameObject;

public class GameObjectHolder {
	
	/**
	 * {@link HashSet} of {@link ImageAsset} objects for drawing to a
	 * {@link GameCanvas}
	 */
	private static HashSet<GameObject> gameObjects;

	/**
	 * Initializes the {@link HashSet}, can be recalled to reset resources
	 */
	public static void initialize() {
		gameObjects = new HashSet<GameObject>();
	}

	/**
	 * Adds an image to the {@link HashSet}
	 * @param img {@link ImageAsset} to add to this {@link ImageHolder}
	 * @return {@code true} if the {@link ImageAsset} was successfully added to {@link #gameObjects}
	 */
	public static boolean add(GameObject img) {
		return gameObjects.add(img);
	}

	/**
	 * Gets the {@link Iterator} for {@link #gameObjects}
	 * @return {@link Iterator} for {@link #gameObjects}
	 */
	public static Iterator<GameObject> getIterator() {
		return gameObjects.iterator();
	}

}
