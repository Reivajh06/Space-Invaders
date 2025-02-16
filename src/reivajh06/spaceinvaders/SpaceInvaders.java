package reivajh06.spaceinvaders;

import naitsirc98.blue.Game;
import reivajh06.spaceinvaders.scenes.Menu;
import reivajh06.spaceinvaders.scenes.Scene;
import reivajh06.spaceinvaders.sprites.Spritesheet;
import reivajh06.spaceinvaders.sprites.SpritesheetFactory;

import java.awt.*;
import java.io.IOException;

public class SpaceInvaders extends Game {

	private String sheetPath;
	private Spritesheet spritesheet;
	private Scene scene;

	public SpaceInvaders(String sheetPath) throws IOException {
		this.sheetPath = sheetPath;
		spritesheet = SpritesheetFactory.create(sheetPath);
	}

	@Override
	protected String title() {
		return "Space Invaders";
	}

	@Override
	protected void onStart() {
		scene = new Menu(this);

	}

	@Override
	protected void onUpdate(float deltaTime) {
		try {
			scene.update();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void onRender(Graphics2D graphics) {
		graphics.clearRect(0,0, window.contentWidth(), window.contentHeight());
		scene.render(graphics);
	}

	@Override
	protected void onExit() {

	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Spritesheet getSpritesheet() {
		return this.spritesheet;
	}
}
