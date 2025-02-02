package reivajh06.spaceinvaders.sprites;

import reivajh06.spaceinvaders.SpriteLoader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpritesheetCrazyVersion {

	protected BufferedImage spritesheet;
	protected List<BufferedImage> sprites = new ArrayList<>();

	public SpritesheetCrazyVersion(String sheetPath, SpriteLoader spriteLoader, int width, int height, int offset) throws IOException {
		spriteLoader.load();

		int rows = spritesheet.getHeight() / height;
		int columns = spritesheet.getWidth() / width;

		for(int row = 0; row < rows; row++) {
			for(int column = 0; column < columns; column++) {
				BufferedImage image = getSubImage(column, row, offset, width, height);
				if(!isEmptySprite(image)) {
					sprites.add(image);
					ImageIO.write(image, "png", new File("sprite" + row + column + ".png"));
				}
			}
		}
	}

	public BufferedImage getSubImage(int x, int y, int offset, int width, int height) {
		return spritesheet.getSubimage(x * width + offset, y * height + offset, width, height);
	}

	public boolean isEmptySprite(BufferedImage sprite) {
		for(int x = 0; x < sprite.getWidth(); x++) {
			for(int y = 0; y < sprite.getHeight(); y++) {
				if(sprite.getRGB(x, y) != 0) return false;
			}
		}
		return true;
	}

	public List<BufferedImage> getSprites() {
		return this.sprites;
	}

	public static void main(String[] args) throws IOException {
		String sheetPath = "C:\\Users\\ReivajH06\\Desktop\\dev\\SpaceInvaders\\resources\\spritesheet.png";
		new SpritesheetCrazyVersion(sheetPath, new SpriteLoader(sheetPath), 110, 120, 1);
	}
}
