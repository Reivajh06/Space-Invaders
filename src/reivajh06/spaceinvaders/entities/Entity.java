package reivajh06.spaceinvaders.entities;

import reivajh06.spaceinvaders.Position;
import reivajh06.spaceinvaders.Renderable;
import reivajh06.spaceinvaders.managers.SpriteManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity implements Renderable {

	protected Position position;
	protected int width;
	protected int height;
	protected int speed;
	protected SpriteManager sprites = null;
	protected Color color;
	protected boolean destroyed = false;

	public Entity(int x, int y, int width, int height, int speed, Color color) {
		this.position = new Position(x, y);
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.color = color;
	}

	public Entity(Position position, int width, int height, Color color, int speed, SpriteManager sprites) {
		this(position.x(), position.y(), width, height, speed, color);
		this.sprites = sprites;
	}

	public int x() {
		return position.x();
	}

	public int y() {
		return position.y();
	}

	public int width() {
		return this.width;
	}

	public int height() {
		return this.height;
	}

	public int speed() {
		return this.speed;
	}

	public Color color() {
		return this.color;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setPosition(int x, int y) {
		this.position = new Position(x, y);
	}

	public void destroy() {
		destroyed = true;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int clamp(int value, int min, int max) {
		return Math.min(Math.max(value, min), max - width);
	}
}
