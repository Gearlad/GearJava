import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BubbleSort extends JFrame implements ActionListener, ChangeListener {

	JButton randomiseButton;
	JButton searchButton;
	JSlider amtSlider;
	JLabel slideLabel;
	int sliderInt;
	JLabel numberLabel;
	String randomNumString;
	JLabel foundLabel;
	int[] randomValues;
	JButton sortButton;
	JButton selectionSortButton;
	ArrayList<Integer> randomNumbers = new ArrayList();
	
	public static void main(String [] args) {
		BubbleSort obj = new BubbleSort();
	}
	
 	public BubbleSort() {
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new GridLayout(8,2));
		setTitle("BubbleSort");
		slideLabel = new JLabel("Amt: "+sliderInt);
		add(slideLabel);
		amtSlider = new JSlider(0,1000,0);
		amtSlider.setMajorTickSpacing(100);
		amtSlider.setPaintTicks(true);
		amtSlider.addChangeListener(this);
		add(amtSlider);
		numberLabel = new JLabel("Number in spot x is: x");
		add(numberLabel);
		randomiseButton = new JButton("Randomise");
		add(randomiseButton);
		randomiseButton.addActionListener(this);
		searchButton = new JButton("Search");
		add(searchButton);
		searchButton.addActionListener(this);
		sortButton = new JButton("Sort");
		sortButton.addActionListener(this);
		add(sortButton);
		selectionSortButton = new JButton("Selection sort");
		selectionSortButton.addActionListener(this);
		add(selectionSortButton);
		foundLabel = new JLabel("Found x in x turns");
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
					if(random == randomValues[h]) {
						break;
					}
					if(h == randomValues.length-1) {
						found = true;
					}
				}
				if(found == true) {
					randomValues[i] = random;
					break;
				}
			}
		}
		int random = (int)(Math.random()*randomValues.length);
		numberLabel.setText("Number in spot "+random+" is: "+randomValues[random]);
		randomNumString = randomValues[random]+"";
		for(int i = 0; i < randomValues.length; i++) {
			System.out.println("Random: "+randomValues[i]);
		}
	}
	
	public void search() {
		for(int i = 0; i < randomValues.length; i++) {
			if(Integer.parseInt(randomNumString)==(int)(randomValues[i])) {
				foundLabel.setText("Found "+randomNumString+" in "+(i+1)+" turns");
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
					randomValues[i] = random;
					break;
				}
			}
		}
	}
	
	public void sort() {
		boolean found = false;
		while(true) {
			for(int i = 0; i < randomValues.length-1; i++) {
				if(randomValues[i] > randomValues[i+1]) {
					int parse = randomValues[i];
					randomValues[i] = randomValues[i+1];
					randomValues[i+1] = parse;
				}
			}
			for(int i = 0; i < randomValues.length-1; i++) {
				if(randomValues[i] > randomValues[i+1]) {
					break;
				} if(i == randomValues.length-2) {
					found = true;
				}
			}
			if(found == true) {
				break;
			}
		}
		for(int i = 0; i < randomValues.length; i++) {
			System.out.println("Order: "+randomValues[i]);
		}
	}
	
	public void sort2() {
		for(int i = randomValues.length-1; i >= 0; i--) {
			int parse = 0;
			int parse2 = 0;
			for(int h = 0; h <= i; h++) {
				if(randomValues[h] > parse) {
					parse = randomValues[h];
					parse2 = h;
				}
			}
			randomValues[parse2] = randomValues[i];
			randomValues[i] = parse;
		}
		for(int i = 0; i < randomValues.length; i++) {
			System.out.println("Order: "+randomValues[i]);
		}
	}
 	
	public void actionPerformed(ActionEvent e) {
		String word = e.getActionCommand();
		if(word.equals("Randomise")) {
			randomise();
		} else if(word.equals("Search")) {
			search();
		} else if(word.equals("Sort")) {
			sort();
		} else if(word.equals("Selection sort")) {
			sort2();
		}
	}
	
}