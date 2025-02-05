package reivajh06.spaceinvaders.sprites;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Spritesheet {

	private final List<BufferedImage> images;
	private final Map<String, List<BufferedImage>> spritesPackaged;

	public Spritesheet(List<BufferedImage> images, Map<String, List<BufferedImage>> spritesPackaged) {
		this.images = images;
		this.spritesPackaged = spritesPackaged;
	}

	public List<BufferedImage> images() {
		return images;
	}

	public void viewSprites() throws IOException {
		int x = 0;
		for(BufferedImage image : images) {
			ImageIO.write(image, "png", new File("sprite" + x++ + ".png"));
		}
	}

	public List<BufferedImage> getPackage(String key) {
		return spritesPackaged.get(key);
	}
}
