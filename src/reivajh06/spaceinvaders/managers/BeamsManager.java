package reivajh06.spaceinvaders.managers;

import reivajh06.spaceinvaders.scenes.LevelScene;
import reivajh06.spaceinvaders.Renderable;
import reivajh06.spaceinvaders.entities.Beam;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BeamsManager implements Renderable, Iterable<Beam> {

	protected List<Beam> beams;

	public BeamsManager() {
		this.beams = new ArrayList<>();
	}

	public void addBeam(Beam beam) {
		beams.add(beam);
	}

	public void update(LevelScene scene) {

		Iterator<Beam> iterator = beams.iterator();

		while(iterator.hasNext()) {
			Beam beam = iterator.next();

			if (beam.isDestroyed()) {
				iterator.remove();
			} else {
				beam.update(scene);
			}
		}
	}

	public boolean isEmpty() {
		return beams.isEmpty();
	}

	@Override
	public void render(Graphics2D graphics) {
		for (Beam beam : beams) {
			beam.render(graphics);
		}
	}

	@Override
	public Iterator<Beam> iterator() {
		return beams.iterator();
	}
}
