import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JApplet;

public class zeldaTest extends JApplet implements Runnable, KeyListener {

	BufferedImage zeldaWalk;
	int xVelocity = 0;
	int yVelocity = 0;
	int xPos = 0;
	int yPos = 0;
	
	public void init() {
		setSize(500,400);
		setBackground(Color.WHITE);
		addKeyListener(this);
	}
	
	public void paint(Graphics g) {
		//xPos += xVelocity;
		//yPos += yVelocity;
	}
	
	public void start() {
		Thread th = new Thread(this);
		th.start();
	}
	
	public void stop() {}
	
	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while(true) {
			repaint();
			try {
				Thread.sleep(0);
			}
			catch(InterruptedException e) {}
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		System.out.println("test");
		String input = e.getKeyChar() + "";
		if(input.equals("a")) {
			xVelocity = -1;
		} if(input.equals("w")) {
			yVelocity = -1;
		} if(input.equals("d")) {
			xVelocity = 1;
		} if(input.equals("s")){
			yVelocity = 1;
		}
	}

	public void keyReleased(KeyEvent e) {
		System.out.println("");
		String input = e.getKeyChar() + "";
		if(input.equals("a")) {
			xVelocity = 0;
		} if(input.equals("w")) {
			yVelocity = 0;
		} if(input.equals("d")) {
			xVelocity = 0;
		} if(input.equals("s")){
			yVelocity = 0;
		}
		
	}
}
