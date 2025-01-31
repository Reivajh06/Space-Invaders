package reivajh06.spaceinvaders;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlienRow implements Renderable, Iterable<Alien> {

	private List<Alien> aliens = new ArrayList<>();
	private int separation = 50;

	public AlienRow(int rowBeginning, int rowY, int aliensWidth, int aliensHeight, int aliensSpeed, Color aliensColor) {
		this(10, rowBeginning, rowY, aliensWidth, aliensHeight, aliensSpeed, aliensColor);
	}

	public AlienRow(int aliensInRow, int rowBeginning, int rowY, int aliensWidth, int aliensHeight, int aliensSpeed, Color aliensColor) {
		if(aliensInRow == 0) {
			throw new RuntimeException("An aliensRow must have at least one Alien!!");
		} else {
			int alienPosition = 0;

			for(int i = 0; i < aliensInRow; i++) {
				aliens.add(new Alien(rowBeginning + separation * alienPosition, rowY, aliensWidth, aliensHeight, aliensSpeed, aliensColor));
				alienPosition++;
			}
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
				iterator.remove();
			} else {
				alien.update(scene);
			}
		}

		if(aliens.isEmpty()) {
			return;
		}

		if(aliens.getFirst().checkBorders(scene) || aliens.getLast().checkBorders(scene)) {
			Alien firstAlien = aliens.getFirst();
			Alien lastAlien = aliens.getLast();

			firstAlien.setPosition(firstAlien.clamp(firstAlien.x(), 0, scene.window().contentWidth()), firstAlien.y());
			lastAlien.setPosition(lastAlien.clamp(lastAlien.x(), 0, scene.window().contentWidth()), lastAlien.y());
			descend();
		}
	}

	public void descend() {
		for(Alien alien : aliens) {
			alien.changeDirection();
			alien.framesStill = 60;
			alien.setPosition(alien.x(), alien.y() + alien.height() + 30);
		}
	}

	public boolean isEmpty() {
		return this.aliens.isEmpty();
	}

	public void render(Graphics2D graphics) {
		for(Alien alien : aliens) {
			alien.render(graphics);
		}
	}
}
