package main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import containers.GameFrame;
import handlers.ImageAsset;
import handlers.ImageHolder;
import handlers.ImageLoader;

/**
 * Represents the main game for this Fish Simulator. Contains width and height
 * constants, a frame to render, and loads all relevant assets to a handler.
 * 
 * @author Sam Brenner
 *
 */

public class FishSimulatorGame {

	/*
	 * PUBLIC VARIABLES
	 */

	/**
	 * Width for game
	 */
	public static final int WIDTH = 1024;

	/**
	 * Height for game
	 */
	public static final int HEIGHT = 576;

	/*
	 * PRIVATE VARIABLES
	 */

	/**
	 * String that contains a csv of assets to load from, creates {@link ImageAsset}
	 * objects to put into a {@link ImageHolder} via a {@link ImageLoader}
	 */
	private static final String ASSETS = "assetsList.txt";

	/**
	 * {@link GameFrame} frame for this game
	 */
	private GameFrame frame;

	/**
	 * Initializes this game by construction the frame and loading assets
	 */
	public FishSimulatorGame() {
		this.frame = new GameFrame();
		try {
			loadAssets();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Renders a frame of this game
	 */
	public void render() {
		frame.repaint();
	}

	/**
	 * Loads assets from the specified CSV
	 * 
	 * @throws IOException if {@link File} from CSV cannot be found
	 */
	private void loadAssets() throws IOException {

		ImageHolder.initialize(); // empty image holder

		// create resource streams
		File assets = new File(ASSETS);
		Scanner in = new Scanner(assets);

		while (in.hasNext()) {
			// iterate through csv
			ImageHolder.add(ImageLoader.load(in.nextLine()));
		}

		in.close(); // close resource stream
	}

}
