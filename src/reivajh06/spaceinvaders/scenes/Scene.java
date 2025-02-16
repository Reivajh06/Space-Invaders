package reivajh06.spaceinvaders.scenes;

import naitsirc98.blue.Window;
import reivajh06.spaceinvaders.Renderable;
import reivajh06.spaceinvaders.SpaceInvaders;
import reivajh06.spaceinvaders.sprites.Spritesheet;

import java.io.IOException;

public abstract class Scene implements Renderable {

	protected final SpaceInvaders game;
	protected Spritesheet spritesheet;

	public Scene(SpaceInvaders game) {
		this.game = game;
	}

	public Window window() {
		return game.window();
	}

	public SpaceInvaders game() {
		return game;
	}

	public abstract void update() throws IOException;
}
