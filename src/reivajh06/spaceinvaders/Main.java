package reivajh06.spaceinvaders;

import naitsirc98.blue.Game;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Game game = new SpaceInvaders("C:/Users/reiva/Desktop/dev/Space-Invaders/resources/modifiedSpriteSheet.png");
		game.launch();
	}
}
