import javax.swing.JOptionPane;
public class pythagoreanTriplet
{
	public void altFinder()
	{
		for(int a=1;a<1000;a++)
		{
			for(int b=a;b<1000;b++)
			{
				int cSquared=(int)(Math.pow(a,2)+Math.pow(b,2));
				double cDouble=Math.sqrt(cSquared);
				int cInt=(int)Math.ceil(cDouble);
				if(cDouble==cInt)
				{
					System.out.println(a+" "+b+" "+cInt);
					if((a+b+cInt)==1000)
					{
						int product=a*b*cInt;
						JOptionPane.showMessageDialog(null,"Output: "+product);
						System.exit(0);
					}
				}
			}
		}
		System.exit(0);
	}
}