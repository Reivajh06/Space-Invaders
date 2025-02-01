package reivajh06.spaceinvaders.managers;

import reivajh06.spaceinvaders.entities.Entity;

import java.awt.image.BufferedImage;
import java.util.List;

public class SpriteManager {

	private final List<BufferedImage> images;
	private final BufferedImage spriteWhenDestroyed;
	private int currentSprite = 0;
	private boolean renderIfDestroyed = false;
	private int framesPerImage = 30;

	public SpriteManager(List<BufferedImage> images, BufferedImage spriteWhenDestroyed) {
		this.images = images;
		this.spriteWhenDestroyed = spriteWhenDestroyed;
	}

	public void update(Entity entity) {
		if(entity.isDestroyed()) {
			renderIfDestroyed = true;
		} else {
			if(framesPerImage == 0) {
				currentSprite++;
				currentSprite %= images.size();
				framesPerImage = 30;
			} else {
				framesPerImage--;
			}
		}
	}

	public BufferedImage currentSprite() {
		return images.get(currentSprite);
	}

	public int currentSpriteIndex() {
		return currentSprite;
	}
}
