package testy;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MasterDriver extends JApplet implements KeyListener, Runnable, MouseListener {
	
	static double playerCoords[] = new double[2];
	static double xVelocity = 0.0;
	static double yVelocity = 0.0;
	
	static int ticks = 100000;
	int walkCounter = 100;
	static int intermittent = 0;
	static int code;
	static int iconCoords[] = new int[2];
	static int selection = 0;
	static int initialTiming = -1200;
	static int currentStep = 1;
	static int area = 0;

	
	static boolean moving[] = new boolean[4];
	static boolean paused = false;
	boolean firstPaint = false;
	static boolean aHeld = false;
	static boolean wHeld = false;
	static boolean dHeld = false;
	static boolean sHeld = false;
	protected static boolean logged = false;
	static boolean initialEnter = false;
	static boolean visibleIcon = false;
	boolean shiftBoolean[] = new boolean[4];
	static boolean playSteps = false;
	static boolean newCrusadeBool = false;
	static boolean loadNames = false;
	
	static char command;
	
	static ArrayList fileNames = new ArrayList<String>();
	
	static String newName = "";
	
	static Object rowData[][];
	static Object columnNames[];
	static JTable files;
	static JScrollPane scrollPane;
	
	//Diagonal, back, facing right
	public static Image man, man1, man2, man11, man22;
	//Diagonal, back, facing left
	public static Image manFlipped, manFlipped1, manFlipped2, manFlipped11, manFlipped22;
	//Diagonal, forward, facing right
	public static Image manStraightFlipped, manStraightFlipped1, manStraightFlipped2, manStraightFlipped11, manStraightFlipped22;
	//Diagonal, forward, facing left
	public static Image manStraight, manStraight1, manStraight2, manStraight11, manStraight22;
		
	//Side, horizontal, facing right
	public static Image manSide, manSide1, manSide2, manSide11, manSide22;
	//Side, horizontal, facing left
	public static Image manSideFlipped, manSideFlipped1, manSideFlipped2, manSideFlipped11, manSideFlipped22;
	//Side, vertical, facing forward
	public static Image manAhead, manAhead1, manAhead2;
	//Side, vertical, facing backward
	public static Image manBack, manBack1, manBack2;
		
		
	//Title screen text
	public static Image beginTitle, newCrusadeTitle, continueCrusadeTitle, exeunt;
		
	public static Image landscape1, gravelRoad;	
	
	public static Image previousImage;
	
	//Maps of the kingdom
	public static Image map, mapLarge;
	
	public static Image blankImage;
	
	public static Image iconImage;
	
	//Shadows
	public static Image shadow, nightShadow1, nightShadow2, nightShadow3, nightShadow4, nightShadow5, roadShadow;
	
	//Environmental detail sprites
	public static Image signPost;
	
	//Exit screen
	public static Image leaveKingdom;
	
	static JTextField nameField;
	
	
	public void init() {
		setSize(700, 500);
		addKeyListener(this);
		setVisible(true);
		RunOperator.initiate();
	}
	
	public static void initiateTable() {
		files = new JTable(rowData, columnNames);
		scrollPane = new JScrollPane(files);
	}
	
	public void paint(Graphics g) {
		
		g.setColor(Color.LIGHT_GRAY);
		//g.drawImage(map, 0, 0, 1000, 700, this);
		setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		TimerManager.intermittentFunc();
		Controller.selectionDetect();
		
		if(logged == false) {
			g.drawImage(mapLarge, 150, 0, 550, 500, this);
			g.fillRect(0, 0, 150, 500);
			if(initialEnter == false) {
				if(visibleIcon == true) g.drawImage(iconImage, iconCoords[0], iconCoords[1], 45, 15, this);
				else g.fillRect(iconCoords[0], iconCoords[1], 45, 15);
				g.drawImage(beginTitle, 20, 100, 121, 76, this);
				
			} else {				
				if(visibleIcon == true) g.drawImage(iconImage, iconCoords[0], iconCoords[1], 45, 15, this);
				else g.fillRect(iconCoords[0], iconCoords[1], 45, 15);
				if(loadNames == false) {
					g.drawImage(newCrusadeTitle, 0, 70, 150, 200, this);
					g.drawImage(continueCrusadeTitle, 0, 280, 150, 30, this);
					g.drawImage(exeunt, 0, 400, 96, 58, this);
				} else {
					
				}
			}
		}
		
		else if(logged == true) {
			if(paused == false) ticks++;
			for(int i = 0; i <= 600; i += 100) {
				for(int h = 0; h <= 400; h += 100) {
					g.drawImage(landscape1, i, h, this);
				}
			}
			
			for(int i = 0; i < 700; i += 60) {
				for(int h = 120; h < 180; h += 60) {
					g.drawImage(gravelRoad, i, h, 60, 60, this);
				}
			}
			for(int i = 0; i < 700; i += 20) {
				g.drawImage(roadShadow, i, 180, this);
			}
			
			g.drawString(playerCoords[0] + ", " + playerCoords[1], 10, 20);
			
			g.drawImage(shadow, 110, 190, 60, 10, this);
			if(playerCoords[1] > 71) {
				g.drawImage(signPost, 100, 100, this);
			}
			if(ticks > 65000 && ticks < 185000) {
				g.drawImage(shadow, (int)playerCoords[0] + 15, (int)playerCoords[1] + 80, 30, 30, this);
			}
			
			if(firstPaint == false) {
				g.drawImage(manBack, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				previousImage = manBack;
			}
			
			if((ticks - initialTiming) < 1000) {
				g.setColor(Color.YELLOW);
				g.setFont(new Font("Times New Roman", Font.PLAIN, 12));
				g.drawString("Well, hello there!", (int)playerCoords[0] - 10, (int)playerCoords[1] + 20);
			}
			
			if(xVelocity > 0 && yVelocity == 0) {
				if(currentStep == 1) {
					g.drawImage(manSide1, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 2) {
					g.drawImage(manSide2, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 3) {
					g.drawImage(manSide, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 4) {
					g.drawImage(manSide11, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 5) {
					g.drawImage(manSide22, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 6) {
					g.drawImage(manSide, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				}
				previousImage = manSide;
				firstPaint = true;
			}
			
			if(xVelocity < 0 && yVelocity == 0) {
				if(currentStep == 1) {
					g.drawImage(manSideFlipped1, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 2) {
					g.drawImage(manSideFlipped2, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 3) {
					g.drawImage(manSideFlipped, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 4) {
					g.drawImage(manSideFlipped11, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 5) {
					g.drawImage(manSideFlipped22, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 6) {
					g.drawImage(manSideFlipped, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				}
				previousImage = manSideFlipped;
				firstPaint = true;
			}
			
			if(xVelocity == 0 && yVelocity > 0) {
				if(currentStep == 1) {
					g.drawImage(manAhead1, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 2) {
					g.drawImage(manAhead2, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 3) {
					g.drawImage(manAhead, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 4) {
					g.drawImage(manAhead1, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 5) {
					g.drawImage(manAhead2, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 6) {
					g.drawImage(manAhead, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				}
				previousImage = manAhead;
				firstPaint = true;
			}
			
			if(xVelocity == 0 && yVelocity < 0) {
				if(currentStep == 1) {
					g.drawImage(manBack1, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 2) {
					g.drawImage(manBack2, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 3) {
					g.drawImage(manBack, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 4) {
					g.drawImage(manBack1, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 5) {
					g.drawImage(manBack2, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 6) {
					g.drawImage(manBack, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				}
				previousImage = manBack;
				firstPaint = true;
			}
			
			if(xVelocity == 0 && yVelocity == 0) {
				g.drawImage(previousImage, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
			}
			
			if(xVelocity > 0 && yVelocity > 0) {
				if(currentStep == 1) {
					g.drawImage(manStraight1, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 2) {
					g.drawImage(manStraight2, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 3) {
					g.drawImage(manStraight, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 4) {
					g.drawImage(manStraight11, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 5) {
					g.drawImage(manStraight22, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 6) {
					g.drawImage(manStraight, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				}
				previousImage = manStraight;
				firstPaint = true;
			}
			
			if(xVelocity < 0 && yVelocity > 0) {
				if(currentStep == 1) {
					g.drawImage(manStraightFlipped1, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 2) {
					g.drawImage(manStraightFlipped2, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 3) {
					g.drawImage(manStraightFlipped, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 4) {
					g.drawImage(manStraightFlipped11, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 5) {
					g.drawImage(manStraightFlipped22, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 6) {
					g.drawImage(manStraightFlipped, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				}
				previousImage = manStraightFlipped;
				firstPaint = true;
			}
			
			if(xVelocity > 0 && yVelocity < 0) {
				if(currentStep == 1) {
					g.drawImage(man1, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 2) {
					g.drawImage(man2, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 3) {
					g.drawImage(man, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 4) {
					g.drawImage(man11, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 5) {
					g.drawImage(man22, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 6) {
					g.drawImage(man, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				}
				previousImage = man;
				firstPaint = true;
			}
			
			if(xVelocity < 0 && yVelocity < 0) {
				if(currentStep == 1) {
					g.drawImage(manFlipped1, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 2) {
					g.drawImage(manFlipped2, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 3) {
					g.drawImage(manFlipped, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 4) {
					g.drawImage(manFlipped11, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 5) {
					g.drawImage(manFlipped22, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				} else if(currentStep == 6) {
					g.drawImage(manFlipped, (int)playerCoords[0], (int)playerCoords[1], 60, 115, this);
				}
				previousImage = manFlipped;
				firstPaint = true;
			}
			
			if(xVelocity > 0 || yVelocity > 0 || xVelocity < 0 || yVelocity < 0) {
				if(walkCounter >= 250) {
					walkCounter -= 150;
				}
				walkCounter++;
				CharacterWalk.determineStep(walkCounter);
			}
			
			if(playerCoords[1] <= 71) {
				g.drawImage(signPost, 100, 100, this);
			}
			
			String picture = DayToNight.tickHandler();
			if(picture.equals("nightShadow1")) {
				for(int i = 0; i < 700; i += 100) {
					for(int h = 0; h < 500; h += 100) {
						g.drawImage(nightShadow1, i, h, this);
					}
				}
			} else if(picture.equals("nightShadow2")) {
				for(int i = 0; i < 700; i += 100) {
					for(int h = 0; h < 500; h += 100) {
						g.drawImage(nightShadow2, i, h, this);
					}
				}
			} else if(picture.equals("nightShadow3")) {
				for(int i = 0; i < 700; i += 100) {
					for(int h = 0; h < 500; h += 100) {
						g.drawImage(nightShadow3, i, h, this);
					}
				}
			} else if(picture.equals("nightShadow4")) {
				for(int i = 0; i < 700; i += 100) {
					for(int h = 0; h < 500; h += 100) {
						g.drawImage(nightShadow4, i, h, this);
					}
				}
			} else if(picture.equals("nightShadow5")) {
				for(int i = 0; i < 700; i += 100) {
					for(int h = 0; h < 500; h += 100) {
						g.drawImage(nightShadow5, i, h, this);
					}
				}
			}
		}
		if(paused == true) {
			for(int i = 0; i < 700; i += 100) {
				for(int h = 0; h < 500; h += 100) {
					g.drawImage(nightShadow1, i, h, this);
				}
			}
			if(visibleIcon == true) {
				g.drawImage(iconImage, iconCoords[0], iconCoords[1], 45, 15, this);
			}
			g.drawImage(leaveKingdom, 0, 160, 275, 60, this);
		}
	}
	
	public void start() {
		(new Thread(this)).start();
	}
	
	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while(true) {
			RunOperator.runMethod();
			repaint();
			RunOperator.sleep();
		}
	}
	
	public void keyTyped(KeyEvent e) {}
	
	public void keyPressed(KeyEvent e) {
		command = e.getKeyChar();
		if(paused == false) {
			Controller.directionalArrows();
		}
		code = e.getKeyCode();
		Controller.otherButtons();
	}

	public void keyReleased(KeyEvent e) {
		command = e.getKeyChar();
		if(paused == false) {
			Controller.directionalArrowsRelease();
		}
	}

	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
	}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
}
