package compSci;

import javax.swing.JOptionPane;

public class memoryGame {
	
	String numCol;
	String runAgain;
	String randomString;
	
	int amount;
	
	public void preferenceInput() {
		numCol = JOptionPane.showInputDialog("Would you like to work with numbers or colours?");
		amount = Integer.parseInt(JOptionPane.showInputDialog("How many colours would you like to try?"));
	}
	
	public void randomise() {
		
	}
	
	public void memoriseInput() {
		JOptionPane.showMessageDialog(null, "Memorise " + randomString);
		
	}
	
}
