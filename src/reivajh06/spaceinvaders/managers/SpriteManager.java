package reivajh06.spaceinvaders.managers;

import reivajh06.spaceinvaders.entities.Entity;

import java.awt.image.BufferedImage;
import java.util.List;

public class SpriteManager {

	private final List<BufferedImage> images;
	private final BufferedImage spriteWhenDestroyed;
	private int nextSprite = 0;
	private int framesPerImage = 30;

	public SpriteManager(List<BufferedImage> images) {
		this.spriteWhenDestroyed = images.getLast();
		images.removeLast();
		this.images = images;
	}

	public BufferedImage nextSprite(Entity entity) {
		if(entity.isDestroyed()) {
			return spriteWhenDestroyed;
		}

		if(framesPerImage != 0) {
			framesPerImage--;
			return images.get(nextSprite);
		}
		framesPerImage = 30;
		return images.get(nextSprite % images.size());
		}
	}

