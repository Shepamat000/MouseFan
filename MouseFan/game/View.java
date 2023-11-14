package game;

/** Fan Engine by Matthew Shepard
 *  November 2023
 */
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class View extends JPanel {
	private static final long serialVersionUID = 6933906508599056769L;
	
	static Ball ball; 
	static Level level; 
	
	View(Controller c, Level l) {
		ball = new Ball (200, 200);
		level = l;
	}
	
	public void paintComponent (Graphics g) {
		g.setColor (new Color (100, 175, 255)); 
		g.fillRect (0, 0, this.getWidth(), this.getHeight()); 
		level.paint(g);
		ball.Paint(g);
	}
	
	public void update () {
		ball.update(level);
	}
	
}
