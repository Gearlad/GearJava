package compSci;

import javax.swing.JOptionPane;

public class convert {
	
	int binary;
	int base10;
	int sum = 0;
	
	String binaryString;
	
	public void userInput() {
		binary = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter binary number"));
		binaryString = binary + "";
	}
	
	public void converter() {
		int multiplier = 1;
		for(int i = binaryString.length()-1; i >= 0; i--) {
			if(binaryString.substring(i, i+1).equals("1")) { 
				System.out.println("a");
				sum += multiplier;
			}
			multiplier *= 2;
			System.out.println(i + " " + multiplier);
		}
	}
	
	public void output() {
		System.out.println(sum);
	}
}
