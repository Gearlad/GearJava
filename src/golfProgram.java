import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class golfProgram extends JFrame implements ActionListener {
	JLabel name;
	JLabel ace;
	JLabel onGreen;
	JLabel makePutt;
	JLabel list;
	JLabel hole;
	JLabel listUI;
	JTextField nameI,aceI,onGreenI,makePuttI,holeI;
	String counter="";
	JButton shot,nextHole;
	int holeNo=1;
	String holesI="";
	int stage=0;
	public static void main(String [] args) {
		golfProgram obj=new golfProgram();
		obj.setVisible(true);
	}
	public golfProgram() {
		setSize(800,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("Golf Program");
		JPanel westPanel=new JPanel();
			name=new JLabel("Name: ");
			westPanel.add(name);
			nameI=new JTextField("",5);
			westPanel.add(nameI);
			ace=new JLabel("Ace: ");
			westPanel.add(ace);
			aceI=new JTextField("",5);
			westPanel.add(aceI);
			onGreen = new JLabel("OnGreen");
			westPanel.add(onGreen);
			onGreenI=new JTextField("",5);
			westPanel.add(onGreenI);
			makePutt=new JLabel("makePutt: ");
			westPanel.add(makePutt);
			makePuttI=new JTextField("",5);
			westPanel.add(makePuttI);
			list=new JLabel("List: ");
			westPanel.add(list);
			listUI=new JLabel("");
			westPanel.add(listUI);
			hole=new JLabel("; Hole: ");
			westPanel.add(hole);
			add(westPanel,BorderLayout.WEST);
		JPanel southPanel=new JPanel();
			shot=new JButton("Run simulation");
			southPanel.add(shot);
			shot.addActionListener(this);
			nextHole=new JButton("Next hole");
			southPanel.add(nextHole);
			nextHole.addActionListener(this);
			add(southPanel,BorderLayout.SOUTH);
	}
	public void actionPerformed(ActionEvent e) {
		String word=e.getActionCommand();
		if(word.equals("Run simulation")) {
			runSimulation();
		} else if(word.equals("Next hole")) {
			holesI+=", "+holeNo+"/"+stage;
			hole.setText("; Hole: "+holesI);
			holeNo++;
			stage=0;
		}
	}
	private void runSimulation() {
		double aceP,onGreenP,makePuttP;
		boolean hole=false;
		aceP=(Double.parseDouble(aceI.getText()))*100;
		onGreenP=(Double.parseDouble(onGreenI.getText()))*100;
		makePuttP=(Double.parseDouble(makePuttI.getText()))*100;
		for(;;) {
			int random=(int)(Math.random()*100)+1;
			if((stage+1)>1) {
				if(aceP>=random) {
					counter+=", ace";
					stage++;
					break;
				}
			} if(onGreenP>=random) {
				counter+=", onGreen";
				stage++;
				if(makePuttP>=random) {
					counter+=", hole";
					stage++;
					break;
				} else {
					counter+=", putt";
					stage++;
				}
			} else {
				counter+=", hit";
				stage++;
			}
		}
		listUI.setText(counter);
		counter+=" | ";
	}
}
