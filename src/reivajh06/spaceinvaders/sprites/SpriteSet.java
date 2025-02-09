package reivajh06.spaceinvaders.sprites;

import reivajh06.spaceinvaders.entities.Entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SpriteSet {

	private final List<BufferedImage> images;
	private final BufferedImage spriteWhenDestroyed;
	private int nextSprite = 0;

	public SpriteSet(List<BufferedImage> images) {
		if (images.isEmpty()) {
			System.out.println("Collection empty!!");
		} else {
			System.out.println("Collection not empty");
		}
		this.spriteWhenDestroyed = images.getLast();
		this.images = images;
	}

	public BufferedImage sprite(int i) {
		return images.get(i);
	}

	public BufferedImage nextSprite(Entity entity) {
		if (entity.isDestroyed()) {
			return spriteWhenDestroyed;
		}

		switch (images.size()) {
			case 1, 2:
				nextSprite = 0;
				break;
			case 3:
				if(nextSprite == 0) {
					nextSprite = 1;
				} else {
					nextSprite = 0;
				}
		}
		return images.get(nextSprite);
	}

	public void showSprite(int index) throws IOException {
		ImageIO.write(images.get(index), "png", new File("sprite" + ".png"));
	}

	public int size() {
		return images.size();
	}
}

