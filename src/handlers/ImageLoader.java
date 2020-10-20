package handlers;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Loads assets from a line of a CSV, which currently contains an asset path and
 * immutability value.
 * 
 * @author Sam Brenner
 *
 */

public class ImageLoader {

	/**
	 * Loads an {@link ImageAsset} from a line of a CSV file
	 * 
	 * @param csvLine {@link String} of a line from a CSV file
	 * @return {@link ImageAsset} found from the csvLine
	 * @throws IOException if {@link File} from CSV cannot be found
	 */
	public static ImageAsset load(String csvLine) throws IOException {
		return loadImageAsset(csvLine);
	}

	/**
	 * Handles a CSV line to construct an {@link ImageAsset} object
	 * 
	 * @param csvLine {@link String} of a line from a CSV file
	 * @return {@link ImageAsset} found from the csvLine
	 * @throws IOException if {@link File} from CSV cannot be found
	 */
	private static ImageAsset loadImageAsset(String csvLine) throws IOException {
		String[] csv = csvLine.split(", "); // construct array from values
		// form ImageAsset objecct from image and immutability value
		return new ImageAsset(ImageIO.read(new File(csv[0])), Boolean.parseBoolean(csv[1]));
	}

}
