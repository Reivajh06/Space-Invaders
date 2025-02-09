package reivajh06.spaceinvaders;

import reivajh06.spaceinvaders.entities.Turret;
import reivajh06.spaceinvaders.sprites.SpriteSet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class Player {

	private int score = 0;
	private boolean alive = true;
	private int aliensDestroyed = 0;
	private int destroyedCount = 0;
	private int beamsShot = 0;
	private List<BufferedImage> sprites;
	private Turret turret;

	public Player() {
		this(null);
	}

	public Player(List<BufferedImage> sprites) {
		this.sprites = sprites;
		this.turret = new Turret(200, 600, 30, 30, 10, Color.GREEN, new SpriteSet(sprites));
	}

	public Turret turret() {
		return this.turret;
	}

	public int getScore() {
		return this.score;
	}

	public int getAliensDestroyed() {
		return this.aliensDestroyed;
	}

	public boolean isAlive() {
		return alive;
	}

	public int getDestroyedCount() {
		return this.destroyedCount;
	}

	public int getBeamsShot() {
		return this.beamsShot;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
