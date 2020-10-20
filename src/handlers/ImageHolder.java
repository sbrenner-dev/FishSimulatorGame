package handlers;

import java.util.HashSet;
import java.util.Iterator;

import containers.GameCanvas;

/**
 * Holds assets for this Fish Simulator, which can be drawn to the screen
 * 
 * @author Sam Brenner
 * @see ImageAsset
 * @see GameCanvas
 *
 */

public class ImageHolder {

	/**
	 * {@link HashSet} of {@link ImageAsset} objects for drawing to a
	 * {@link GameCanvas}
	 */
	private static HashSet<ImageAsset> images;

	/**
	 * Initializes the {@link HashSet}, can be recalled to reset resources
	 */
	public static void initialize() {
		images = new HashSet<ImageAsset>();
	}

	/**
	 * Adds an image to the {@link HashSet}
	 * @param img {@link ImageAsset} to add to this {@link ImageHolder}
	 * @return {@code true} if the {@link ImageAsset} was successfully added to {@link #images}
	 */
	public static boolean add(ImageAsset img) {
		return images.add(img);
	}

	/**
	 * Gets the {@link Iterator} for {@link #images}
	 * @return {@link Iterator} for {@link #images}
	 */
	public static Iterator<ImageAsset> getIterator() {
		return images.iterator();
	}

}
