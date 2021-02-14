import javax.swing.JOptionPane;


public class ArrayProgram
{
	//int array
	int [] arrayI = new int [9];
	public void setFillArray()
	{
		for(int i = 0; i <= 8; i++)
		{
			arrayI[i] = (int)(Math.random()*74)+10;
		}
	}
	
	public void setPrintArray()
	{
		String numbers = "";
		for(int i = 0; i < 9; i++)
		{
			numbers = numbers + " "+arrayI[i];
		}
		JOptionPane.showMessageDialog(null, numbers);
	}
	
}
