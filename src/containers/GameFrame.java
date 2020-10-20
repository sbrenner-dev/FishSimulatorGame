package containers;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Window;

import javax.swing.JFrame;

import main.FishSimulatorGame;

/**
 * Extension of {@link JFrame}. Contains a panel, representing a canvas on which
 * to draw resources and buffered image-like objects to
 * 
 * @author Sam Brenner
 * @see JFrame
 *
 */

public class GameFrame extends JFrame {

	/**
	 * Random generated serialVersionUID
	 */
	private static final long serialVersionUID = -1096664458821778754L;

	/**
	 * Canvas for this frame
	 */
	private GameCanvas canvas;

	/**
	 * Initializes this {@link GameFrame}
	 */
	public GameFrame() {
		init();
	}

	/**
	 * Paints the canvas for this {@link GameFrame} to the {@link Window}
	 */
	@Override
	public void paint(Graphics g) {
		canvas.paint(g);
	}

	/**
	 * Initializes this frame, including size, canvas, and visibility
	 */
	private void init() {
		this.canvas = new GameCanvas();
		this.add(canvas);
		this.setSize(new Dimension(FishSimulatorGame.WIDTH, FishSimulatorGame.HEIGHT));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.requestFocus();
	}

}
