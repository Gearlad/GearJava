import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class randomiser extends JFrame implements ActionListener, ChangeListener {

	JButton randomiseButton;
	JButton searchButton;
	JButton binarySearchButton;
	JSlider amtSlider;
	JLabel slideLabel;
	int sliderInt;
	String randomNumString;
	JLabel foundLabel;
	int[] randomValues;
	JLabel numberLabel;
	JTextField searchNumberField;
	ArrayList<Integer> randomNumbers = new ArrayList();
	
	public static void main(String [] args) {
		randomiser obj = new randomiser();
	}
	
 	public randomiser() {
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new GridLayout(8,2));
		setTitle("Randomiser");
		slideLabel = new JLabel("Amt: "+sliderInt);
		add(slideLabel);
		amtSlider = new JSlider(0,1000,0);
		amtSlider.setMajorTickSpacing(100);
		amtSlider.setPaintTicks(true);
		amtSlider.addChangeListener(this);
		add(amtSlider);
		numberLabel = new JLabel("Enter number to search");
		add(numberLabel);
		searchNumberField = new JTextField("");
		add(searchNumberField);
		searchNumberField.addActionListener(this);
		randomiseButton = new JButton("Randomise");
		add(randomiseButton);
		randomiseButton.addActionListener(this);
		searchButton = new JButton("Search");
		add(searchButton);
		binarySearchButton = new JButton("Binary search");
		binarySearchButton.addActionListener(this);
		add(binarySearchButton);
		searchButton.addActionListener(this);
		foundLabel = new JLabel("Found null in null turns");
		add(foundLabel);
	}
	
	public void stateChanged(ChangeEvent e) {
		sliderInt = amtSlider.getValue();
		slideLabel.setText("Amt: "+sliderInt);
	}
	
	public void randomise() {
		randomValues = new int[amtSlider.getValue()];
		for(int i = 0; i < randomValues.length; i++) {
			for(;;) {
				boolean found = false;
				int random = (int)(Math.random()*randomValues.length)+1;
				for(int h = 0; h < randomValues.length; h++) {
					if(random==randomValues[h]) {
						break;
					}
					if(h==randomValues.length-1) {
						found = true;
					}
				}
				if(found==true) {
					System.out.println("success"+i);
					randomValues[i] = random;
					break;
				}
			}
		}
		int random = (int)(Math.random()*randomValues.length);
		numberLabel.setText("Number in spot "+random+"is: "+randomValues[random]);
		randomNumString = randomValues[random]+"";
	}
	
	public void search() {
		for(int i = 0; i < randomValues.length; i++) {
			if(Integer.parseInt(randomNumString)==(int)(randomValues[i])) {
				foundLabel.setText("Found "+randomNumString+" in "+i+" turns");
				break;
			}
		}
		randomValues = new int[amtSlider.getValue()];
		for(int i = 0; i < randomValues.length; i++) {
			for(;;) {
				boolean found = false;
				int random = (int)(Math.random()*randomValues.length)+1;
				for(int h = 0; h < randomValues.length; h++) {
					if(random==randomValues[h]) {
						break;
					}
					if(h==randomValues.length-1) {
						found = true;
					}
				}
				if(found==true) {
					System.out.println("success"+i);
					randomValues[i] = random;
					break;
				}
			}
		}
	}
	
	public void binarySearch() {
		 double counter = randomValues.length / 2;
		 int counterInt = (int)Math.ceil(counter);
		 for(;;) {
			 if(counter == counterInt) {
				 	
			 } else {
				 
			 }
		 }
	
	public void actionPerformed(ActionEvent e) {
		String word = e.getActionCommand();
		if(word.equals("Randomise")) {
			randomise();
		} else if(word.equals("Search")) {
			search();
		} else if(word.equals("Binary Search")) {
			binarySearch();
		}
	}
	
}