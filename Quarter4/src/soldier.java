import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;


public class soldier extends Applet implements MouseListener, MouseMotionListener, Runnable, KeyListener {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image player1;
	Image player2;
	int mouseCoords[] = new int[2];
	int width = (int) tk.getScreenSize().getWidth();
	int height = (int) tk.getScreenSize().getHeight();
	int jumpCount = 0;
	int jumpCount2 = 0;
	double acceleration = .098;
	double xVelocity = 0.0;
	double yVelocity = 0.0;
	double xVelocity2 = 0.0;
	double yVelocity2 = 0.0;
	double bulletCoords[][] = new double[1500][2];
	double coords1[] = new double[2];
	double coords2[] = new double[2];
	double mValues[] = new double[1500];
	int bulletCounter = 0;
	boolean aHeld = false;
	boolean wHeld = false;
	boolean dHeld = false;
	boolean sHeld = false;
	boolean zHeld = false;
	
	boolean jHeld = false;
	boolean iHeld = false;
	boolean lHeld = false;
	boolean kHeld = false;
	boolean nHeld = false;
	
	public void init() {
		setSize(500, 300);
		setBackground(Color.GRAY);
		player1 = Toolkit.getDefaultToolkit().getImage("samus.gif");
		player2 = Toolkit.getDefaultToolkit().getImage("soldier.gif");
		coords1[0] = 50;
		coords1[1] = 250;
		coords2[0] = 450;
		coords2[1] = 250;
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
	}
	
	public void start() {
		Thread th = new Thread(this);
		th.start();
	}

	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		for(;;) {
			accel();
			accel2();
			refreshVel();
			refreshVel2();
			repaint();
			try {
				Thread.sleep(15);
			}
			catch(InterruptedException e) {}
		}
	}
	
	private void refreshVel() {
		coords1[0] += xVelocity;
		coords1[1] += yVelocity;
	}
	
	private void refreshVel2() {
		coords2[0] += xVelocity2;
		coords2[1] += yVelocity2;
	}
	
	private void accel() {
		if(aHeld == false) {
			if(xVelocity < 0.0) {
				xVelocity += .1;
			}
		} if(wHeld == false) {
			if(yVelocity < 0.0) {
				yVelocity += .1;
			}
		} if(dHeld == false) {
			if(xVelocity > 0.0) {
				xVelocity -= .1;
			}
		} if(sHeld == false) {
			if(yVelocity > 0.0) {
				yVelocity -= .1;
			}
		}
		
		if(xVelocity > 3.0) {
			xVelocity -= .2;
		}
		if(yVelocity > 3.0) {
			yVelocity -= .2;
		}
		if(xVelocity < -3.0) {
			xVelocity += .2;
		}
		if(yVelocity < -3.0) {
			yVelocity += .2;
		}
		if(coords1[1] < 230) {
			yVelocity += .6;
		}
		if(coords1[1] > 250) {
			jumpCount = 0;
			yVelocity -= 1;
		}
	}
	
	private void accel2() {
		if(jHeld == false) {
			if(xVelocity2 < 0.0) {
				xVelocity2 += .1;
			}
		} if(iHeld == false) {
			if(yVelocity2 < 0.0) {
				yVelocity2 += .1;
			}
		} if(lHeld == false) {
			if(xVelocity2 > 0.0) {
				xVelocity2 -= .1;
			}
		} if(kHeld == false) {
			if(yVelocity2 > 0.0) {
				yVelocity2 -= .1;
			}
		}
		
		if(xVelocity2 > 3.0) {
			xVelocity2 -= .2;
		}
		if(yVelocity2 > 3.0) {
			yVelocity2 -= .2;
		}
		if(xVelocity2 < -3.0) {
			xVelocity2 += .2;
		}
		if(yVelocity2 < -3.0) {
			yVelocity2 += .2;
		}
		if(coords2[1] < 230) {
			yVelocity2 += .6;
		}
		if(coords2[1] > 260) {
			jumpCount2 = 0;
			yVelocity2 -= 1;
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(player1, (int) coords1[0], (int) coords1[1], 50, 50, this);
		g.drawImage(player2, (int) coords2[0], (int) coords2[1], 50, 50, this);
		g.drawOval((int)bulletCoords[bulletCounter][0], (int)bulletCoords[bulletCounter][1], 10, 10);
		g.drawRect(100, 200, 30, 100);
		g.drawRect(400, 200, 30, 100);
		g.drawRect(130, 200, 270, 30);
		//g.drawRect();

	}
	
	public void mouseDragged(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {
		mouseCoords[0] = e.getX();
		mouseCoords[1] = e.getY();
	}

	public void keyTyped(KeyEvent e) {
		char command = e.getKeyChar();
	}

	public void keyPressed(KeyEvent e) {
		char command = e.getKeyChar();
		if(command == 'z') {
			zHeld = true;
		} if(command == 'n') {
			nHeld = true;
		}
		if(command == 'a') {
			xVelocity -= 3;
			aHeld = true;
		} if(command == 'w') {
			if(jumpCount <= 1) {
				yVelocity -= 10;
				wHeld = true;
			}
			jumpCount++;
		} if(command == 'd') {
			xVelocity += 3;
			dHeld = true;
		} if(command == 's') {
			yVelocity += 3;
			sHeld = true;
		}
		
		if(command == 'j') {
			jHeld = true;
			xVelocity2 -= 3;
		} if(command == 'i') {
			if(jumpCount2 <= 1) {
				iHeld = true;
				yVelocity2 -= 10;
			}
		} if(command == 'l') {
			lHeld = true;
			xVelocity2 += 3;
		} if(command == 'k') {
			kHeld = true;
			yVelocity2 += 3;
		}
	}

	public void keyReleased(KeyEvent e) {
		char command = e.getKeyChar();
		
		if(command == 'a') {
			aHeld = false;
		} if(command == 'w') {
			wHeld = false;
		} if(command == 'd') {
			dHeld = false;
		} if(command == 's') {
			sHeld = false;
		}
		
		if(command == 'j') {
			jHeld = false;
		} if(command == 'i') {
			iHeld = false;
		} if(command == 'l') {
			lHeld = false;
		} if(command == 'k') {
			kHeld = false;
		}
	}
	
	private void shoot() {
		bulletCoords[bulletCounter][0] += mouseCoords[1] - coords1[1];
		bulletCoords[bulletCounter][1] += mouseCoords[0] - coords1[0];
		bulletCounter++;
	}
	
	public void mouseClicked(MouseEvent e) {
		mouseCoords[0] = e.getX();
		mouseCoords[1] = e.getY();
		shoot();
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

}
