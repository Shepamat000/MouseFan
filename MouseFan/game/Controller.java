package game;

/** Fan Engine by Matthew Shepard
 *  November 2023
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Controller implements ActionListener, MouseMotionListener, MouseListener, KeyListener{
	
	int mouseX;
	int mouseY;
	static float angle;

	public void update() {
		float xDist = Math.abs(mouseX - (int) View.ball.x);
		float yDist = Math.abs(mouseY - (int) View.ball.y);
		float angle;
		if (xDist > 0) angle  = (float) Math.atan(yDist/xDist); else angle  = (float) (Math.PI/2);
		int distance = (int) Math.sqrt((double) ((xDist*xDist)+(yDist*yDist)));
		
		if (distance < 500) {
			float distanceMultiplier = (500 - distance)/500.0f;
			if (mouseX > View.ball.x) {
				//System.out.println((float) Math.cos(angle));
				if (View.ball.velX > -5 * (float) Math.cos(angle) * distanceMultiplier * distanceMultiplier) View.ball.velX -= ((float) Math.cos(angle)) * distanceMultiplier * .1;
			}
			if (mouseX < View.ball.x) {
				if (View.ball.velX < 5 * (float) Math.cos(angle) * distanceMultiplier * distanceMultiplier) View.ball.velX += ((float) Math.cos(angle)) * distanceMultiplier * .1;
			}
			if (mouseY > View.ball.y) {
				if (View.ball.velY > -5 * (float) Math.sin(angle) * distanceMultiplier * distanceMultiplier) View.ball.velY -= ((float) Math.sin(angle)) * distanceMultiplier * .1;
			}
			if (mouseY < View.ball.y) {
				if (View.ball.velY < 5 * (float) Math.sin(angle) * distanceMultiplier * distanceMultiplier) View.ball.velY += ((float) Math.sin(angle)) * distanceMultiplier * .1;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}


	
}
