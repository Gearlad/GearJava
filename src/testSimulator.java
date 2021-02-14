import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class testSimulator extends JFrame implements ActionListener{
	JTextField testField;
	static int counter=1;
	JButton enterButton;
	JButton listButton;
	JButton clearButton;
	JButton exitButton;
	JLabel listOutput;
	static String listString="";
	JLabel enterText;
	String[] array=new String[10];
	public static void main(String [] args) {
		testSimulator obj=new testSimulator();
	}
	public testSimulator() {
		setTitle("Test Simulator");
		setLayout(new GridLayout(20,5));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1400,800);
		setVisible(true);
		enterText=new JLabel("Enter in test 1");
		add(enterText);
		testField=new JTextField("");
		add(testField);
		listOutput=new JLabel("");
		add(listOutput);
		enterButton=new JButton("Enter");
		enterButton.addActionListener(this);
		add(enterButton);
		listButton=new JButton("List");
		listButton.addActionListener(this);
		add(listButton);
		clearButton=new JButton("Clear");
		clearButton.addActionListener(this);
		add(clearButton);
		exitButton=new JButton("Exit");
		exitButton.addActionListener(this);
		add(exitButton);
	}
	public void actionPerformed(ActionEvent e) {
		enterText.setText("Enter in test "+counter);
		if(counter>=10) {
			counter=1;
			JOptionPane.showMessageDialog(null,"Max exceeded; clearing");
			enterText.setText("Enter in test "+counter);
		}
		String word=e.getActionCommand();
		listOutput.setText("");
		if(word.equals("Enter")) {
			listString+=", "+testField.getText();
			array[counter]=testField.getText();
		}
		else if(word.equals("List")) {
			listOutput.setText(listString);
		}
		else if(word.equals("Clear")) {
			listString="";
			for(int i=0;i<array.length;i++) {
				array[i]=null;
			}
		}
		else if(word.equals("Exit")) {
			System.exit(0);
		}
		counter++;
	}
}
