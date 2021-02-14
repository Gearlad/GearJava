import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class bealsConjecture extends JFrame implements ActionListener {
	
	int A = 0;
	int B = 0;
	int C = 0;
	int x = 0;
	int y = 0;
	int z = 0;
	
	boolean loopBool = false;
	
	double equation = 0.0;
	
	Object options[] = {"Random", "Up to", "Check"};
	Object loopOp[] = {"Loop", "Once"};
	JComboBox list = new JComboBox(options);
	JComboBox loop = new JComboBox(loopOp);
	JLabel outputLabel;
	JButton enterButton;
	JButton toMainButton;
	
	JPanel homePanel = new JPanel();
	JPanel randomPanel = new JPanel();
	
	public static void main(String[] args) {
		bealsConjecture obj = new bealsConjecture();
	}
	
	public bealsConjecture() {
		setSize(400, 200);
		setLayout(new GridLayout(3, 1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Proving or disproving Beal's Conjecture");
		
		list.addActionListener(this);
		//list.setSelectedIndex(0);
		homePanel.add(list);
		
		loop.addActionListener(this);
		randomPanel.add(loop);
		
		enterButton = new JButton("Generate");
		enterButton.addActionListener(this);
		//randomPanel.add(enterButton);
		
		outputLabel = new JLabel("Permutation: \nOutput: ");
		randomPanel.add(outputLabel);
		
		add(homePanel);
		homePanel.setVisible(true);
		
		add(randomPanel);
		randomPanel.setVisible(false);
		
		setVisible(true);
	}
	
	private void random() {
		homePanel.setVisible(false);
		randomPanel.setVisible(true);
		
		double ctoZ = 0.0;
		
		while(loopBool == true) {
			A = (int)(Math.random() * 1000000000) + 1;
			B = (int)(Math.random() * 1000000000) + 1;
			C = (int)(Math.random() * 1000000000) + 1;
			
			x = (int)(Math.random() * 10) + 1;
			y = (int)(Math.random() * 10) + 1;
			z = (int)(Math.random() * 10) + 1;
			
			ctoZ = (Math.pow(C, z));
			
			equation = (double)(Math.pow(A, x)) + (double)(Math.pow(B, y));
			if(equation == ctoZ) {
				outputLabel.setText("Permutation: A: " + A +", \nB: " + B + ", \nC: " + C + ", \nx: " + x + ", \ny: "+ y + ", \nz: " + z +
						"\nEquation: " + equation + "\nC^z: " + ctoZ + "\nOutput: disproven");
				loopBool = true;
			} else {
				outputLabel.setText("Permutation: A: " + A +", \nB: " + B + ", \nC: " + C + ", \nx: " + x + ", \ny: "+ y + ", \nz: " + z +
						"\nEquation: " + equation + "\nC^z: " + ctoZ + "\nOutput: not disproven");
			}
		}
		if(loopBool == false) {
			A = (int)(Math.random() * 1000000000) + 1;
			B = (int)(Math.random() * 1000000000) + 1;
			C = (int)(Math.random() * 1000000000) + 1;
			
			x = (int)(Math.random() * 10) + 2;
			y = (int)(Math.random() * 10) + 2;
			z = (int)(Math.random() * 10) + 2;
			
			ctoZ = (Math.pow(C, z));
			
			equation = (double)(Math.pow(A, x)) + (double)(Math.pow(B, y));
			if(equation == ctoZ) {
				outputLabel.setText("Permutation: A: " + A +", \nB: " + B + ", \nC: " + C + ", \nx: " + x + ", \ny: "+ y + ", \nz: " + z +
						"\nEquation: " + equation + "\nC^z: " + ctoZ + "\nOutput: disproven");
			} else {
				outputLabel.setText("Permutation: A: " + A +", \nB: " + B + ", \nC: " + C + ", \nx: " + x + ", \ny: "+ y + ", \nz: " + z +
						"\nEquation: " + equation + "\nC^z: " + ctoZ + "\nOutput: not disproven");
			}
		}
	}
	
	private void upTo() {
		
	}
	
	private void check() {
		homePanel.setVisible(false);
		equation = (double)(Math.pow(A, x)) + (double)(Math.pow(B, y));
		if(equation == (double)(Math.pow(C, z))) {
			outputLabel.setText("Permutation: A: " + A +", B: " + B + ", C: " + C + ", x: " + x + ", y: "+ y + ", z: " + z +
					"\nOutput: disproven");
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		String word = e.getActionCommand();
		String selection = ((JComboBox) e.getSource()).getSelectedItem() + "";
		String loopSel = ((JComboBox) e.getSource()).getSelectedItem() + "";
		if(selection.equals("Random")) {
			random();
		} if(selection.equals("Up to")) {
			upTo();
		} if(selection.equals("Check")) {
			check();
		} if(loopSel.equals("Loop")) {
			loopBool = true;
			random();
		} if(loopSel.equals("Once")) {
			loopBool = false;
			random();
		}
		
	}

}
