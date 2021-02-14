import java.util.ArrayList;

import javax.swing.JOptionPane;


public class highlyDivisibleTriangle
{
	public void finder()
	{
		ArrayList<Integer> triangles=new ArrayList();
		//1,3,6,10,15
		triangles.add(1);
		int previousNumber=1;
		int currentAddition=2;
		int counter=0;
		int topFactorAmount=0,factorAmount=0;
		boolean found=false;
		while(found==false)
		{
			factorAmount=0;
			triangles.add(triangles.get(counter)+currentAddition);
			currentAddition++;
			counter++;
			for(int a=1;a<=triangles.get(counter);a++)
			{
				if(triangles.get(counter)%a==0)
				{
					factorAmount++;
		//			System.out.println("Triangle "+triangles.get(counter)+"'s factor amount is "+factorAmount+", and this factor is: "+a);
					if(factorAmount>=topFactorAmount)
					{
						topFactorAmount=factorAmount;
						System.out.println(topFactorAmount);
						if(topFactorAmount>500)
						{
							JOptionPane.showMessageDialog(null,"The triangle is: "+triangles.get(counter));
							System.exit(0);
						}
					}
				}
			}
		}
		
	}
}
