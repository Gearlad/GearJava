import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class duckHunt extends Applet implements Runnable, MouseListener, MouseMotionListener {
	
	int crossHairCoords[] = new int[2];
	Image bird1, bird2, explosion, background;
	int birdCoords[] = new int[2];
	int explodeCoords[] = new int[2];
	boolean done = false;
	static Timer timer;
	static int interval = 2;
	boolean done2 = false;
	int score = 0;
	int shots = 5;
	int level = 1;
	boolean gameOver = false;
	int random4 = (int)(Math.random()*2);
	//private Image crossHair;
	
	
	public void init() {
		setLayout(new BorderLayout());
		bird1 = Toolkit.getDefaultToolkit().getImage("bird1.gif");
		explosion = Toolkit.getDefaultToolkit().getImage("explosion.gif");
		background = Toolkit.getDefaultToolkit().getImage("background.gif");
		birdCoords[0] = -500;
		if(random4 == 0) {
			birdCoords[0] = 1000;
		}
		birdCoords[1] = 10;
		setSize(500, 375);
		setBackground(Color.GRAY);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		setFont(new Font("Times New Roman", Font.ITALIC, 12));
		g.drawImage(background, 0, 0, 500, 375, this);
	/*	Cursor invisibleCursor = getToolkit().createCustomCursor(crossHair, new Point(10, 10), "Invisible");
		this.setCursor(invisibleCursor);*/
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		g.drawImage(bird1, birdCoords[0], birdCoords[1], 100, 100, this);
		g.drawString("Score: " + score, 10, 15);
		g.drawString(crossHairCoords[0] + ", " + crossHairCoords[1], 10, 30);
		g.drawString("Shots: " + shots, 10, 45);
		g.drawString("Level: " + level, 10, 60);
		if(done == true && done2 == false) {
			g.drawImage(explosion, explodeCoords[0] - 18, explodeCoords[1] - 33, 50, 50, this);
		}
		if(gameOver) {
			g.drawString("Game over", 10, 75);
		}
	}
	
	public void start() {
		Thread th = new Thread(this);
		th.start();
	}
	
	public void stop() {}
	
	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while(true) {
			birds();
			repaint();
			if(gameOver) {
				break;
			}
			try {
				Thread.sleep(5);
			}
			catch(InterruptedException e) {}
		}
	}
	
	public void birds() {
		int random = (int)(Math.random() * 2) + 1;
		int random2 = (int)(Math.random()*1000);
		int random3 = (int)(Math.random()*800);
		random4 = (int)(Math.random()*2);

		random2*=-1;
		birdCoords[0] += random;
		if(birdCoords[0] > 500) {
			birdCoords[0] = random2;
			birdCoords[1] = random3;
		}	
	}

	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		if(shots <= 0) {
			gameOver = true;
		} else {
			shots--;
			done2 = false;
			explodeCoords[0] = e.getX();
			explodeCoords[1] = e.getY();
			done = true;
			if(explodeCoords[0] >= birdCoords[0] && explodeCoords[0] <= birdCoords[0] + 50
					&& explodeCoords[1] >= birdCoords[1] && explodeCoords[1] <= birdCoords[1] + 50) {
				birdCoords[0] = 900;
				score += 10;
				if(Math.ceil(score / level) > 10) {
					level++;
					
				}
			}
			timer();
		}
	}
	
	public void timer() {
	    int delay = 1000;
	    int period = 500;
	    timer=new Timer();
	    timer.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
	        	interval--;
	        	if(interval<=0) {
	        		done2 = true;
	        		timer.cancel();
	        	}
	        }
	    }, delay, period);
	}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mouseDragged(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {
		crossHairCoords[0] = e.getX();
		crossHairCoords[1] = e.getY();
	}

}
