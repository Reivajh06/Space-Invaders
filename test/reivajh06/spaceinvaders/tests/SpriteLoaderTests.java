package reivajh06.spaceinvaders.tests;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteLoaderTests {

	public static void main(String[] args) throws IOException {

		BufferedImage spritesheet = ImageIO.read(new File("C:\\Users\\ReivajH06\\Desktop\\dev\\SpaceInvaders\\resources\\alienSprites.png"));
		prepareSprites(spritesheet);

		int y = 0;
		int x = 1;
		int offset = 1;
		int width = 110;
		int height = 120;

		BufferedImage subImage = spritesheet.getSubimage(x * width + offset, y * height + offset, width, height);

		ImageIO.write(spritesheet, "png", new File("modifiedSpriteSheet.png"));
		ImageIO.write(subImage, "png", new File("sprite.png"));

		System.out.println(Integer.toHexString(Color.red.getRGB()));

	}

	public static void prepareSprites(BufferedImage spritesheet) {
		for(int x = 0; x < spritesheet.getWidth(); x++) {
			for(int y  = 0; y < spritesheet.getHeight(); y++) {
				int color = spritesheet.getRGB(x, y);
//0xffffffff
				if(color == 0xff000000) {
					spritesheet.setRGB(x, y, 0xffff0000);
				} else if(color != 0) {
					spritesheet.setRGB(x, y, 0);
				}
			}
		}
	}

	public static void subImage() {

	}
}
