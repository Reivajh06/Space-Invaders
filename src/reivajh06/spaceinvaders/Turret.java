package reivajh06.spaceinvaders;

import naitsirc98.blue.input.Key;
import naitsirc98.blue.input.Keyboard;

import java.awt.*;

public class Turret extends Entity {

	public Turret(int x, int y, int width, int height, int speed, Color color) {
		super(x, y, width, height, speed, color);

		this.speed = speed;
	}

	public void move() {
		moveLeft();
		moveRight();
	}

	public void moveLeft() {
		if(Keyboard.isKeyPressed(Key.D) || Keyboard.isKeyPressed(Key.RIGHT)) setPosition(x() + speed(), y());
	}

	public void moveRight() {
		if(Keyboard.isKeyPressed(Key.A) || Keyboard.isKeyPressed(Key.LEFT)) setPosition(x() + speed() * -1, y());
	}

	public void update(LevelScene scene) {
		borderCollision(scene);
		move();

	}

	@Override
	public void render(Graphics2D graphics) {
		if(!isDestroyed()) {
			graphics.setColor(color);
			graphics.fillRoundRect(x(), y(), width, height, 4, 4);
		}
	}
}
