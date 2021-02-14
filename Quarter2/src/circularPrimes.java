import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class circularPrimes
{
	PrintWriter outputStream;
	int primeCounter=0,previousTop=0,previousNumber=0,counter=0,circularPrimes=0,savePrior=0;
	int[] array=new int[78498];
	String[][] chars;
	boolean prime=true;
	ArrayList<Integer> primes = new ArrayList();
	public void findPrime()
	{
		try{
		outputStream=new PrintWriter(new FileOutputStream("primeNumbers"));
		}
		catch(FileNotFoundException e)
		{
			System.exit(0);
		}
		//if no numbers other than 1 and itself have no remainder, then it is prime
		for(int a=1;a<1000000;a+=2)
		{
			prime=true;
			for(int b=2;b<a;b++)
			{
				if(a%b==0)
				{
					prime=false;
					break;
				}
			}
			if(prime)
			{
				primes.add(a);
				if(a==100000)
				{
					System.out.println(a);
				}
				outputStream.println(a+"");
			}
		}
	}
	public void findCircularPrime()
	{
		Scanner inputStream=null;
		try
		{
			inputStream=new Scanner(new FileInputStream("primeNumbers.txt"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("file not found");
			System.exit(0);
		}
		for(int i=0;i<array.length;i++)
		{
			array[i]=inputStream.nextInt();
		}
		inputStream.close();
		String[][] chars=new String[array.length][6];
		//find number of digits, loop through all possible combinations, find if all combinations are equal to any prime numbers in array
		int combinationCounter=0;
		//checking each number
		for(int i=0;i<array.length;i++)
		{
			int digitCounter=0;
			for(int b=0;b<6;b++)
			{
				try
				{
					chars[i][b]=Integer.toString(array[i]).substring(b,b+1);
					digitCounter++;
				}
				catch(StringIndexOutOfBoundsException e)
				{
					chars[i][b]=null;
				}
			}
			digitCounter=0;
			for(int j=0;j<6;j++)
			{
				if(chars[i][j]==null)
				{
					break;
				}
				digitCounter++;
			}
			//save all number values in combination
			String saveFinal="";
			//saves all last numbers to put to first part
			String saveLast="";
			//checking each combination
			for(int combinations=0;combinations<digitCounter;combinations++)
			{
				//System.out.println("Digits: "+digitCounter+", Number: "+i+", Combination: "+combinations);
				switch(digitCounter)
				{
				case 1:
					saveFinal=chars[i][0];
				case 2:
					saveLast=chars[i][1];
					chars[i][1]=chars[i][0];
					chars[i][0]=saveLast;
					saveFinal=chars[i][0]+chars[i][1];
				case 3:
					saveLast=chars[i][2];
					chars[i][2]=chars[i][1];
					chars[i][1]=chars[i][0];
					chars[i][0]=saveLast;
					saveFinal=chars[i][0]+chars[i][1]+chars[i][2];
				case 4:
					saveLast=chars[i][3];
					chars[i][3]=chars[i][2];
					chars[i][2]=chars[i][1];
					chars[i][1]=chars[i][0];
					chars[i][0]=saveLast;
					saveFinal=chars[i][0]+chars[i][1]+chars[i][2]+chars[i][3];
				case 5:
					saveLast=chars[i][4];
					chars[i][4]=chars[i][3];
					chars[i][3]=chars[i][2];
					chars[i][2]=chars[i][1];
					chars[i][1]=chars[i][0];
					chars[i][0]=saveLast;
					saveFinal=chars[i][0]+chars[i][1]+chars[i][2]+chars[i][3]+chars[i][4];
				case 6:
					//last spot must equal first spot, all other spots move up 1
					//815022; 281502
					//[0][1][2][3][4][5]
					//[5][0][1][2][3][4]
					saveLast=chars[i][5];
					chars[i][5]=chars[i][4];
					//815022
					chars[i][4]=chars[i][3];
					//815002
					chars[i][3]=chars[i][2];
					//815502
					chars[i][2]=chars[i][1];
					//811502
					chars[i][1]=chars[i][0];
					//881502
					chars[i][0]=saveLast;
					//281502
					saveFinal=chars[i][0]+chars[i][1]+chars[i][2]+chars[i][3]+chars[i][4]+chars[i][5];
				}
				String fixSaveFinal=saveFinal.replaceAll("null","");
				int parseSave=Integer.parseInt(fixSaveFinal);
				combinationCounter=1;
				
				for(int e=0;e<78498;e++)
				{
					if(parseSave==array[e])
					{
						combinationCounter++;
						if(combinationCounter==digitCounter&&savePrior!=parseSave)
						{
							circularPrimes++;
							System.out.println(parseSave);
						}
					}
				}
				savePrior=parseSave;
			}
		}
		JOptionPane.showMessageDialog(null,"Output: "+circularPrimes);
	}
}
