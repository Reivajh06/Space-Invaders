package reivajh06.spaceinvaders.scenes;

import naitsirc98.blue.Window;
import reivajh06.spaceinvaders.Renderable;
import reivajh06.spaceinvaders.SpaceInvaders;

public abstract class Scene implements Renderable {

	protected final SpaceInvaders game;

	public Scene(SpaceInvaders game) {
		this.game = game;
	}

	public Window window() {
		return game.window();
	}

	public SpaceInvaders game() {
		return game;
	}

	public abstract void update();
}
