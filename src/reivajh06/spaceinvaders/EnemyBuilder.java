package reivajh06.spaceinvaders;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class EnemyBuilder {
	
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	private List<BufferedImage> sprites;

	public Color color() {
		return color;
	}

	public EnemyBuilder color(Color color) {
		this.color = color;
		return this;
	}

	public int x() {
		return x;
	}

	public EnemyBuilder x(int x) {
		this.x = x;
		return this;
	}

	public int y() {
		return y;
	}

	public EnemyBuilder y(int y) {
		this.y = y;
		return this;
	}

	public int width() {
		return width;
	}

	public EnemyBuilder width(int width) {
		this.width = width;
		return this;
	}

	public int height() {
		return height;
	}

	public EnemyBuilder height(int height) {
		this.height = height;
		return this;
	}

	public List<BufferedImage> sprites() {
		return sprites;
	}

	public EnemyBuilder sprites(List<BufferedImage> sprites) {
		this.sprites = sprites;
		return this;
	}

	public Enemy build() {
		Enemy enemy = new Enemy(x, y, width, height);
		if(sprites == null) throw new NullPointerException("Sprites cannot be null");
		enemy.color(color);
		enemy.sprites(sprites);

		return enemy;
	}
}
