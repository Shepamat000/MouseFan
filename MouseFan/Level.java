
/** Fan Engine by Matthew Shepard
 *  November 2023
 */
import java.awt.Graphics;
import java.util.ArrayList;

public class Level {
	
	int levelNumber;
	ArrayList <Wall> walls = new ArrayList<>();
	Goal goal;
	
	public Level (int level) {
		levelNumber = level;
		goal = new Goal (1700, 200, 50);
	}
	
	public void paint (Graphics g) {
		goal.paint(g);
	}

}

	class Wall {
		 
	}

	class Lava extends Wall {
		
	}
