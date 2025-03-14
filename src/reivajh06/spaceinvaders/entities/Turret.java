package reivajh06.spaceinvaders.entities;

import naitsirc98.blue.input.Key;
import naitsirc98.blue.input.Keyboard;
import naitsirc98.blue.input.Mouse;
import naitsirc98.blue.input.MouseButton;
import reivajh06.spaceinvaders.managers.BeamsManager;
import reivajh06.spaceinvaders.scenes.LevelScene;
import reivajh06.spaceinvaders.sprites.SpriteSet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Turret extends Entity {

	private int cooldown = 30;
	private BufferedImage spriteDisplayed;

	public Turret(int x, int y, int width, int height, int speed, Color color, SpriteSet sprites) {
		super(x, y, width, height, color, speed, sprites);
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
		if(destroyed) {
			spriteDisplayed = sprites.nextSprite(this);
			return;
		}

		spriteDisplayed = sprites.nextSprite(this);
		shoot(scene.beams());
		move();
		setPosition(clamp(x(), 0, scene.window().contentWidth()),y());
	}

	@Override
	public void render(Graphics2D graphics) {
		if(sprites != null) {
			graphics.drawImage(spriteDisplayed, x(), y(), width(), height(), null);
		} else {
			graphics.setColor(color);
			graphics.fillRoundRect(x(), y(), width, height, 4, 4);
		}
	}

	public void shoot(BeamsManager beams) {
		if(cooldown == 0) {
			if(Mouse.isPressed(MouseButton.PRIMARY) || Keyboard.isKeyPressed(Key.SPACE)) {
				beams.addBeam(new Beam(x() + width() / 2, y() + 2, -1, Color.GREEN));
				cooldown = 30;
			}
		} else {
			cooldown--;
		}
	}
}
