package game;

/** Fan Engine by Matthew Shepard
 *  November 2023
 */

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Engine extends JFrame {
	private static final long serialVersionUID = 1204297901223104311L;
	
	View view;
	Controller controller;
	Level levelOne;
	public static int screenWidth = 1920;
	public static int screenHeight = 1080;
	
	public Engine () {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = screenSize.width;
		screenHeight = screenSize.height;
		levelOne = new Level(1);		
		controller = new Controller();
		view = new View(controller, levelOne);
		this.addKeyListener (controller);
		this.addMouseListener (controller);
		this.addMouseMotionListener (controller);
		
		this.setTitle("Fan Game");
		this.setSize(screenWidth, screenHeight);
		this.setFocusable(true);
		this.getContentPane().add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public static void main (String[] args) {
		Engine e = new Engine();
		System.out.println("Game loaded sucessfully");
		e.run(); 
	}
	
	public void run() {
		while(true) {
			controller.update();
			view.update();
			view.repaint(); // This will indirectly call View.paintComponent
			Toolkit.getDefaultToolkit().sync(); // Updates screen

			// Go to sleep for 25 milliseconds
			try {
				Thread.sleep(5);
			} catch(Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
			
		}
	}

}
