package reivajh06.spaceinvaders.scenes;

import naitsirc98.blue.input.Key;
import naitsirc98.blue.input.Keyboard;
import reivajh06.spaceinvaders.SpaceInvaders;

import java.awt.*;
import java.io.IOException;

public class LoseScene extends Scene {

	public LoseScene(SpaceInvaders game) {
		super(game);
	}

	@Override
	public void update() throws IOException {
		if(Keyboard.isKeyPressed(Key.ENTER)) {
			game.setScene(new LevelScene(game, game.getSpritesheet()));
		} else if(Keyboard.isKeyPressed(Key.ESCAPE)) {
			game.setScene(new Menu(game));
		}
	}

	@Override
	public void render(Graphics2D graphics) {
		graphics.setColor(Color.RED);
		graphics.setFont(new Font("Monospaced", Font.BOLD, 60));
		graphics.drawString("You Lost", this.game.window().contentWidth() / 2 - 250, this.game.window().contentHeight() / 2 - 200);
	}

}
