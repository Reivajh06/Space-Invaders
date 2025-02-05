package reivajh06.spaceinvaders;

import reivajh06.spaceinvaders.entities.Turret;
import reivajh06.spaceinvaders.managers.AliensManager;
import reivajh06.spaceinvaders.managers.BeamsManager;
import reivajh06.spaceinvaders.sprites.Spritesheet;
import reivajh06.spaceinvaders.sprites.SpritesheetFactory;

import java.awt.*;
import java.io.IOException;

public class LevelScene extends Scene {

	private BeamsManager beamsManager = new BeamsManager();
	private AliensManager aliensManager = new AliensManager(3, 0, 100, 30, 30, 30, Color.WHITE);
	private Player player = new Player();
	private Spritesheet sprites = SpritesheetFactory.create("C:/Users/reiva/Desktop/dev/Space-Invaders/resources/modifiedSpriteSheet.png");

	public BeamsManager beams() {
		return beamsManager;
	}

	public LevelScene(SpaceInvaders game) throws IOException {
		super(game);
	}

	@Override
	public void render(Graphics2D graphics) {
		if (!beamsManager.isEmpty()) beamsManager.render(graphics);
		aliensManager.render(graphics);
		player.turret().render(graphics);
	}

	@Override
	public void update() {
		aliensManager.update(this);
		player.turret().update(this);
		beamsManager.update(this);
	}

	public AliensManager aliensManager() {
		return aliensManager;
	}

	public BeamsManager beamsManager() {
		return beamsManager;
	}

	public Turret turret() {
		return player.turret();
	}

	public Spritesheet sprites() {
		return sprites;
	}

	public LevelScene sprites(Spritesheet sprites) {
		this.sprites = sprites;
		return this;
	}
}

