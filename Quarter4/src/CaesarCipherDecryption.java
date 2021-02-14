import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CaesarCipherDecryption extends JFrame implements ActionListener {
	
	JButton textFileButton;
	int charLengths[];
	String message;
	char alphabet[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	
	public static void main(String [] args) {
		CaesarCipherDecryption obj = new CaesarCipherDecryption();
	}
	
	public CaesarCipherDecryption() {
		setSize(800, 300);
		setTitle("Caesar Cipher Decryption");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout());
		setVisible(true);
		
		textFileButton = new JButton("To Text File?");
		add(textFileButton);
		textFileButton.addActionListener(this);
		
	}
	
	public void inputAPhrase() {
		message = JOptionPane.showInputDialog(null,"Input a message");
	}
	
	public void writeToTextFile() {
		
		PrintWriter outputStream = null;
		
		try {
			outputStream= new PrintWriter(new FileOutputStream("string.txt"));
		}
		
		catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Error: File 'string.txt' not found");
		}
	}
	
	public void readFromTextFile() {
		Scanner inputStream = null;
		
		try {
			inputStream = new Scanner(new FileInputStream(""));
		}
		
		catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Error: File 'string.txt' not found");
		}
	}
	
	public void countChars() {
		charLengths = new int[message.length()];
		
		for(int i = 0; i < message.length(); i++) {
			for(int h = 0; h < 26; h++) {
				if(message.substring(i,i+1).equals(alphabet[h])) {
					charLengths[i]++;
				}
			}
		}
	}
	
	public void letterRankings() {
		int largest = 0;
		int placing = 0;
		for(int i = 0; i < charLengths.length; i++) {
			if(charLengths[i] > largest) {
				largest = charLengths[i];
				placing = i;
			}
		}
		
		int secondLargest = 0;
		for(int i = 0; i < charLengths.length; i++) {
			
		}
	}
	
	public void crackCode() {
		
	}

	public void actionPerformed(ActionEvent e) {
		String word = e.getActionCommand();
		if(word.equals("To Text File?"))
			writeToTextFile();
	}
}
