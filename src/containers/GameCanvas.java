package containers;

import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import handlers.GameObjectHolder;
import models.GameObject;

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

	private GameFrame parent;

	public GameCanvas(GameFrame parent) {
		this.parent = parent;
	}
	
	public GameFrame getParent() {
		return this.parent;
	}

	/**
	 * Paints components to this {@link GameCanvas}
	 * 
	 * @param g Graphics component to paint to this {@link GameCanvas}
	 */
	@Override
	public void paintComponent(Graphics g) {
		clean();
//		g.setColor(Color.white);
//		g.fillRect(0, 0, FishSimulatorGame.WIDTH, FishSimulatorGame.HEIGHT);
		Iterator<GameObject> itr = GameObjectHolder.getIterator();
		while (itr.hasNext()) {
			GameObject gObj = itr.next();
			gObj.draw(g);
		}
	}

	public void tick() {
		clean();
		Iterator<GameObject> itr = GameObjectHolder.getIterator();
		while (itr.hasNext()) {
			GameObject gObj = itr.next();
			gObj.tick();
		}
	}
	
	private void clean() {
		System.gc();
		this.removeAll();
	}

}
