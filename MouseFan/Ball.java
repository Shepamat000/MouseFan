
/** Fan Engine by Matthew Shepard
 *  November 2023
 */
import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	float x;
	float y; 
	int size = 25;
	float velX = 0;
	float velY = 0;
	
	public Ball (float xPos, float yPos) {
		x = xPos;
		y = yPos;
	}
	
	public void update (Level l) {
		x += velX;
		y += velY;
		
		checkForCollisions(l);
		
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
	
	public void Paint (Graphics g) {
		g.setColor (Color.black);
		g.fillOval((int) x - 12, (int) y - 12, size, size);
	}
	
	public void checkForCollisions (Level level) {
		double distance = Math.sqrt((level.goal.x - x) * (level.goal.x - x) + (level.goal.y - y) * (level.goal.y - y));
		if (distance < level.goal.size/2 + size/2) {
			x = 200;
			y = 200; 
			level.levelNumber++;
		}
		
	}
}
