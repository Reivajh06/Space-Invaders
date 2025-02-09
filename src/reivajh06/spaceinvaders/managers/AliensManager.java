package reivajh06.spaceinvaders.managers;

import reivajh06.spaceinvaders.AlienRow;
import reivajh06.spaceinvaders.LevelScene;
import reivajh06.spaceinvaders.Renderable;
import reivajh06.spaceinvaders.sprites.SpriteSet;
import reivajh06.spaceinvaders.sprites.Spritesheet;
import reivajh06.spaceinvaders.sprites.SpritesheetFactory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AliensManager implements Renderable, Iterable<AlienRow> {

	private List<AlienRow> aliensRows = new ArrayList<>();
	private int heightSeparation = 50;
	private Map<String, List<BufferedImage>> sprites;

	public AliensManager(int rows, int rowBeginning, int rowY, int aliensWidth, int aliensHeight, int aliensSpeed, Color aliensColor, Map<String, List<BufferedImage>> sprites) {
		this(10, rows, rowBeginning, rowY, aliensWidth, aliensHeight, aliensSpeed, aliensColor, sprites);
	}

	public AliensManager(int aliensInRow, int rows, int rowBeginning, int rowY, int aliensWidth, int aliensHeight, int aliensSpeed, Color aliensColor, Map<String, List<BufferedImage>> sprites) {
		for(int i = 0; i < rows; i++) {
			System.out.println("alien" + (i+1));
			aliensRows.add(new AlienRow(aliensInRow, rowBeginning, rowY + heightSeparation * i, aliensWidth, aliensHeight, aliensSpeed, aliensColor, sprites.get("alien" + (i + 1)), sprites.get("alienBeam")));
		}

		this.sprites = sprites;
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
