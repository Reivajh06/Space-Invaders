package reivajh06.spaceinvaders.managers;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

public class AliensConfig {

	private int aliensInRow = 10;
	private int rows = 1;
	private int rowBeginning = 0;
	private int rowY = 100;
	private int aliensWidth = 70;
	private int aliensHeight = 70;
	private int aliensSpeed = 30;
	private List<Color> aliensColors = List.of(Color.WHITE);
	private Map<String, List<BufferedImage>> sprites;

	public int aliensInRow() {
		return aliensInRow;
	}

	public AliensConfig aliensInRow(int aliensInRow) {
		this.aliensInRow = aliensInRow;
		return this;
	}

	public int rows() {
		return rows;
	}

	public AliensConfig rows(int rows) {
		this.rows = rows;
		return this;
	}

	public int rowBeginning() {
		return rowBeginning;
	}

	public AliensConfig rowBeginning(int rowBeginning) {
		this.rowBeginning = rowBeginning;
		return this;
	}

	public int rowY() {
		return rowY;
	}

	public AliensConfig rowY(int rowY) {
		this.rowY = rowY;
		return this;
	}

	public int aliensWidth() {
		return aliensWidth;
	}

	public AliensConfig aliensWidth(int aliensWidth) {
		this.aliensWidth = aliensWidth;
		return this;
	}

	public int aliensHeight() {
		return aliensHeight;
	}

	public AliensConfig aliensHeight(int aliensHeight) {
		this.aliensHeight = aliensHeight;
		return this;
	}

	public int aliensSpeed() {
		return aliensSpeed;
	}

	public AliensConfig aliensSpeed(int aliensSpeed) {
		this.aliensSpeed = aliensSpeed;
		return this;
	}

	public List<Color> aliensColors() {
		return aliensColors;
	}

	public AliensConfig aliensColors(List<Color> aliensColors) {
		this.aliensColors = aliensColors;
		return this;
	}

	public Map<String, List<BufferedImage>> sprites() {
		return sprites;
	}

	public AliensConfig sprites(Map<String, List<BufferedImage>> sprites) {
		this.sprites = sprites;
		return this;
	}
}