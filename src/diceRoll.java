import javax.swing.JOptionPane;


public class diceRoll
{
	public void gui()
	{
		for(;;)
		{
			int input=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter dice no. to roll\n"
					+ "Accepted values: 4,6,8,10,12,20"));
			if(input!=4&&input!=6&&input!=8&&input!=10&&input!=12&&input!=12&&input!=20)
			{
				JOptionPane.showMessageDialog(null,"Enter valid number");
				gui();
			}
			int random=(int)(Math.random()*input)+1;
			JOptionPane.showInputDialog(null,random);
		}
	}
}
