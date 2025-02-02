package reivajh06.spaceinvaders.sprites;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Spritesheet {

	private final List<BufferedImage> images;

	public Spritesheet(List<BufferedImage> images) {
		this.images = images;
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
}
