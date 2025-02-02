package reivajh06.spaceinvaders;

import reivajh06.spaceinvaders.entities.Turret;
import reivajh06.spaceinvaders.managers.AliensManager;
import reivajh06.spaceinvaders.managers.BeamsManager;

import java.awt.*;

public class LevelScene extends Scene {

	private BeamsManager beamsManager = new BeamsManager();
	private AliensManager aliensManager = new AliensManager(20,3, 0, 100, 30, 30, 30, Color.WHITE);
	private Player player = new Player();

	public BeamsManager beams() {
		return beamsManager;
	}

	public LevelScene(SpaceInvaders game) {
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
}

