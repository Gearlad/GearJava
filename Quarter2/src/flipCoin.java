import javax.swing.JOptionPane;


public class flipCoin {
	double value;
	int trials;
	int tails;
	int heads;
	public flipCoin(double A) {
		value=A;
	}
	public void fairness() {
		String answer=JOptionPane.showInputDialog(null,"Is the coin fair?");
		if(answer.equalsIgnoreCase("no"))
		{
			getValue();
		}
	}
	public void getValue() {
		value=Double.parseDouble(JOptionPane.showInputDialog(null,"Decimal of tails?"));
	}
	public void trials() {
		trials=Integer.parseInt(JOptionPane.showInputDialog(null,"Amount run"));
	}
	public void flip() {
		for(int i=0;i<trials;i++) {
			double x=Math.random();
			if(x<=value) {
				tails+=1;
			}
			else if(x>=value)
			{
				heads+=1;
			}
		}
	}
	public void output() {
		JOptionPane.showMessageDialog(null,"Heads: "+heads+", Tails: "+tails+", Trials: "+trials);
	}
}
