package reivajh06.spaceinvaders;

import naitsirc98.blue.Game;

import java.awt.*;

public class SpaceInvaders extends Game {

	private LevelScene scene = new LevelScene(this);

	@Override
	protected String title() {
		return "Space Invaders";
	}

	@Override
	protected void onStart() {

	}

	@Override
	protected void onUpdate(float deltaTime) {
		scene.update();
	}

	@Override
	protected void onRender(Graphics2D graphics) {
		graphics.clearRect(0,0, window.contentWidth(), window.contentHeight());
		scene.render(graphics);
	}

	@Override
	protected void onExit() {

	}
}
