import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//Line to buy something; first person to go in line is the first person out
//Enqeue and deqeue

public class queue extends JFrame implements ActionListener {
	
	String array[] = new String[6];
	
	JButton enqeueButton;
	JButton deqeueButton;
	
	int size;

	public static void main(String [] args) {
		queue obj = new queue();
	}
	
	public queue() {
		setSize(300,100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,2));
		
		enqeueButton = new JButton("Enqeue");
		enqeueButton.addActionListener(this);
		add(enqeueButton);
		
		deqeueButton = new JButton("Deqeue");
		deqeueButton.addActionListener(this);
		add(deqeueButton);
	}
	
	public void sizing() {
		size = 0;
		for(int i = 0; i < 6; i++) {
			if(array[i] == null) {
				break;
			}
			size++;
		}
	}
	
	public void enqeue() {
		String word = JOptionPane.showInputDialog(null,"Enter word");
		
		for(int i = 4; i >= 0; i--) {
			array[i+1] = array[i];
		}
		
		array[0] = word;
		
		print();
		
	}
	
	public void deqeue() {
		sizing();
		array[size-1] = null;
		print();
	}
	
	public void print() {
		for(int i = 0; i < 6; i++) {
			System.out.println(array[i]);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		String word = e.getActionCommand();
		if(word.equals("Enqeue")) {
			enqeue();
		} else if(word.equals("Deqeue")) {
			deqeue();
		}
	}
	
}