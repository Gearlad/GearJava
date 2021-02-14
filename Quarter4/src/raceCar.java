import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JApplet;


public class raceCar extends Applet implements Runnable, KeyListener {
	
	boolean firstCount = true;
	Image tank;
	Image tank2;
	Timer timer;
	double xVelocity = 0.0;
	double yVelocity = 0.0;
	double xVelocity2 = 0.0;
	double yVelocity2 = 0.0;
	double tankCoords[] = new double[2];
	double tankCoords2[] = new double[2];
	boolean aHeld = false;
	boolean wHeld = false;
	boolean dHeld = false;
	boolean sHeld = false;
	boolean complete = false;
	boolean recentLap = false;
	boolean recentLap2 = false;
	int interval = 5;
	Toolkit tk = Toolkit.getDefaultToolkit();
	int height = (int)tk.getScreenSize().getHeight();
	int width = (int)tk.getScreenSize().getWidth();
	
	int laps = 0;
	int compLaps = 0;
	
	boolean lapTimer = false;
	
	public void init() {
		setSize(((int) tk.getScreenSize().getWidth()), ((int) tk.getScreenSize().getHeight()));
		tank = Toolkit.getDefaultToolkit().getImage("tank.png");
		tank2 = tank;
		tankCoords[0] = 35;
		tankCoords[1] = 35;
		tankCoords2[0] = 85;
		tankCoords2[1] = 35;
		addKeyListener(this);
		timer();
	}
	
	public void paint(Graphics g) {
		setFont(new Font("Times New Roman", Font.ITALIC, 20));
		g.drawImage(tank, (int)(tankCoords[0]), (int)(tankCoords[1]), 30, 30, this);
		g.drawImage(tank2, (int)(tankCoords2[0]), (int)(tankCoords2[1]), 30, 30, this);
		g.drawRect(0, 0, width, 30);
		g.drawRect(0, 30, 30, height - 150);
		g.drawRect(0, 648, 5000, 30);
		g.drawRect(width - 30, 30, 30, height - 150);
		g.drawRect(150, 150, 1050, 400);
		g.drawRect(30, 150, 120, 15);
		if(complete == false) {
			g.drawString("Beginning in " + interval, 130, 50);
		};
		g.drawString("Coords: " + (int) tankCoords[0] + ", " + (int) tankCoords[1], 10, 15);
		g.drawString("Player Score: " + laps, 180, 15);
		g.drawString("Computer score: " + compLaps, 350, 15);
	}
	
	public void start() {
		Thread th = new Thread(this);
		th.start();
	}
	
	public void stop() {}
	
