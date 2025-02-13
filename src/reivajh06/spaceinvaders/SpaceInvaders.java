package reivajh06.spaceinvaders;

import naitsirc98.blue.Game;
import reivajh06.spaceinvaders.scenes.LevelScene;
import reivajh06.spaceinvaders.scenes.Scene;
import reivajh06.spaceinvaders.sprites.Spritesheet;
import reivajh06.spaceinvaders.sprites.SpritesheetFactory;

import java.awt.*;
import java.io.IOException;

public class SpaceInvaders extends Game {

	private String sheetPath;
	private Spritesheet spritesheet;
	private LevelScene scene;

	public SpaceInvaders(String sheetPath) throws IOException {
		this.sheetPath = sheetPath;
		spritesheet = SpritesheetFactory.create(sheetPath);
		scene = new LevelScene(this, spritesheet);
	}

	@Override
	protected String title() {
		return "Space Invaders";
	}

	@Override
	protected void onStart() {
		/*try {
			spritesheet = SpritesheetFactory.create(sheetPath);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		*/

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
