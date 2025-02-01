package reivajh06.spaceinvaders;

import reivajh06.spaceinvaders.entities.Turret;

import java.awt.*;

public class Player {

	private Turret turret = new Turret(200, 600, 30, 30, 10, Color.GREEN);
	private int score = 0;
	private boolean alive = true;
	private int aliensDestroyed = 0;
	private int destroyedCount = 0;
	private int beamsShot = 0;

	public Player() {
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
