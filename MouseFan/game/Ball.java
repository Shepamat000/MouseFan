package game;

/** Fan Engine by Matthew Shepard
 *  November 2023
 */
import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	float startX, startY;
	float x;
	float y; 
	int size = 25;
	float velX = 0;
	float velY = 0;
	
	public static boolean dead; 
	int animationTimer = 0;
	
	public Ball (float xPos, float yPos) {
		x = xPos;
		y = yPos;
		startX = xPos;
		startY = yPos;
	}
	
	public void Paint (Graphics g) {
		g.setColor(Color.black);
		if (!dead) g.fillOval((int) x - 12, (int) y - 12, size, size);
		// Death animation
		else {
			g.fillOval((int) x - animationTimer, (int) y - animationTimer, size/4, size/4);
			g.fillOval((int) x + animationTimer, (int) y - animationTimer, size/4, size/4);
			g.fillOval((int) x - animationTimer, (int) y + animationTimer, size/4, size/4);
			g.fillOval((int) x + animationTimer, (int) y + animationTimer, size/4, size/4);
			animationTimer += 2;
		}
	}
	
	
	public void update (Level l) {
		if (dead) return; // Do not run if dead
		
		x += velX;
		// X collision check
		if (checkForCollisions(l)) {
			x -= velX;
			velX = -velX;
		}
		y += velY;
		// Y collision Check 
		if (checkForCollisions(l)) {
			y -= velY;
			velY = -velY;
		}
		
		// Slows down ball if it has velocity 
		velX -= velX/100;
		velY -= velY/100;
		
		if (Math.abs(velY) < .0001) velY = 0;
		if (Math.abs(velX) < .0001) velX = 0;
		
		if (x < 0) {
			velX = -velX;
			x += 10;
		}
		
		if (y < 0) {
			velY = -velY;
			y += 10;
		}
		
		if (x > Engine.screenWidth - 50) {
			velX = -velX;
			x -= 10;
		}
		
		if (y > Engine.screenHeight - 50) {
			velY = -velY;
			y -= 10;
		}
		
	}
	
	// Collision check
	public boolean checkForCollisions (Level level) {
		double distance = Math.sqrt((level.goal.x - x) * (level.goal.x - x) + (level.goal.y - y) * (level.goal.y - y));
		if (distance < level.goal.size/2 + size/2) {
			x = 200;
			y = 200; 
			level.levelNumber++;
		}
		
		// Main collision logic for walls
		for (int i = 0; i < level.walls.size(); i++) {
			if (x + size/2 > level.walls.get(i).x && x - size/2 < level.walls.get(i).x + level.walls.get(i).width) {
				if (y + size/2 > level.walls.get(i).y && y - size/2 < level.walls.get(i).y + level.walls.get(i).length) {
					if (level.walls.get(i).type == 2) dead = true; // Player dies if lava
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	public boolean revive () {
		if (dead) {
			x = startX;
			y = startY;
			dead = false; 
			animationTimer = 0;
			return true; 
		} else {
			return false;
		}
	}
}
