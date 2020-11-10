package runnables;

import main.FishSimulatorGame;

/**
 * {@link Thread} object that runs an instance of a {@link FishSimulatorGame}
 * 
 * @author Sam Brenner
 * @see Thread
 * @see Runnable
 *
 */

public class GameRunner extends Thread {

	/**
	 * {@link FishSimulatorGame} instance to run
	 */
	private FishSimulatorGame game;

	/**
	 * Constructs this runner
	 * 
	 * @param game {@link FishSimulatorGame} instance to run
	 */
	public GameRunner(FishSimulatorGame game) {
		super();
		this.game = game;
	}

	/**
	 * Runs the game instance indefinitely by rendering a frame of the
	 * {@link FishSimulatorGame} instance
	 */
	@Override
	public void run() {
		while (true) {
			game.render();
			game.tick();
			try {
				Thread.sleep(40); // light sleep for frame updating
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
