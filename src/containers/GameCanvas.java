package containers;

import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import handlers.ImageAsset;
import handlers.ImageHolder;

/**
 * An extension of {@link JPanel}, such that it can be drawn to a
 * {@link JFrame}. Components of the Fish Simulator are drawn to the canvas via
 * resource handlers.
 * 
 * @author Sam Brenner
 * @see JPanel
 *
 */

public class GameCanvas extends JPanel {

	/**
	 * Random generated serialVersionUID
	 */
	private static final long serialVersionUID = -7602354264395158328L;

	/**
	 * Paints components to this {@link GameCanvas}
	 * 
	 * @param g Graphics component to paint to this {@link GameCanvas}
	 */
	@Override
	public void paint(Graphics g) {
		Iterator<ImageAsset> imgItr = ImageHolder.getIterator(); // obtain iterator
		while (imgItr.hasNext()) {
			ImageAsset img = imgItr.next();
			if (!img.isImmutable() ^ !img.drawn()) { // image is either not immutable or not drawn, not both
				g.drawImage(img.getImage(), 0, 0, null); // might have to fiddle with the x, y here
			}
		}
	}

}
