/** Fan Engine by Matthew Shepard
 *  November 2023
 */
import java.awt.Color;
import java.awt.Graphics;

public class Goal {
	int x;
	int y;
	int size;
	
	public Goal (int xPos, int yPos, int goalSize) {
		x = xPos;
		y = yPos;
		size = goalSize;
	}
	
	public void paint (Graphics g) {
		g.setColor(Color.green);
		g.fillOval(x - size/2, y - size/2, size, size);
	}

}
