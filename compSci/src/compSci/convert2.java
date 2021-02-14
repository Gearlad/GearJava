package compSci;

import javax.swing.JOptionPane;

public class convert2 {
	
	int binary[] = new int[7];
	int base10;
	int sum = 0;
	
	String binaryString;
	
	public void userInput() {
		binaryString = JOptionPane.showInputDialog(null, "Enter 7 bit binary number");
		if(binaryString.length() != 7) {
			JOptionPane.showMessageDialog(null, "Not 7 bit");
			userInput();
		}
		for(int i = 0; i < binaryString.length(); i++) {
			binary[i] = Integer.parseInt(binaryString.substring(i, i+1));
		}
	}
	
	public void converter() {
		int multiplier = 1;
		for(int i = binaryString.length()-1; i >= 0; i--) {
			if(binary[i] == 1) { 
				sum += multiplier;
			}
			multiplier *= 2;
		}
	}
	
	public void output() {
		System.out.println(sum);
	}
}
