package handlers;

import java.awt.image.BufferedImage;

import containers.GameCanvas;

/**
 * Represents an image asset for this Fish Simulator. Contains an image, whether
 * or not it is immutable (way of representing background object), and whether
 * or not it has already been draw. To be used in conjunction with an loader and
 * handler
 * 
 * @author Sam Brenner
 * @see ImageHolder
 * @see ImageLoader
 *
 */

public class ImageAsset {

	/**
	 * buffered image represented in asset
	 */
	private BufferedImage image;

	/**
	 * Initializes this {@link ImageAsset}
	 * 
	 * @param image     {@link BufferedImage} to use as an asset to draw to a
	 *                  {@link GameCanvas}
	 * @param immutable initial value for whether or not this image should be
	 *                  conisdered immutable or not
	 */
	public ImageAsset(BufferedImage image) {
		this.image = image;
	}

	/**
	 * Accessor for the image asset
	 * 
	 * @return {@link BufferedImage} that is the asset for this {@link ImageAsset}
	 */
	public BufferedImage getImage() {
		return this.image;
	}

}
