import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JApplet;


public class lineDraw extends JApplet implements Runnable, MouseListener {
	
	int coords[][] = new int[2][10];
	int counter = 0;
	
	public void init() {
		setSize(400,400);
		setBackground(Color.GRAY);
		addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		if(counter > 10) {
			//System.out.println("Array size exceeded!");
		}
		else {
			g.setColor(Color.GREEN);
			
			//System.out.println("loop");
			for(int i = 0; i < counter; i++) {
				g.drawOval(coords[0][i], coords[1][i], 5, 5);
				if(i > 0) {
					g.drawLine(coords[0][i-1], coords[1][i-1], coords[0][i], coords[1][i]);
				}
			}
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
			try {
				Thread.sleep(0);
			}
			catch(InterruptedException e) {}
		}
	}

	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		
		if(counter >= 10) {
			System.out.println("Array size exceeded!");
			repaint();
		}
		else {
			coords[0][counter] = e.getX();
			coords[1][counter] = e.getY();
			System.out.println("coords X: "+coords[0][counter]+", counter "+counter);
			System.out.println("coords Y: "+coords[1][counter]);
			counter++;
			repaint();
		}
	}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

}
