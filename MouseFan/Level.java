package game;

import java.awt.Color;
/** Fan Engine by Matthew Shepard
 *  November 2023
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Level {
	
	int levelNumber;
	ArrayList <Wall> walls = new ArrayList<>();
	Goal goal;
	double rotation;
	
	public Level (int level) {
		levelNumber = level;
		goal = new Goal (Engine.screenWidth - (Engine.screenWidth/10), Engine.screenHeight/10, 50);
	}
	
	public void paint (Graphics g) {
		goal.paint(g);
	}

}

	class Wall {
		
		int x;
		int y; 
		int width;
		int length;
		double rotation;
		
		public void paint(Graphics g) {
			// Test Rectangle
			g.setColor(Color.gray);
			Graphics2D g2d = (Graphics2D)g;
			Rectangle rect = new Rectangle (260, 260, 480, 480);
			g2d.rotate(Math.toRadians(rotation), 240+480/2, 240+480/2);
			g2d.fill(rect);
			g2d.rotate(Math.toRadians(-rotation), 240+480/2, 240+480/2);
			rotation+= .1;
		}

		 
	}

	class Lava extends Wall {
		
	}
