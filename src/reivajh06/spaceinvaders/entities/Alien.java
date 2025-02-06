package reivajh06.spaceinvaders.entities;

import reivajh06.spaceinvaders.managers.BeamsManager;
import reivajh06.spaceinvaders.LevelScene;
import reivajh06.spaceinvaders.sprites.SpriteSet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Alien extends Entity {

	protected final int cooldown;
	protected int cooldownCounter;
	protected int framesStill = 60;
	protected int direction = 1;
	protected BufferedImage spriteDisplayed;

	public Alien(int x, int y, int width, int height, int speed, Color color, SpriteSet spriteSet) {
		super(x, y, width, height, color, speed, spriteSet);
		Random random = new Random();
		cooldown = random.nextInt(0, 1000) + 100;
		cooldownCounter = random.nextInt(cooldown) + 1000;
	}

	public int getDirection() {
		return direction;
	}

	public boolean checkBorders(LevelScene scene) {
		boolean leftCollision = checkLeftBorder(scene);
		boolean rightCollision = checkRightBorder(scene);

		return leftCollision || rightCollision;

	}

	public boolean checkLeftBorder(LevelScene scene) {
		return x() < 0;
	}

	public void changeDirection() {
		this.direction *= -1;
	}

	public boolean checkRightBorder(LevelScene scene) {
		int rightBorder = scene.window().contentWidth();

		return x() + width() > rightBorder;
	}

	@Override
	public void render(Graphics2D graphics) {
		if(sprites != null) {
			graphics.drawImage(spriteDisplayed, x(), y(), width(), height(), null);

		} else {
			graphics.setColor(color());
			graphics.fillRoundRect(x(), y(), width(), height(), 4, 4);
		}
	}

	public void update(LevelScene scene) {
		if(destroyed) return;

		checkBorders(scene);

		if (framesStill == 0) {
			spriteDisplayed = sprites.nextSprite(this);
			move();
			framesStill = 60;
		} else {
			framesStill -= 1;
		}

		shoot(scene.beams());
	}

	private void move() {
		setPosition(x() + speed * direction, y());
	}

	public void shoot(BeamsManager beamsManager) {
		cooldownCounter--;

		if(cooldownCounter <= 0) {
			beamsManager.addBeam(new Beam(x() + width() / 2 + 10, y() + height() + 1, 1, Color.RED));
			cooldownCounter = cooldown;
		}
	}

}
