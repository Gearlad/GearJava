
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class midterm extends JFrame implements ActionListener {
	String pitchTypeString;
	JButton pitch;
	int outputCounter=0;
	int singleCounter=0;
	int single2Counter=0;
	int batterCounter=2;
	int strikeCounter=0;
	JLabel a;
	
	JLabel pitcherName;
	JTextField pitcherNameField;
	JLabel fastBall;
	JTextField fastBallField;
	JLabel strike;
	JTextField strikeField;
	JLabel hit;
	JTextField hitField;
	JLabel curveBall;
	JTextField curveBallField;
	JLabel strike2;
	JTextField strike2Field;
	JLabel hit2;
	JTextField hit2Field;
	JLabel sliderBall;
	JTextField sliderBallField;
	JLabel strike3;
	JTextField strike3Field;
	JLabel hit3;
	JTextField hit3Field;
	
	JLabel batterName;
	JTextField batterNameField;
	JLabel single;
	JTextField singleField;
	JLabel homerun;
	JTextField homerunField;
	JLabel popout;
	JTextField popoutField;
	
	JLabel batterName2;
	JTextField batterName2Field;
	JLabel single2;
	JTextField single2Field;
	JLabel homerun2;
	JTextField homerun2Field;
	JLabel popout2;
	JTextField popout2Field;
	
	JLabel output;
	JLabel score;
	
	String outputString="";
	
	int team1Score=0;
	int team2Score=0;
	public static void main(String[] args) {
		midterm obj=new midterm();
		obj.setVisible(true);
	}
	public midterm() {
		setTitle("Midterm");
		setSize(1280,720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(20,20));
			pitcherName=new JLabel("Pitcher Name: ");
			add(pitcherName);
			pitcherNameField=new JTextField("Seth");
			add(pitcherNameField);
			fastBall=new JLabel("Fast Ball: ");
			add(fastBall);
			fastBallField=new JTextField("10");
			add(fastBallField);
			strike=new JLabel("Strike: ");
			add(strike);
			strikeField=new JTextField("20");
			add(strikeField);
			hit=new JLabel("Hit: ");
			add(hit);
			hitField=new JTextField("80");
			add(hitField);
			curveBall=new JLabel("Curve Ball: ");
			add(curveBall);
			curveBallField=new JTextField("40");
			add(curveBallField);
			strike2=new JLabel("Strike: ");
			add(strike2);
			strike2Field=new JTextField("30");
			add(strike2Field);
			hit2=new JLabel("Hit: ");
			add(hit2);
			hit2Field=new JTextField("70");
			add(hit2Field);
			sliderBall=new JLabel("Slider: ");
			add(sliderBall);
			sliderBallField=new JTextField("50");
			add(sliderBallField);
			strike3=new JLabel("Strike: ");
			add(strike3);
			strike3Field=new JTextField("80");
			add(strike3Field);
			hit3=new JLabel("Hit: ");
			add(hit3);
			hit3Field=new JTextField("20");
			add(hit3Field);
			pitch=new JButton("Pitch");
			pitch.addActionListener(this);
			add(pitch);
			
			a=new JLabel("");
			add(a);
			batterName=new JLabel("Batter Name: ");
			add(batterName);
			batterNameField=new JTextField("Snyder");
			add(batterNameField);
			single=new JLabel("Single: ");
			add(single);
			singleField=new JTextField("30");
			add(singleField);
			homerun=new JLabel("Homerun: ");
			add(homerun);
			homerunField=new JTextField("30");
			add(homerunField);
			popout=new JLabel("Popout: ");
			add(popout);
			popoutField=new JTextField("40");
			add(popoutField);
			batterName2=new JLabel("Batter Name: ");
			add(batterName2);
			batterName2Field=new JTextField("Gabe");
			add(batterName2Field);
			single2=new JLabel("Single: ");
			add(single2);
			single2Field=new JTextField("10");
			add(single2Field);
			homerun2=new JLabel("Homerun: ");
			add(homerun2);
			homerun2Field=new JTextField("15");
			add(homerun2Field);
			popout2=new JLabel("Popout: ");
			add(popout2);
			popout2Field=new JTextField("75");
			add(popout2Field);
			output=new JLabel("Output: "+output);
			add(output);
			score=new JLabel("Team 1: "+team1Score+", Team 2: "+team2Score);
			add(score);
	}
	public void exit() {
		System.exit(0);
	}
	public void pitch() {
		boolean fastBall=false;
		batterCounter++;
		String batter;
		if(batterCounter%2==0) {
			batter=batterNameField.getText();
		}
		else {
			batter=batterName2Field.getText();
		}
		int pitchType=(int)(Math.random()*100)+1;
		int fastBallProbability=(Integer.parseInt(fastBallField.getText()));
		int curveBallProbability=(Integer.parseInt(curveBallField.getText()))+fastBallProbability;
		int sliderBallProbability=(Integer.parseInt(sliderBallField.getText()))+curveBallProbability;
		
		if(pitchType<=fastBallProbability) {
			pitchTypeString="fastBall";
			fastBall=true;
		}
		else if(fastBall==false&&pitchType<curveBallProbability) {
			pitchTypeString="curveBall";
		}
		else {
			pitchTypeString="sliderBall";
		}
		outputCounter++;
		if(outputCounter>4) {
			outputCounter=0;
			outputString="";
		}
		
		//pitcher stuff
		boolean hit=false;
		if(pitchTypeString.equals("fastBall")) {
			int random=(int)(Math.random()*100)+1;
			int strikeProbability=Integer.parseInt(strikeField.getText());
			if(strikeProbability>random) {
				outputString+=", strike";
				strikeCounter++;
				if(strikeCounter>=3) {
					outputString+=", "+batter+" out";
					strikeCounter=0;
				}
			}
			else {
				outputString+=", "+batter+" hit";
				hit=true;
			}
		}
		else if(pitchTypeString.equals("curveBall")) {
			int random=(int)(Math.random()*100)+1;
			int strikeProbability=Integer.parseInt(strike2Field.getText());
			if(strikeProbability>random) {
				outputString+=", "+batter+" strike";
				strikeCounter++;
				if(strikeCounter>=3) {
					strikeCounter=0;
					outputString+=", "+batter+" out";
				}
			}
			else {
				outputString+=", "+batter+" hit";
				hit=true;
			}
		}
		else {
			int random=(int)(Math.random()*100)+1;
			int strikeProbability=Integer.parseInt(strike3Field.getText());
			if(strikeProbability>random) {
				outputString+=", "+batter+" strike";
				strikeCounter++;
				if(strikeCounter>=3) {
					strikeCounter=0;
					outputString+=", "+batter+" out";
				}
			}
			else {
				outputString+=", "+batter+" hit";
				hit=true;
			}
		}
		
		//batter stuff
		if(hit==true) {
			int hitType=(int)(Math.random()*100)+1;
			if(batter.equals(batterName.getText())) {
				//first batter
				int singleProbability=Integer.parseInt(singleField.getText());
				int homerunProbability=Integer.parseInt(homerunField.getText())+singleProbability;
				int popoutProbability=Integer.parseInt(popoutField.getText())+homerunProbability;
				if(hitType<singleProbability) {
					outputString+=", "+batter+" single";
					singleCounter++;
					if(singleCounter>3) {
						team1Score++;
						singleCounter=0;
						outputString+=", "+batter+" score";
					}
				}
				else if(hitType>singleProbability&&hitType<homerunProbability){
					outputString+=", "+batter+" homerun";
					team1Score++;
				}
				else {
					outputString+=", "+batter+" popout";
				}
			}
			else {
				//second batter
				int singleProbability=Integer.parseInt(single2Field.getText());
				int homerunProbability=Integer.parseInt(homerun2Field.getText())+singleProbability;
				int popoutProbability=Integer.parseInt(popout2Field.getText())+homerunProbability;
				if(hitType<singleProbability) {
					outputString+=", "+batter+" single";
					single2Counter++;
					if(single2Counter>3) {
						team2Score++;
						single2Counter=0;
						outputString+=", "+batter+" score";
					}
				}
				else if(hitType>singleProbability&&hitType<homerunProbability){
					outputString+=", "+batter+" homerun";
					team2Score++;
				}
				else {
					outputString+=", "+batter+" popout";
				}
			}
		}
		score.setText("Team 1: "+team1Score+", Team 2: "+team2Score);
		output.setText(outputString);
	}
	public void actionPerformed(ActionEvent e) {
		String word=e.getActionCommand();
		if(word.equals("Exit")) {
			exit();
		}
		else if(word.equals("Pitch")) {
			pitch();
		}
	}
}