import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class selectionSort extends JFrame implements ActionListener {

	public selectionSort() {
		setSize(400,200);
		setLayout(new GridLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		String word = e.getActionCommand();
		
	}
	
}
