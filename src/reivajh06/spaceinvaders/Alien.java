package reivajh06.spaceinvaders;

import java.awt.*;
import java.util.Random;

public class Alien extends Entity {

	protected final int cooldown;
	protected int cooldownCounter;
	protected int framesStill = 60;
	protected int direction = 1;

	public Alien(int x, int y, int width, int height, int speed, Color color) {
		super(x, y, width, height, speed, color);
		Random random = new Random();
		cooldown = random.nextInt(0, 1000) + 100;
		cooldownCounter = random.nextInt(cooldown) + 30;
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
		graphics.setColor(color());
		graphics.fillRoundRect(x(), y(), width(), height(), 4, 4);
	}

	public void update(LevelScene scene) {
		checkBorders(scene);

		if(framesStill == 0) {
			setPosition(x() + speed * direction, y());
			framesStill = 60;
		} else {
			framesStill -= 1;
		}

		shoot(scene.beams());
	}

	public void shoot(BeamsManager beamsManager) {
		cooldownCounter--;

		if(cooldownCounter <= 0) {
			beamsManager.addBeam(new Beam(x() + width() / 2 + 10, y() + height() + 1, 1, Color.RED));
			cooldownCounter = cooldown;
		}
	}

}
