import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;


public class jumpification extends JFrame implements ActionListener {

	int random[] = new int[5];
	JButton randomiseButton;
	
	public static void main(String[] args) {
		jumpification obj = new jumpification();
	}

	public void random() {
		for(int i = 0; i < random.length; i++) {
			random[i] = (int)(Math.random()*20);
			System.out.println(random[i]);
		}
		
	}
	
	public void pathFinder() {
	}
	
	public jumpification() {
		setSize(200,400);
		setLayout(new GridLayout(3,3));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		randomiseButton = new JButton("Randomise");
		randomiseButton.addActionListener(this);
		add(randomiseButton);
	}
	
	public void actionPerformed(ActionEvent e) {
		String word = e.getActionCommand();
		if(word.equals("Randomise")) {
			random();
			pathFinder();
		}
	}

}
