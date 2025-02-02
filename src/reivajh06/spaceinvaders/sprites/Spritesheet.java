package reivajh06.spaceinvaders.sprites;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Spritesheet {

	private final List<BufferedImage> sprites;
	private final List<BufferedImage> alienSprites;
	private final BufferedImage turretSprite;
	private final BufferedImage alienBeamSprite;
	private final List<BufferedImage> spritesWhenDestroyed;

	public Spritesheet(List<BufferedImage> sprites) {
		this.sprites = sprites;
		turretSprite = sprites.get(21);
		alienSprites = sprites.subList(0, 21);
		alienBeamSprite = sprites.get(23);
		spritesWhenDestroyed = new ArrayList<>(List.of(sprites.get(22), sprites.get(24)));
	}

	public List<BufferedImage> sprites() {
		return sprites;
	}

	public List<BufferedImage> getAlienSprites() {
		return alienSprites;
	}

	public BufferedImage getTurretSprite() {
		return turretSprite;
	}

	public BufferedImage getAlienBeamSprite() {
		return alienBeamSprite;
	}

	public List<BufferedImage> getSpritesWhenDestroyed() {
		return spritesWhenDestroyed;
	}

	public void viewSprites() throws IOException {
		for(BufferedImage image : sprites) {
			ImageIO.write(image, "png", new File("sprite" + sprites.indexOf(image) + ".png"));
		}
	}
}
