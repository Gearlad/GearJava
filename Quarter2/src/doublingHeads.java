import javax.swing.JOptionPane;


public class doublingHeads
{
	int betAmount;
	int trialAmount;
	int moneyOwed=0;
	int casinoProfit;
	public void bet() {
		betAmount=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter entrance fee"));
	}
	public void trials() {
		trialAmount=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter amount of trials"));
	}
	public void simulate() {
		boolean heads=false;
		for(int i=0;i<trialAmount;i++)
		{
			heads=false;
			int temp=1;
			while(heads==false)
			{
				temp*=2;
				int random=(int)(Math.random()*2);
				if(random==1){
					moneyOwed+=temp;
					System.out.println(temp);
					casinoProfit+=(temp-betAmount);
					heads=true;
					break;
				}
			}
		}
	}
	public void average() {
		/*JOptionPane.showMessageDialog(null,"Money owed from casino: "+moneyOwed+", Money paid by user: "+(betAmount*trialAmount));*/
		JOptionPane.showMessageDialog(null,"Casino's Profit: "+casinoProfit+", Average profit per trial: "+(casinoProfit/trialAmount));
	}
}
