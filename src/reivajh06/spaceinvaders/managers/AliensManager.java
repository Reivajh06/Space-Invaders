package reivajh06.spaceinvaders.managers;

import reivajh06.spaceinvaders.AlienRow;
import reivajh06.spaceinvaders.configurators.AliensConfig;
import reivajh06.spaceinvaders.scenes.LevelScene;
import reivajh06.spaceinvaders.Renderable;
import reivajh06.spaceinvaders.sprites.SpritePainter;

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

	public AliensManager(AliensConfig config) {
		this.sprites = config.sprites();
		for(int i = 0; i < config.rows(); i++) {
			Color alienRowColor = config.aliensColors().get(i % config.aliensColors().size());

			System.out.println("alien" + (i+1));
			List<BufferedImage> alienSprites = sprites.get("alien" + (i + 1));

			aliensRows.add(new AlienRow(config.aliensInRow(), config.rowBeginning(), config.rowY() + heightSeparation * i,
					config.aliensWidth(), config.aliensHeight(), config.aliensSpeed(),
					alienRowColor,
					SpritePainter.paint(alienSprites, alienRowColor), sprites.get("alienBeam")));
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

	public boolean isEmpty() {
		return aliensRows.isEmpty();
	}
 }
