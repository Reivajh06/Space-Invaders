package reivajh06.spaceinvaders.sprites;

import java.awt.image.BufferedImage;
import java.util.*;

public class SpritePackager {

	public static Map<String, List<BufferedImage>> packageSprites(List<BufferedImage> spritesToPackage) {
		BufferedImage spriteWhenDestroyed = spritesToPackage.getLast();
		List<BufferedImage> alienSprites = spritesToPackage.subList(0, 20);

		Map<String, List<BufferedImage>> spritesPackaged = packageAlienSprites(alienSprites, spriteWhenDestroyed);

		List<BufferedImage> specialAlien = spritesToPackage.subList(20, 21);
		spritesPackaged.put("specialAlien", specialAlien);

		List<BufferedImage> turretSprites = spritesToPackage.subList(21, 23);
		spritesPackaged.put("turret", turretSprites);

		List<BufferedImage> alienBeamSprites = spritesToPackage.subList(23, spritesToPackage.size());
		spritesPackaged.put("alienBeam", alienBeamSprites);

		return spritesPackaged;
	}

	private static Map<String, List<BufferedImage>> packageAlienSprites(List<BufferedImage> alienSprites, BufferedImage spriteWhenDestroyed) {
		Map<String, List<BufferedImage>> packagedAlienSprites = new HashMap<>();

		int alienType = 1;
		int i = 0;

		while(i < alienSprites.size()) {
			packagedAlienSprites.put("alien" + alienType, new ArrayList<>(List.of(alienSprites.get(i),
					alienSprites.get(i + 1),
					spriteWhenDestroyed)));
			i += 2;
			alienType++;
		}
		return packagedAlienSprites;
	}
}
