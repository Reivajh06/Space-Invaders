package reivajh06.spaceinvaders;

import naitsirc98.blue.Window;

public abstract class Scene implements Renderable{

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
