import java.util.Arrays;

import javax.swing.JOptionPane;


public class StudentArray 
{
	int rows;
	int columns;
	
	String finalArray[][];

	String studentAmountString;
	int studentAmount;
	
	int squareFinder;
	
	public void studentAmount()
	{
		studentAmountString = JOptionPane.showInputDialog(null, "How many students are in your class?");
		studentAmount = Integer.parseInt(studentAmountString);
	}
	
	public void deskLayout()
	{
		boolean run = true;
		
		while(run == true)
		{
			int counter = 0;
			int counterTwo = 0;
			squareFinder = (int) Math.sqrt(studentAmount);
			
			if(Math.pow(squareFinder, 2) == studentAmount)
			{
				finalArray = new String[squareFinder][squareFinder];
				
				for(int i = 0; i < squareFinder; i++)
				{
					for(int j = 0; j < squareFinder; j++)
					{
						counter++;
						finalArray[i][j] = JOptionPane.showInputDialog(null,"Student "+counter+" name?");
					}
				}
				
				for (String [] output: finalArray)
				{
		            System.out.println(Arrays.toString(output));
		            String exit = JOptionPane.showInputDialog(null,"Exit: 'yes' or 'no'");
		            if(exit.equalsIgnoreCase("yes"))
		            {
		            	System.exit(0);
		            }
		            
		            else if(exit.equalsIgnoreCase("no"))
		            {
		            	studentAmount();
		            }
		        }
			}
			
			else
			{
				JOptionPane.showMessageDialog(null,"Error: Number is not a perfect square");
				studentAmount();
			}
		}
	}
}
