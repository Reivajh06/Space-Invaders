package reivajh06.spaceinvaders.scenes;

import naitsirc98.blue.input.Key;
import naitsirc98.blue.input.Keyboard;
import reivajh06.spaceinvaders.SpaceInvaders;
import reivajh06.spaceinvaders.sprites.Spritesheet;

import java.awt.*;
import java.io.IOException;

public class Menu extends Scene{
	public Menu(SpaceInvaders game) {
		super(game);
	}

	@Override
	public void update() throws IOException {
		if(Keyboard.isKeyPressed(Key.ENTER)) {
			game.setScene(new LevelScene(game, game.getSpritesheet()));
		}
	}

	@Override
	public void render(Graphics2D graphics) {
		renderTitle(graphics);
		renderSuggestions(graphics);

	}

	private void renderTitle(Graphics2D graphics) {
		graphics.setColor(Color.WHITE);
		graphics.setFont(new Font("Monospaced", Font.BOLD, 60));
		graphics.drawString("SPACE INVADERS", this.game.window().contentWidth() / 2 - 250, this.game.window().contentHeight() / 2 - 200);
	}

	private void renderSuggestions(Graphics2D graphics) {
		graphics.setColor(Color.WHITE);
		graphics.setFont(new Font("Monospaced", Font.BOLD, 42));
		graphics.drawString("PRESS ENTER TO START PLAYING!!!", this.game.window().contentWidth() / 2 - 400, this.game.window().contentHeight()/2 + 200);
	}
}
