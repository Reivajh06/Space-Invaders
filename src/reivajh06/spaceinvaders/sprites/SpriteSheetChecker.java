package reivajh06.spaceinvaders.sprites;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class SpriteSheetChecker {

	public static List<BufferedImage> check(List<BufferedImage> sprites) {
		List<BufferedImage> checkedSprites = new ArrayList<>();

		for(BufferedImage sprite : sprites) {
			if(!isEmptySprite(sprite)) checkedSprites.add(sprite);
		}
		return checkedSprites;
	}

	public static boolean isEmptySprite(BufferedImage sprite) {
		for(int x = 0; x < sprite.getWidth(); x++) {
			for(int y = 0; y < sprite.getHeight(); y++) {
				if(sprite.getRGB(x, y) != 0) return false;
			}
		}
		return true;
	}
}
