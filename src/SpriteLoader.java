import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteLoader {

	private final BufferedImage spritesheet;

	public SpriteLoader(String sheetPath) throws IOException {
		this.spritesheet = ImageIO.read(new File(sheetPath));
	}

	public void prepareSprites(BufferedImage spritesheet) throws IOException {
		for(int x = 0; x < spritesheet.getWidth(); x++) {
			for(int y  = 0; y < spritesheet.getHeight(); y++) {
				int color = spritesheet.getRGB(x, y);

				if(color == 0xff000000) {
					spritesheet.setRGB(x, y, 0xffffffff);
				} else if(color != 0) {
					spritesheet.setRGB(x, y, 0);
				}
			}
		}
		ImageIO.write(spritesheet, "png", new File("modifiedSpriteSheet.png"));
	}
}
