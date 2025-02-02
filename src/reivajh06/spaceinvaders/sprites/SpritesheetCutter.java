package reivajh06.spaceinvaders.sprites;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpritesheetCutter {

	public static List<BufferedImage> cut(BufferedImage normalisedSheet, int offset, int width, int height) throws IOException {
		List<BufferedImage> croppedSprites = new ArrayList<>();

		int rows = normalisedSheet.getHeight() / height;
		int columns = normalisedSheet.getWidth() / width;

		for(int row = 0; row < rows; row++) {
			for(int column = 0; column < columns; column++) {
				croppedSprites.add(normalisedSheet.getSubimage(column * width + offset, row * height + offset, width, height));
			}
		}

		return croppedSprites;
	}
}
