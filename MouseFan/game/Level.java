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
	public ArrayList <Wall> walls = new ArrayList<>();
	Goal goal;
	double rotation;

	//TODO: Implement better method of relative positioning
	public Level (int level) {
		levelNumber = level;
		goal = new Goal (Engine.screenWidth - (Engine.screenWidth/10), Engine.screenHeight/10, 70);
		
		
		Wall testWall = new basicWall(Engine.screenWidth/6, 0, Engine.screenHeight/8, Engine.screenHeight - Engine.screenHeight/5, 0, false);
		walls.add(testWall);
		
		Wall testWall2 = new basicWall(4 * Engine.screenWidth/6, Engine.screenHeight/5, Engine.screenHeight/8, 4 * Engine.screenHeight/5, 0, false);
		walls.add(testWall2);
		
		Lava testObstacle1 = new Lava(2 * Engine.screenWidth/7, Engine.screenHeight/2 - Engine.screenHeight/10, Engine.screenWidth/3, Engine.screenHeight/10, 0, true);
		walls.add(testObstacle1);
	}
	
	public void paint (Graphics g) {
		goal.paint(g);
		for (int i = 0; i < walls.size(); i++) {
			walls.get(i).paint(g);
		}
	}

	// Create a new wall between given coordinates
	public void createNewWall(int x1, int y1, int x2, int y2) {
		int wallX, wallY;
		
		if (x1 > x2) wallX =  x2;
		else wallX = x1;
		
		if (y1 > y2) wallY = y2;
		else wallY = y1;
		
		Wall newWall = new basicWall (wallX, wallY, Math.abs(x1 - x2), Math.abs(y1-y2), 0, false);
		walls.add(newWall);
	}

}

	abstract class Wall {
		
		int x;
		int y; 
		int width;
		int length;
		double rotation;
		boolean rotating;
		int type; // 0 = empty, 1 = basic wall, 2 = lava
		
		// TODO: Too many constructors, bad practice 
		public Wall (int x, int y, int width, int length, int rotation, boolean rotating, int type) { 
			this.x = x;
			this.y = y;
			this.width = width;
			this.length = length;
			this.rotation = (double) rotation;
			this.rotating = rotating;
			this.type = type;
		}
		
		public abstract void paint(Graphics g);
		
		public void testRectangle(Graphics2D g2d) {
			// Test Rectangle
			g2d.setColor(Color.MAGENTA);
			Rectangle rect = new Rectangle (260, 260, 480, 480);
			g2d.rotate(Math.toRadians(rotation), 240+480/2, 240+480/2);
			g2d.draw(rect);
			g2d.rotate(Math.toRadians(-rotation), 240+480/2, 240+480/2);
			rotation+= .1;
		}

		 
	}
	
	class basicWall extends Wall {
		
		public basicWall(int x, int y, int width, int length, int rotation, boolean rotating) {
			super(x, y, width, length, rotation, rotating, 1);
		}

		public void paint(Graphics g) {
			Graphics2D g2d = (Graphics2D)g;
			// Test Rectangle
			g2d.rotate(Math.toRadians(rotation), x + (width/2), y + (length/2));
			g.setColor(Color.gray);
			g.fillRect(x, y, width, length);
			g2d.rotate(Math.toRadians(-rotation), x + (width/2), y + (length/2));
			
			// TODO: Move to update later,. just for testing
			if (rotating) {
				rotation += .01;
			}
		}
		
	}

	class Lava extends Wall {
		

		public Lava(int x, int y, int width, int length, int rotation, boolean rotating) {
			super(x, y, width, length, rotation, rotating, 2);
		}
		
		@Override
		public void paint(Graphics g) {
			Graphics2D g2d = (Graphics2D)g;
			// Test Rectangle
			g2d.rotate(Math.toRadians(rotation), x + (width/2), y + (length/2));
			g.setColor(Color.red);
			g.fillRect(x, y, width, length);
			g2d.rotate(Math.toRadians(-rotation), x + (width/2), y + (length/2));
			
			// TODO: Move to update later,. just for testing
				if (rotating) {
					rotation += .2;
				}
		}
		
	}
