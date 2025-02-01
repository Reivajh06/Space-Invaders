package reivajh06.spaceinvaders.managers;

import reivajh06.spaceinvaders.AlienRow;
import reivajh06.spaceinvaders.LevelScene;
import reivajh06.spaceinvaders.Renderable;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AliensManager implements Renderable, Iterable<AlienRow> {

	private List<AlienRow> aliensRows = new ArrayList<>();
	private int heightSeparation = 150;

	public AliensManager(int rows, int rowBeginning, int rowY, int aliensWidth, int aliensHeight, int aliensSpeed, Color aliensColor) {
		this(10, rows, rowBeginning, rowY, aliensWidth, aliensHeight, aliensSpeed, aliensColor);
	}

	public AliensManager(int aliensInRow, int rows, int rowBeginning, int rowY, int aliensWidth, int aliensHeight, int aliensSpeed, Color aliensColor) {
		for(int i = 0; i < rows; i++) {
			aliensRows.add(new AlienRow(aliensInRow, rowBeginning, rowY + heightSeparation * i, aliensWidth, aliensHeight, aliensSpeed, aliensColor));
		}
	}

	public List<AlienRow> aliensRows() {
		return this.aliensRows;
	}

	public void update(LevelScene scene) {
		Iterator<AlienRow> iterator = iterator();

		while(iterator.hasNext()) {
			AlienRow aliens = iterator.next();

			if(aliens.isEmpty()) {
				iterator.remove();
			} else {
				aliens.update(scene);
			}
		}
	}

	@Override
	public void render(Graphics2D graphics) {
		for(AlienRow alienRow : aliensRows) {
			alienRow.render(graphics);
		}
	}

	@Override
	public Iterator<AlienRow> iterator() {
		return aliensRows().iterator();
	}
}
