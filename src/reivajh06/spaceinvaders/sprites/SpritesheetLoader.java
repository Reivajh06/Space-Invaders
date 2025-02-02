package reivajh06.spaceinvaders.sprites;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpritesheetLoader {

	public static BufferedImage load(String path) throws IOException {
		return ImageIO.read(new File(path));
	}
}
