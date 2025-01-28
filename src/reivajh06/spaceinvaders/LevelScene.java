package reivajh06.spaceinvaders;

import java.awt.*;

public class LevelScene extends Scene {

	private BeamsManager beamsManager = new BeamsManager();
	private AliensManager aliensManager = new AliensManager(2, 20, 100, 30, 30, 50, Color.WHITE);
	private Turret turret = new Turret(200, 600, 30, 30, 10, Color.GREEN);

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
		turret.render(graphics);
	}

	@Override
	public void update() {
		aliensManager.update(this);
		for (AlienRow alienRow : aliensManager) {
			if (!beams().isEmpty()) beams().update(this, alienRow);
		}
		turret.update(this);
	}
}

