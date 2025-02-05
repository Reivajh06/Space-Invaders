package reivajh06.spaceinvaders.sprites;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SpritesheetFactory {

	public static Spritesheet create(String sheetPath) throws IOException {
		BufferedImage spriteSheet = SpritesheetLoader.load(sheetPath);
		BufferedImage normalisedSheet = SpritesheetNormalizer.normalize(spriteSheet);
		List<BufferedImage> cutter = SpritesheetCutter.cut(normalisedSheet, 1, 110, 120);
		List<BufferedImage> checkedSprites = SpriteSheetChecker.check(cutter);
		return new Spritesheet(checkedSprites, SpritePackager.packageSprites(checkedSprites));
	}
}
