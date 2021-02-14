import java.util.Scanner;

import javax.swing.JOptionPane;

public class gcf
{
	Scanner kb = new Scanner(System.in);
	
	int oneParse;
	int twoParse;
	
	int gcf;
	
	public void setValues()
	{
		String one = JOptionPane.showInputDialog(null,"Enter Value One");
		oneParse = Integer.parseInt(one);
		String two = JOptionPane.showInputDialog(null,"Enter Value Two");
		twoParse = Integer.parseInt(two);
		
		if(oneParse==0||twoParse==0)
		{
			JOptionPane.showMessageDialog(null,"Error: Number(s) must be larger than 0");
			System.exit(0);
		}
	}

	
	public void setGcf()
	{
			/*int gcf = (Math.max(oneParse, twoParse) - Math.min(oneParse, twoParse));
			System.out.println(gcf+" ");*/
		
		System.out.println(Math.max(oneParse,twoParse)+" ");
		
		boolean status = true;
		
		if(oneParse>twoParse)
		{
			for(int i = oneParse; i>0 && status; i--)
			{
				if(twoParse%i==0&&oneParse%i==0)
				{
					System.out.println(i+" is the GCF");
					status=false;
				}
			}
		}
		
		else if(oneParse<twoParse)
		{
			for(int i = twoParse; i > 0&&status; i--)
			{
				if(twoParse%i==0&&oneParse%i==0)
				{
					System.out.println(i+" is the GCF");
					status=false;
				}
			}
		}
	}	
}
