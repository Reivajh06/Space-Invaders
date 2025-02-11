package reivajh06.spaceinvaders.sprites;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class SpritePainter {

	public static List<BufferedImage> paint(List<BufferedImage> sprites, Color color) {
		int colorRGB = color.getRGB();

		for(BufferedImage sprite : sprites) {
			for(int x = 0; x < sprite.getWidth(); x++) {
				for(int y = 0; y < sprite.getHeight(); y++) {
					int pixelColor = sprite.getRGB(x, y);

					if(pixelColor != 0) {
						sprite.setRGB(x, y, colorRGB);
					}
				}
			}
		}

		return sprites;
	}
}
