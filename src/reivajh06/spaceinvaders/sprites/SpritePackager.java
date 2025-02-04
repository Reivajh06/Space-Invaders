package reivajh06.spaceinvaders.sprites;

import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.*;

public class SpritePackager {

	public static Map<String, BufferedImage> entitySprites(List<BufferedImage> spritesToPackage) {
		Map<String, BufferedImage> spritesPackaged = new LinkedHashMap<>();

		BufferedImage spriteWhenDestroyed = spritesToPackage.getLast();
		List<BufferedImage> alienSprites = spritesToPackage.subList(0, 20);
		List<BufferedImage> specialAlien = spritesToPackage.subList(20, 21);
		List<BufferedImage> turretSprites = spritesToPackage.subList(21, 23);
		List<BufferedImage> alienBeamSprites = spritesToPackage.subList(23, spritesToPackage.size());

		return spritesPackaged;
	}

	private static List<List<BufferedImage>> packageAlienSprites(List<BufferedImage> alienSprites, BufferedImage spriteWhenDestroyed) {
		List<List<BufferedImage>> aliensPackaged = new ArrayList<>();

		for(int i = 0; i <= alienSprites.size() - 2; i++) {
			List<BufferedImage> alienPackaged = new ArrayList<>(List.of(
					alienSprites.get(i),
					alienSprites.get(i + 1),
					alienSprites.getLast()));
			aliensPackaged.add(alienPackaged);
		}
		return aliensPackaged;
	}
}