	private void checkParametres() {
		if(tankCoords[0] <= 25 || tankCoords[0] > width - 50 || tankCoords[0] >= 130 && tankCoords[0] < 135 && tankCoords[1] >= 150 && tankCoords[1] <= 530
				|| tankCoords[0] <= 1185 && tankCoords[0] >= 1180 && tankCoords[1] >= 150 && tankCoords[1] <= 530) {
			xVelocity *= -.85;
		} if(tankCoords[1] <= 30 || tankCoords[1] >= 620 || tankCoords[1] > 130 && tankCoords[1] < 160 && tankCoords[0] > 100 && tankCoords[0] < 1190
				|| tankCoords[1] < 545 && tankCoords[1] > 540 && tankCoords[0] > 130 && tankCoords[0] < 1180) {
			yVelocity *= -.85;
		}
		
		if(tankCoords[1] >= 150 && tankCoords[1] <= 160 && tankCoords[0] > 24 && tankCoords[0] < 160 && interval <= 0) {
			if(recentLap == false) {
				recentLap = true;
				laps++;
			}
		}
		if(tankCoords[1] >= 160 && tankCoords[1] <= 170 && tankCoords[0] > 24 && tankCoords[0] < 160 && interval <= 0) {
			recentLap = false;
		}
	}
	
	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while(true) {
			if(interval <= 0 && firstCount == false) {
				autonomousProps();
				accel();
				velocity();
				checkParametres();
				collision();
			}
			repaint();
			try {
				Thread.sleep(8);
			}
			catch(InterruptedException e) {}
		}
	}
	
	private void collision() {
		if(tankCoords[0] >= tankCoords2[0] - 15 && tankCoords[0] < tankCoords2[0] - 5 && tankCoords[1] > tankCoords2[1] - 15 && tankCoords[1] < tankCoords2[1] + 15) {
			xVelocity *= .8;
			xVelocity2 *= -1;
		}
	}
	
	private void autonomousProps() {
		if(interval <= 0) {
		//	0,0 - 130,500
			if(tankCoords2[0] > 0 && tankCoords2[0] <= 130 && tankCoords2[1] > 0 && tankCoords2[1] < 500) {
				yVelocity2 += .15;
			}
			//0, 530 - 1316, 617
			if(tankCoords2[0] > 0 && tankCoords2[0] <= 1316 && tankCoords2[1] > 530 && tankCoords2[1] < 617) {
				xVelocity2 += .15;
			}
			//1316, 622 - 1178, 32
			
			if(tankCoords2[0] >= 1178 && tankCoords2[0] <= 1400 && tankCoords2[1] >= 32 && tankCoords2[1] <= 622) {
				yVelocity2 -= .15;
			}
			
			//1316, 26 - 148, 123
			if(tankCoords2[0] >= 123 && tankCoords2[0] <= 1390 && tankCoords2[1] >= 26  && tankCoords2[1] <= 125) {
				xVelocity2 -= .15;
			}
			
			if(tankCoords[0] <= 25 || tankCoords2[0] > width - 50 || tankCoords2[0] >= 130 && tankCoords2[0] < 135 && tankCoords2[1] >= 150 && tankCoords2[1] <= 530
					|| tankCoords2[0] <= 1185 && tankCoords2[0] >= 1180 && tankCoords2[1] >= 150 && tankCoords2[1] <= 530) {
				xVelocity2 *= -.85;
			} if(tankCoords2[1] <= 30 || tankCoords2[1] >= 620 || tankCoords2[1] > 130 && tankCoords2[1] < 160 && tankCoords2[0] > 100 && tankCoords2[0] < 1190
					|| tankCoords2[1] < 545 && tankCoords2[1] > 540 && tankCoords2[0] > 130 && tankCoords2[0] < 1180) {
				yVelocity2 *= -.85;
			}
			
			if(tankCoords2[1] >= 150 && tankCoords2[1] <= 160 && tankCoords2[0] > 24 && tankCoords2[0] < 160 && interval <= 0) {
				if(recentLap2 == false) {
					recentLap2 = true;
					compLaps++;
				}
			}
			if(tankCoords2[1] >= 160 && tankCoords2[1] <= 170 && tankCoords2[0] > 24 && tankCoords2[0] < 160 && interval <= 0) {
				recentLap2 = false;
			}
			
			if(xVelocity2 >= 3.0) {
				xVelocity2 = 3.0;
			}
			if(yVelocity2 >= 3.0) {
				yVelocity2 = 3.0;
			}
			if(xVelocity2 <= -3.0) {
				xVelocity2 = -3.0;
			}
			if(yVelocity2 <= -3.0) {
				yVelocity2 = -3.0;
			}
			tankCoords2[0] += xVelocity2;
			tankCoords2[1] += yVelocity2;
		}
	}
	
	private void accel() {
		if(aHeld == true) {
			xVelocity -= .05;
			tankCoords[0] += xVelocity;
		}
		if(wHeld == true) {
			yVelocity -= .05;
			tankCoords[1] += yVelocity;
		}
		if(dHeld == true) {
			xVelocity += .05;
			tankCoords[0] += xVelocity;
		}
		if(sHeld == true) {
			yVelocity += .05;
			tankCoords[1] += yVelocity;
		}
		
		if(aHeld == false) {
			if(xVelocity < 0.0) {
				xVelocity *= .98;
				tankCoords[0] += xVelocity;
			}
		}
		if(wHeld == false) {
			if(yVelocity < 0.0) {
				yVelocity *= .98;
				tankCoords[1] += yVelocity;
			}
		}
		if(dHeld == false) {
			if(xVelocity > 0.0) {
				xVelocity *= .98;
				tankCoords[0] += xVelocity;
			}
		}
		if(sHeld == false) {
			if(yVelocity > 0.0) {
				yVelocity *= .98;
				tankCoords[1] += yVelocity;
			}
		}
	}
	
	private void velocity() {
		if(xVelocity > 3) {
			xVelocity = 3.0;
		} else if(xVelocity < -3) {
			xVelocity = -3.0;
		}
		
		if(yVelocity > 3) {
			yVelocity = 3;
		} else if(yVelocity < -3) {
			yVelocity = -3;
		}
		tankCoords[0] += xVelocity;
		tankCoords[1] += yVelocity;
	}
	
	
	public void timer() {
		firstCount = false;
	    lapTimer = false;
	    int delay = 1000;
	    int period = 1000;
	    timer = new Timer();
	    timer.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
	        	interval--;
	        	if(interval <= 0) {
	        		complete = true;
	        		timer.cancel();
	        	}
	        }
	    }, delay, period);	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		String input = e.getKeyChar() + "";
		if(input.equals("a")) {
			aHeld = true;
		} if(input.equals("w")) {
			wHeld = true;
		} if(input.equals("d")) {
			dHeld = true;
		} if(input.equals("s")) {
			sHeld = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		String input = e.getKeyChar() + "";
		if(input.equals("a")) {
			aHeld = false;
		} if(input.equals("w")) {
			wHeld = false;
		} if(input.equals("d")) {
			dHeld = false;
		} if(input.equals("s")) {
			sHeld = false;
		}
	}
}
