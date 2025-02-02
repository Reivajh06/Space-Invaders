package reivajh06.spaceinvaders;

import naitsirc98.blue.Game;
import reivajh06.spaceinvaders.sprites.Spritesheet;
import reivajh06.spaceinvaders.sprites.SpritesheetFactory;

import java.awt.*;
import java.io.IOException;

public class SpaceInvaders extends Game {

	private LevelScene scene = new LevelScene(this);
	private Spritesheet spritesheet;


	public Spritesheet spritesheet() {
		return spritesheet;
	}

	@Override
	protected String title() {
		return "Space Invaders";
	}

	@Override
	protected void onStart() {
		try {
			spritesheet = SpritesheetFactory.create("C:\\Users\\ReivajH06\\Desktop\\dev\\SpaceInvaders\\resources\\modifiedSpriteSheet.png");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
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
