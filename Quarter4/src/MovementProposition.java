import java.applet.Applet;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MovementProposition extends Applet implements Runnable, KeyListener {
	
	public void init() {
		setSize(500, 375);
		setBackground(Color.GRAY);
		addKeyListener(this);
	}
	
	public void run() {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		int input = e.getKeyCode();
		if(input == 'a') {
			
		} else if(input == 'w') {
			
		} else if(input == 'd') {
			
		} else if(input == 's') {
			
		} else if(input == KeyEvent.) {
			
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}
}
