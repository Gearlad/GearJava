import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class average extends JFrame implements ActionListener,ChangeListener {
	ArrayList<Integer> average;
	ArrayList<Integer> average2;
	JLabel sizeLabel;
	JSlider sizeSlider;
	JButton calculate;
	JLabel rangeOneLabel;
	JLabel rangeTwoLabel;
	JSlider rangeOneSlider;
	JSlider rangeTwoSlider;
	JLabel amountLabel;
	JSlider amountSlider;
	JLabel noLabel;
	JSlider noSlider;
	JLabel averageLabel;
	JLabel averageExtractionLabel;
	int averageInt;
	int averageInt2;
	JLabel blankLabel;
	int size;
	int rangeOne;
	int rangeTwo;
	int amount;
	int no;
	
	public static void main(String [] args) {
		average obj = new average();	
	}
	
	public average() {
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new GridLayout(8,2));
		setTitle("Average");
		sizeLabel = new JLabel("Size: 0");
		add(sizeLabel);
		sizeSlider = new JSlider(0,1000,0);
		sizeSlider.setMajorTickSpacing(100);
		sizeSlider.setPaintTicks(true);
		add(sizeSlider);
		sizeSlider.addChangeListener(this);
		rangeOneLabel = new JLabel("Minimum: 0");
		add(rangeOneLabel);
		rangeOneSlider = new JSlider(0,100,0);
		rangeOneSlider.setMajorTickSpacing(10);
		rangeOneSlider.setPaintTicks(true);
		add(rangeOneSlider);
		rangeOneSlider.addChangeListener(this);
		rangeTwoLabel = new JLabel("Maximum: 0");
		add(rangeTwoLabel);
		rangeTwoSlider = new JSlider(0,100,0);
		rangeTwoSlider.setMajorTickSpacing(10);
		rangeTwoSlider.setPaintTicks(true);
		add(rangeTwoSlider);
		rangeTwoSlider.addChangeListener(this);
		amountLabel = new JLabel("Extraction size: 0");
		add(amountLabel);
		amountSlider = new JSlider(0,100,0);
		amountSlider.setMajorTickSpacing(10);
		amountSlider.setPaintTicks(true);
		add(amountSlider);
		amountSlider.addChangeListener(this);
		noLabel = new JLabel("No. per extraction: 0");
		add(noLabel);
		noSlider = new JSlider(0,100,0);
		noSlider.setMajorTickSpacing(10);
		noSlider.setPaintTicks(true);
		add(noSlider);
		noSlider.addChangeListener(this);
		calculate = new JButton("Calculate");
		add(calculate);
		calculate.addActionListener(this);
		blankLabel = new JLabel();
		add(blankLabel);
		averageLabel = new JLabel("Average: 0");
		add(averageLabel); 
		averageExtractionLabel = new JLabel("Average Extraction: 0");
		add(averageExtractionLabel);
	}
	
	public void getValues() {
		size = sizeSlider.getValue();
		rangeOne = rangeOneSlider.getValue();
		rangeTwo = rangeTwoSlider.getValue();
		amount = amountSlider.getValue();
		no = noSlider.getValue();
	}
	
	public void calculate() {
		getValues();
		double avg = 0;
		ArrayList<Integer> randomValues = new ArrayList();
		for(int i = 0; i < size; i++) {
			randomValues.add((int)(Math.random()*(rangeTwo-rangeOne))+rangeOne);
			avg += randomValues.get(i);
		}
		averageLabel.setText("Average: "+(avg /= size+0.0));
		ArrayList<Integer> extract = new ArrayList();
		double avg2 = 0;
		for(int i = 0; i < no*amount; i++) {
			extract.add(randomValues.get((int)(Math.random()*size)));
			avg2 += extract.get(i);
		}
		averageExtractionLabel.setText("Average Extraction: " + (avg2 /= (no*amount+0.0)));
	}

	public void actionPerformed(ActionEvent e) {
		String word = e.getActionCommand();
		if(word.equals("Calculate")) {
			calculate();
		}
	}
	public void stateChanged(ChangeEvent e) {
		getValues();
		sizeLabel.setText("Size: "+size);
		rangeOneLabel.setText("Minimum: "+rangeOne);
		rangeTwoLabel.setText("Maximum: "+rangeTwo);
		amountLabel.setText("Extraction Size: "+amount);
		noLabel.setText("No. per extraction: "+no);
	}
}
