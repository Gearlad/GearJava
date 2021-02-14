import javax.swing.JOptionPane;


public class studentGrades 
{	
	String peopleAmountString;
	int peopleAmount;
	String[] peopleNames;
	
	String testAmountString;
	int testAmount;
	
	String [][] finalArray;
	
	
	public void setPeopleAmount()
	{
		peopleAmountString = JOptionPane.showInputDialog(null, "How many people?");
		peopleAmount = Integer.parseInt(peopleAmountString);
		peopleNames = new String [peopleAmount];
	}
	
	public void setPeopleNames()
	{
		for(int a = 0; a < peopleAmount; a++)
		{
			if(a <= peopleAmount)
			{
				peopleNames[a] = JOptionPane.showInputDialog(null,"Name "+(a+1)+" ?");
			}
			
			else if(a > peopleAmount)
			{
				break;
			}
		}
	}
	
	public void setTestAmount()
	{
		testAmountString = JOptionPane.showInputDialog(null, "How many tests?");
		testAmount = Integer.parseInt(testAmountString);
		finalArray = new String[peopleAmount][testAmount];
	}
	
	public void setGrades()
	{
		for(int i = 0; i < peopleAmount; i++)
		{
			
			for(int j = 0; j < testAmount; j++)
			{
				finalArray[i][j] = JOptionPane.showInputDialog(null,peopleNames[i]+"'s test "+(j+1)+" amount?");
			}
		}
		
	}
	
	public void finder()
	{
		int average = 0;
		
		while(true)
		{
			String option = JOptionPane.showInputDialog(null,"Enter: 't' for a test search; 'a' for an average search; 'e' to exit ");
			
			if(option.equalsIgnoreCase("t"))
			{
				String who = JOptionPane.showInputDialog(null,"Enter name of person");
				
				for(int i = 0; i < peopleAmount; i++)
				{
					if(who.equals(peopleNames[i]))
					{
						String test = JOptionPane.showInputDialog("Enter test number");
						int testNumber = Integer.parseInt(test);
						JOptionPane.showMessageDialog(null,finalArray[i][testNumber-1]+"");
						break;
					}
				}
			}
			
			else if(option.equalsIgnoreCase("a"))
			{
				String who = JOptionPane.showInputDialog(null,"Enter name of person");
				
				for(int i = 0; i < peopleAmount; i++)
				{
					if(who.equals(peopleNames[i]))
					{
						for(int j = 0; j < testAmount; j++)
						{
							average = average + Integer.parseInt(finalArray[i][j]);
						}
						
						average = average / testAmount;
						JOptionPane.showMessageDialog(null,"Average: "+average);
					}
				}
				average = 0;
			}
			
			else if(option.equalsIgnoreCase("e"))
			{
				System.exit(0);
			}
		}		
	}

}
