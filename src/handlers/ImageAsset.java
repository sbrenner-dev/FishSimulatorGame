package handlers;

import java.awt.Window;
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
	 * whether or not this image should be treated as a background image or not
	 */
	private boolean immutable;

	/**
	 * whether or not this image has already been drawn, used in conjunction with
	 * {@link #immutable}
	 */
	private boolean drawn;

	/**
	 * Initializes this {@link ImageAsset}
	 * 
	 * @param image     {@link BufferedImage} to use as an asset to draw to a
	 *                  {@link GameCanvas}
	 * @param immutable initial value for whether or not this image should be
	 *                  conisdered immutable or not
	 */
	public ImageAsset(BufferedImage image, boolean immutable) {
		this.image = image;
		this.immutable = immutable;
		this.drawn = false;
	}

	/**
	 * Accessor for the image asset
	 * 
	 * @return {@link BufferedImage} that is the asset for this {@link ImageAsset}
	 */
	public BufferedImage getImage() {
		return this.image;
	}

	/**
	 * Accessor for the immutability of this asset
	 * 
	 * @return {@code true} if this asset is immutable
	 */
	public boolean isImmutable() {
		return this.immutable;
	}

	/**
	 * Returns whether or not the {@link BufferedImage} associated with this
	 * {@link ImageAsset} has already been drawn. Value of {@link #drawn} set to
	 * {@code true} if this is an immutable asset
	 * 
	 * @return {@code true} if this asset has been drawn to a {@link Window}
	 */
	public boolean drawn() {
		boolean temp = this.drawn;
		if (isImmutable()) {
			this.drawn = true;
		}
		return temp;
	}

}
