import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class romanNumerals extends JFrame implements ActionListener {
	
	JTextField romanNumeral;
	JButton base10Button;
	JButton binaryButton;
	JButton hexButton;
	JButton exitButton;
	JLabel outputLabel;
	int romanNumeralInt = 0;
	
	String binaryString;
	String hexString;
	
	public static void main(String[] args) {
		romanNumerals obj = new romanNumerals();
	}
	
	public romanNumerals() {
		
		setSize(200, 200);
		setTitle("Roman Numerals");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,4));
		setVisible(true);
		
		romanNumeral = new JTextField("Enter roman Numeral");
		add(romanNumeral);
		
		base10Button = new JButton("Base 10");
		add(base10Button);
		
		binaryButton = new JButton("Binary");
		add(binaryButton);
		
		hexButton = new JButton("Hex");
		add(hexButton);
		
		outputLabel = new JLabel("Output: " + romanNumeralInt);
		add(outputLabel);
		
		exitButton = new JButton("Exit");
		add(exitButton);
		
		base10Button.addActionListener(this);
		exitButton.addActionListener(this);
		binaryButton.addActionListener(this);
		hexButton.addActionListener(this);
	}
	
	public int check(String romanNumeral) {
		romanNumeralInt = 0;
		int tempArray[] = new int[romanNumeral.length()];
		for(int i = 0; i < romanNumeral.length(); i++) {
			String substringA = romanNumeral.substring(i, i+1);
			if(substringA.equals("I")) {
				tempArray[i] = 1;
			} else if(substringA.equals("V")) {
				tempArray[i] = 5;
			} else if(substringA.equals("X")) {
				tempArray[i] = 10;
			} else if(substringA.equals("L")) {
				tempArray[i] = 50;
			} else if(substringA.equals("C")) {
				tempArray[i] = 100;
			} else if(substringA.equals("D")) {
				tempArray[i] = 500;
			}
		}
		
		if(romanNumeral.length() == 1) {
			romanNumeralInt = tempArray[0];
		} else {
			for(int i = 1; i < tempArray.length; i++) {
				if(tempArray[i - 1] >= tempArray[i]) {
					romanNumeralInt += tempArray[i - 1];
				} else {
					romanNumeralInt += (tempArray[i] - tempArray[i - 1]);
				}
			}
		}
		
		return romanNumeralInt;
	}
	
	private void toHex() {
		toBinary();
		hexString = "";
		String array[][] = new String[4][10];
		int counter = 0;
		int lengthCounter = 0;
		for(int i = 0; i < binaryString.length() - 1; i += 4) {
			array[counter][i] = binaryString.substring(i, i+4);
			if(counter >= 4) {
				counter = 0;
			}
			counter++;
		}
		
		for(int i = 0; i < binaryString.length(); i++) {
			try {
				System.out.println(array[0][i]);
				lengthCounter++;
			}
			catch(ArrayIndexOutOfBoundsException e) {
				break;
			}
		}
		
		for(int i = 0; i < lengthCounter; i++) {
			int temp = 0;
			for(int h = 0; h < 4; h++) {
				if(Integer.parseInt(array[i][h]) == 1) {
					temp += Math.pow(2, h);
				}
			}
			if(temp < 10) {
				hexString += temp + "";
			}
			else {
				if(temp == 10) {
					hexString += "A";
				} else if(temp == 11) {
					hexString += "B";
				} else if(temp == 12) {
					hexString += "C";
				} else if(temp == 13) {
					hexString += "D";
				} else if(temp == 14) {
					hexString += "E";
				} else if(temp == 15) {
					hexString += "F";
				}
			}
		}
		outputLabel.setText(hexString);
	}
	
	private void toBinary() {
		binaryString = "";
		for(int i = 512; i >= 1; i /= 2) {
			if((romanNumeralInt - i) >= 0) {
				romanNumeralInt -= i;
				binaryString += "1";
			} else {
				binaryString += "0";
			}
		}
		outputLabel.setText("Output: " + binaryString);
	}
	
	public void actionPerformed(ActionEvent e) {
		check(romanNumeral.getText());
		String command = e.getActionCommand();
		if(command.equals("Base 10")) {
			outputLabel.setText(check(romanNumeral.getText()) + "");
		}
		if(command.equals("Hex")) {
			toHex();
		}
		if(command.equals("Binary")) {
			toBinary();
		}
		if(command.equals("Exit")) {
			System.exit(0);
		}
		
	}
}