package reivajh06.spaceinvaders;

import reivajh06.spaceinvaders.sprites.SpritePackager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Enemy {

	private int x;
	private int y;
	private final int width;
	private final int height;
	private Color color;
	private List<BufferedImage> sprites;

	public Enemy(int x, int y, int width, int height, Color color, List<BufferedImage> sprites) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.sprites = sprites;
	}

	public Enemy(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public int x() {
		return x;
	}

	public Enemy x(int x) {
		this.x = x;
		return this;
	}

	public int y() {
		return y;
	}

	public Enemy y(int y) {
		this.y = y;
		return this;
	}

	public int width() {
		return width;
	}

	public int height() {
		return height;
	}

	public Color color() {
		return color;
	}

	public Enemy color(Color color) {
		this.color = color;
		return this;
	}

	public List<BufferedImage> sprites() {
		return sprites;
	}

	public Enemy sprites(List<BufferedImage> sprites) {
		this.sprites = sprites;
		return this;
	}

	public static void main(String[] args) {
		Enemy enemy = new Enemy(78, 45, 89, 120, Color.RED, new ArrayList<>());
		Enemy enemy2 = new EnemyBuilder()
				.x(78)
				.y(89)
				.width(45)
				.height(90)
				.color(Color.BLACK)
				.sprites(new ArrayList<>())
				.build();
	}
}
