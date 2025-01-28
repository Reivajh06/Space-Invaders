package reivajh06.spaceinvaders;

import java.awt.*;
import java.util.Iterator;

public class Beam extends Entity{

	protected int direction;

	public Beam(int x, int y, int direction, int speed) {
		super(x, y, 3, 20, speed, Color.RED);
		this.direction = direction;
	}

	public Beam(int x, int y, int direction, Color color) {
		super(x, y, 3, 20, 5, color);
		this.direction = direction;
	}

	public void checkCollision(LevelScene scene, AlienRow aliens) {
		for(Alien alien : aliens) {
			checkAlien(alien);
		}
		checkHorizontalBorders(scene.window());
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
		if(x() >= alien.x() && x() <= alien.x() + alien.width()) {
			if(y() == alien.y() + alien.height()) {
				alien.destroy();
				this.destroy();
			}
		}
	}

	@Override
	public void render(Graphics2D graphics) {
		graphics.setColor(Color.RED);
		graphics.fillRoundRect(x(), y(), 3, 20, 4, 4);
	}

	public void update(LevelScene scene, AlienRow aliens) {
		checkCollision(scene, aliens);
		setPosition(x(), y() + speed() * direction);
	}
}
