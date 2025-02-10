package reivajh06.spaceinvaders.entities;

import reivajh06.spaceinvaders.AlienRow;
import reivajh06.spaceinvaders.scenes.LevelScene;
import reivajh06.spaceinvaders.sprites.SpriteSet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Beam extends Entity {

	private static final int DEFAULT_WIDTH = 65;
	private static final int DEFAULT_HEIGHT = 65;

	protected int direction;
	protected BufferedImage spriteDisplayed;

	public Beam(int x, int y, int direction, int speed, SpriteSet spriteSet) {
		super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, Color.RED, speed, spriteSet);
		this.direction = direction;
	}

	public Beam(int x, int y, int direction, Color color) {
		super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, color, 5, null);
		this.direction = direction;
	}

	public void checkCollision(LevelScene scene) {
		for(AlienRow aliens : scene.aliensManager()) {
			checkAlienRow(aliens);
		}
		checkHorizontalBorders(scene.window());
		checkTurret(scene.turret());
	}

	private void checkAlienRow(AlienRow aliens) {
		for(Alien alien : aliens) {
			checkAlien(alien);
		}
	}

	public void checkHorizontalBorders(Window window) {
		if(checkUpperBorder(window) || checkLowerBorder(window)) {
			this.destroy();
		}
	}

	public boolean checkUpperBorder(Window window) {
		return this.y() < 0;
	}

	public boolean checkLowerBorder(Window window) {
		return this.y() + this.height() >= window.getHeight();
	}

	public void checkAlien(Alien alien) {
		if(isAlienBeam()) return;

		if(x() >= alien.x() && x() <= alien.x() + alien.width()) {
			if(y() <= alien.y() + alien.height()) {
				alien.destroy();
				this.destroy();
			}
		}
	}

	public void checkTurret(Turret turret) {
		if(!isAlienBeam()) return;

		if(x() + height() >= turret.x() && x() < turret.x() + turret.width()) {
			if(y() + height() >= turret.y()) {
				turret.destroy();
				this.destroy();
			}
		}
	}

	private boolean isAlienBeam() {
		return direction == 1;
	}

	@Override
	public void render(Graphics2D graphics) {
		if(isAlienBeam()) {
			graphics.drawImage(sprites.sprite(0), x(), y(), width(), height(), null);
		} else{
			graphics.setColor(Color.RED);
			graphics.fillRoundRect(x(), y(), 3, 20, 4, 4);
		}
	}

	public void update(LevelScene scene) {
		if(isAlienBeam()) {
			spriteDisplayed = sprites.nextSprite(this);
		}
		setPosition(x(), y() + speed() * direction);
		checkCollision(scene);
	}
}
