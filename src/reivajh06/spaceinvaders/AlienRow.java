package reivajh06.spaceinvaders;

import reivajh06.spaceinvaders.entities.Alien;
import reivajh06.spaceinvaders.sprites.SpriteSet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlienRow implements Renderable, Iterable<Alien> {

	private List<Alien> aliens = new ArrayList<>();
	private int separation = 50;
	private int aliensDestroyed = 0;
	private final List<BufferedImage> sprites;

	public AlienRow(int rowBeginning, int rowY, int aliensWidth, int aliensHeight, int aliensSpeed, Color aliensColor, List<BufferedImage> sprites) {
		this(10, rowBeginning, rowY, aliensWidth, aliensHeight, aliensSpeed, aliensColor, sprites);
	}

	public AlienRow(int aliensInRow, int rowBeginning, int rowY, int aliensWidth, int aliensHeight, int aliensSpeed, Color aliensColor, List<BufferedImage> sprites) {
		if(aliensInRow == 0) {
			throw new RuntimeException("An aliensRow must have at least one Alien!!");
		} else {
			int alienPosition = 0;

			for(int i = 0; i < aliensInRow; i++) {
				aliens.add(new Alien(rowBeginning + separation * alienPosition, rowY, aliensWidth, aliensHeight, aliensSpeed, aliensColor, new SpriteSet(sprites)));
				alienPosition++;
			}

			this.sprites = sprites;
		}
	}

	public List<Alien> aliens() {
		return this.aliens;
	}

	@Override
	public Iterator<Alien> iterator() {
		return aliens.iterator();
	}

	public void update(LevelScene scene) {
		Iterator<Alien> iterator = iterator();

		while(iterator.hasNext()) {
			Alien alien = iterator.next();

			if(alien.isDestroyed()) {
				aliensDestroyed += 1;
				iterator.remove();
			} else {
				alien.update(scene);
			}
		}

		if(aliens.isEmpty()) {
			return;
		}

		if(aliens.getFirst().checkBorders(scene) || aliens.getLast().checkBorders(scene)) {
			int offset;

			if(getDirection() == 1) {
				offset = scene.window().contentWidth() - aliens.getLast().x() + aliens.getLast().width();
			} else {
				offset = aliens.getFirst().x();
			}
			descend(offset);
		}
	}

	public void descend(int offset) {
		for(Alien alien : aliens) {
			alien.changeDirection();
			alien.setPosition(alien.x() - offset + alien.getDirection(), alien.y() + alien.height() + 30);
		}
	}

	public boolean isEmpty() {
		return this.aliens.isEmpty();
	}

	public int getDirection() {
		return !aliens.isEmpty() ? aliens.getFirst().getDirection() : 0;
	}

	public void render(Graphics2D graphics) {
		for(Alien alien : aliens) {
			alien.render(graphics);
		}
	}
}
