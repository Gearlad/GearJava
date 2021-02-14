import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.TableModel;


public class demographics extends JFrame implements ActionListener
{
	JLabel output;
	JButton calculateButton;
	JButton newDemographics;
	JTextField positive;
	JTextField negative;
	JLabel people;
	JButton clear;
	JButton exit;
	JTextField positiveCorrect;
	JTextField negativeCorrect;
	public static void main(String [] args)
	{
		demographics obj=new demographics();
		obj.setVisible(true);
	}
	public demographics()
	{
		super("Demographics");
		setSize(1200,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel westPanel=new JPanel();
			westPanel.setBackground(Color.GREEN);
			people=new JLabel("3160 positive; 12 negative");
			westPanel.add(people);
			add(westPanel,BorderLayout.WEST);
		JPanel northPanel=new JPanel();
			northPanel.setBackground(Color.GRAY);
			positive=new JTextField("Enter no. positive",10);
			northPanel.add(positive);
			negative=new JTextField("Enter no. negative",10);
			northPanel.add(negative);
			newDemographics=new JButton("Enter new demographics");
			northPanel.add(newDemographics);
			newDemographics.addActionListener(this);
			add(northPanel,BorderLayout.NORTH);
		JPanel centrePanel=new JPanel();
			centrePanel.setBackground(Color.LIGHT_GRAY);
			calculateButton=new JButton("Calculate");
			centrePanel.add(calculateButton);
			calculateButton.addActionListener(this);
			output=new JLabel("<html>Num positive, correct: , <br>Num Positive, incorrect: ,"
					+ " <br>Num Negative, correct: , <br>Num Negative, incorrect: </html>");
			centrePanel.add(output);
			add(centrePanel,BorderLayout.CENTER);
		JPanel southPanel=new JPanel();
			southPanel.setBackground(Color.GRAY);
			exit=new JButton("Exit");
			exit.addActionListener(this);
			southPanel.add(exit);
			clear=new JButton("Clear");
			clear.addActionListener(this);
			southPanel.add(clear);
			add(southPanel,BorderLayout.SOUTH);
		JPanel eastPanel=new JPanel();
			eastPanel.setBackground(Color.LIGHT_GRAY);
			positiveCorrect=new JTextField("Enter decimal rate of positive, correct",20);
			eastPanel.add(positiveCorrect);
			negativeCorrect=new JTextField("Enter decimal rate of negative, correct",20);
			eastPanel.add(negativeCorrect);
			add(eastPanel,BorderLayout.EAST);
	}
	public void calculate()
	{
		output.setText("Test");
		int numPositive=3160;
		int numNegative=12;
		try
		{
			numPositive=Integer.parseInt(positive.getText());
			numNegative=Integer.parseInt(negative.getText());
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null,"Error: Enter numbers");
		}
		int numPositiveCorrect=0;
		int numPositiveIncorrect=0;
		int numNegativeCorrect=0;
		int numNegativeIncorrect=0;
		double posCorrectParse=Double.parseDouble(positiveCorrect.getText());
		int posCorrect=(int)(posCorrectParse*100);
		double negCorrectParse=Double.parseDouble(negativeCorrect.getText());
		int negCorrect=(int)(negCorrectParse*100);
		for(int i=0;i<numPositive;i++)
		{
			int random=(int)(Math.random()*100)+1;
			if(random>posCorrect)
			{
				numPositiveIncorrect++;
			}
		}
		numPositiveCorrect=numPositive-numPositiveIncorrect;
		for(int i=0;i<numNegative;i++)
		{
			int random=(int)(Math.random()*100)+1;
			if(random>negCorrect)
			{
				numNegativeIncorrect++;
			}
		}
		numNegativeCorrect=numNegative-numNegativeIncorrect;
		output.setText("<html>Num positive, correct: "+numPositiveCorrect+
				", <br>Num Positive, incorrect: "+numPositiveIncorrect+", <br>Num Negative, correct: "
				+ numNegativeCorrect+", <br>Num Negative, incorrect: "+numNegativeIncorrect+"</html>");
	}
	public void getText()
	{
		int a=Integer.parseInt(positive.getText());
		int b=Integer.parseInt(negative.getText());
		people.setText(a+" positive; "+b+" negative");
	}
	public void clear()
	{
		positive.setText("");
		negative.setText("");
		positiveCorrect.setText("");
		negativeCorrect.setText("");
	}
	public void exit()
	{
		System.exit(0);
	}
	public void actionPerformed(ActionEvent e)
	{
		String action=e.getActionCommand();
		if(action.equals("Calculate"))
		{
			calculate();
		}
		else if(action.equals("Enter new demographics"))
		{
			getText();
		}
		else if(action.equals("Clear"))
		{
			clear();
		}
		else if(action.equals("Exit"))
		{
			exit();
		}
	}
}