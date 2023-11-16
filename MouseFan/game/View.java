package game;

/** Fan Engine by Matthew Shepard
 *  November 2023
 */
import java.awt.Color;
import java.awt.Font;
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
		
		if (Controller.editMode) {
			editModeUI(g);
		}
	}
	
	// May consider moving this to its own class
	public void editModeUI (Graphics g) {
		// set font
		Font currentFont = g.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 2F);
		g.setFont(newFont);
				
		g.setColor(Color.YELLOW);
		g.drawString("Edit mode active", 5, 20);
		
		// Draw box where current selection is.  
		if (Controller.currentSelectionX == 0 && Controller.currentSelectionY == 0) return;
		g.setColor(Color.red);
		int drawX, drawY;
		
		if (Controller.currentSelectionX > Controller.mouseX) drawX =  Controller.mouseX;
		else drawX = Controller.currentSelectionX;
		
		if (Controller.currentSelectionY > Controller.mouseY) drawY =  Controller.mouseY;
		else drawY = Controller.currentSelectionY;
		
		g.drawRect(drawX, drawY, Math.abs(Controller.mouseX-Controller.currentSelectionX), Math.abs(Controller.mouseY - Controller.currentSelectionY));
	}
	
	public void update () {
		ball.update(level);
	}
	
}
