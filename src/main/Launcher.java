package main;

import runnables.GameRunner;

/**
 * Launches the main Fish Simulator game
 * 
 * @author Sam Brenner
 *
 */

public class Launcher {

	/**
	 * Entry point from a terminal or IDE
	 * 
	 * @param args {@link String} array of command-line arguments, not used
	 */
	public static void main(String[] args) {
		FishSimulatorGame game = new FishSimulatorGame(); // game instance

		GameRunner runner = new GameRunner(game);
		runner.start(); // start game
		try {
			runner.join(); // suspend main thread
		} catch (InterruptedException e) {
			e.printStackTrace(); // could redirect to file eventually
		}

	}

}
