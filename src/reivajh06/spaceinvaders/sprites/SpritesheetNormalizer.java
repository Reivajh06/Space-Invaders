package reivajh06.spaceinvaders.sprites;

import java.awt.image.BufferedImage;

public class SpritesheetNormalizer {

	public static BufferedImage normalize(BufferedImage sheet) {
		for (int x = 0; x < sheet.getWidth(); x++) {
			for (int y = 0; y < sheet.getHeight(); y++) {
				int color = sheet.getRGB(x, y);

				if (color == 0xff000000) {
					sheet.setRGB(x, y, 0xffffffff);
				}
			}
		}
		return sheet;
	}
}
