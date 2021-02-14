import javax.swing.JOptionPane;


public class probability {
	double box1Percent;
	int amtRedMarblesBox1,amtGreenMarblesBox1,amtGreenMarblesBox2,amtBlueMarblesBox2,amountSimul,red=0,green=0,blue=0,totalCount;
	public void getProbBox() {
		box1Percent=Double.parseDouble(JOptionPane.showInputDialog(null,"Enter probability [.0-1.0] of selecting box 1"));
	}
	public void getAmtMarblesBox1() {
		amtRedMarblesBox1=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter amount of red marbles in box 1"));
		amtGreenMarblesBox1=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter amount of green marbles in box 1"));
		System.out.println(amtRedMarblesBox1+" "+amtGreenMarblesBox1);
	}
	public void getAmtMarblesBox2() {
		amtGreenMarblesBox2=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter amount of green marbles in box 2"));
		amtBlueMarblesBox2=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter amount of blue marbles in box 2"));
		System.out.println(amtGreenMarblesBox2+" "+amtBlueMarblesBox2);
	}
	public void getNumberOfSimul() {
		amountSimul=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter amount of simulations"));
	}
	public void getSimulStats() {
		for(int i=0;i<amountSimul;i++)
		{
			int arbitrary=(int)(Math.random()*100)+1;
			double arbitraryDouble=(arbitrary+0.0)/(100.0);
			if(arbitraryDouble<=box1Percent) {
				//box 1 selected
				red+=amtRedMarblesBox1;
				green+=amtGreenMarblesBox1;
			}
			else {
				//box 2 selected
				green+=amtGreenMarblesBox2;
				blue+=amtBlueMarblesBox2;
			}
		}
		System.out.println(red+" "+green+" "+blue);
		totalCount=red+green+blue;
		double redProbability=(red+0.0)/(totalCount+0.0);
		double greenProbability=(green+0.0)/(totalCount+0.0);
		double blueProbability=(blue+0.0)/(totalCount+0.0);
		JOptionPane.showMessageDialog(null,"Red Probability: "+redProbability+", amount: "+red
				+"\nGreen Probability: "+greenProbability+", amount: "+green
				+"\nBlue Probability: "+blueProbability+", amount: "+blue);
	}
}