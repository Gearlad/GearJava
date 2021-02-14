import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//Pile of plates, always pushes and pops from top

public class stack extends JFrame implements ActionListener{

	JButton popButton;
	JButton stackButton;
	
	String array[] = new String[6];
	
	int size;
	
	boolean stack = true;
	
	public static void main(String[] args) {
		stack obj = new stack();
	}
	
	public stack() {
		setSize(200,100);
		setLayout(new GridLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		stackButton = new JButton("Stack");
		stackButton.addActionListener(this);
		add(stackButton);
		
		popButton = new JButton("Pop");
		popButton.addActionListener(this);
		add(popButton);
	}
	
	public void sizing() {
		if(stack == true) {
			size = 1;
		} else {
			size = 0;
		}
		for(int i = 0; i < 6; i++) {
			if(array[i] == null) {
				break;
			}
			size++;
		}
	}
	
	public void pop() {
		stack = false;
		sizing();
		if(size > 0) {
			array[size-1] = null;
		} else {
			array[0] = null;
		}
		printer();
	}
	
	public void printer() {
		for(int i = 0; i < 6; i++) {
			System.out.println(array[i]);
		}
	}
	
	public void stacker() {
		stack = true;
		String word = JOptionPane.showInputDialog(null,"Enter word");
		sizing();
		array[size-1] = word;
		printer();
	}
	
	public void actionPerformed(ActionEvent e) {
		String word = e.getActionCommand();
		if(word.equals("Stack")) {
			stacker();
		} else if(word.equals("Pop")) {
			pop();
		}
	}

}
