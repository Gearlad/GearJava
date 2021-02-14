import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class baseConvert
{
	String number;
	int numberInt;
	String[] baseOptions = {"Base 2","Base 8","Base 10","Base 16"};
	String selectedBase;
	
	String[] baseConvert = {"Base 2","Base 8","Base 10","Base 16"};
	String selectedConvert;
	int originalBase;
	int switchBase;
	
	String[] array;
	int[] parseArray;
	
	int decimalInt=0;
	int[] baseValues;
	
	String output="";
	int[] binaryDigits;
	
	int decimalInteger=0;
	
	public void baseSelect()
	{	
		JComboBox<String> baseSelect = new JComboBox<>(baseOptions);
		JOptionPane.showMessageDialog(null,baseSelect,"Select base of entered number",1);
		selectedBase = (String)baseSelect.getSelectedItem();
		
		JComboBox<String> convertBase = new JComboBox<>(baseConvert);
		JOptionPane.showMessageDialog(null,convertBase,"Select base to convert to",1);
		selectedConvert = (String)convertBase.getSelectedItem();
		
		originalBase = Integer.parseInt(selectedBase.replaceAll("[^0-9]",""));
		switchBase = Integer.parseInt(selectedConvert.replaceAll("[^0-9]",""));
		
		number = JOptionPane.showInputDialog(null,"Enter number");
	}
	
	public void baseDetect()
	{
		String stringLength = number+"";
		int numLength = stringLength.length();
		if(originalBase!=16)
		{
			try
			{
				numberInt = Integer.parseInt(number);
			}
		
			catch(NumberFormatException e)
			{	
				JOptionPane.showMessageDialog(null,"Error: Invalid digit(s)");
				System.exit(0);
			}
		}
		
		else
		{
			for(int i=0; i<numLength; i++)
			{
				if(!(stringLength.substring(i,i+1).equals("A")||stringLength.substring(i,i+1).equals("B")||
						stringLength.substring(i,i+1).equals("C")||stringLength.substring(i,i+1).equals("D")||
						stringLength.substring(i,i+1).equals("E")||stringLength.substring(i,i+1).equals("F")||
						stringLength.substring(i,i+1).equals("0")||stringLength.substring(i,i+1).equals("1")||
						stringLength.substring(i,i+1).equals("2")||stringLength.substring(i,i+1).equals("3")||
						stringLength.substring(i,i+1).equals("4")||stringLength.substring(i,i+1).equals("5")||
						stringLength.substring(i,i+1).equals("6")||stringLength.substring(i,i+1).equals("7")||
						stringLength.substring(i,i+1).equals("8")||stringLength.substring(i,i+1).equals("9")))
				{
					JOptionPane.showMessageDialog(null,"Error: Invalid digit(s)");
					System.exit(0);
				}
			}
		}
		if(originalBase!=16)
		{
			ArrayList<Integer> a = new ArrayList();
			int largestNumber=0;
			
			for(int i=0; i<numLength; i++)
			{
				a.add(Integer.parseInt(stringLength.substring(i,i+1)));
			}
			
			Collections.sort(a);
			int b = a.get(a.size()-1);
			
			if(b>=originalBase)
			{
				JOptionPane.showMessageDialog(null,"Error: Impossible digit(s) for base of number");
				System.exit(0);
			}
		}
	}
	
	public void createArray()
	{
		array = new String[number.length()];
		parseArray = new int[number.length()];
		for(int i=0; i<number.length();i++)
		{
			array[i]=number.substring(i,i+1);
			System.out.println("spot "+i+": "+array[i]);
		}
		
		if(originalBase!=16)
		{
			for(int i=0; i<number.length(); i++)
			{
				parseArray[i]=Integer.parseInt(array[i]);
			}
		}
		
		else
		{
			for(int i=0; i<number.length(); i++)
			{
				switch(number.substring(i,i+1))
				{
				case "0":
					parseArray[i]=0;
					break;
				case "1":
					parseArray[i]=1;
					break;
				case "2":
					parseArray[i]=2;
					break;
				case "3":
					parseArray[i]=3;
					break;
				case "4":
					parseArray[i]=4;
					break;
				case "5":
					parseArray[i]=5;
					break;
				case "6":
					parseArray[i]=6;
					break;
				case "7":
					parseArray[i]=7;
					break;
				case "8":
					parseArray[i]=8;
					break;
				case "9":
					parseArray[i]=9;
					break;
				case "A":
					parseArray[i]=10;
					break;
				case "B":
					parseArray[i]=11;
					break;
				case "C":
					parseArray[i]=12;
					break;
				case "D":
					parseArray[i]=13;
					break;
				case "E":
					parseArray[i]=14;
					break;
				case "F":
					parseArray[i]=15;
					break;
				}
			}
		}
	}
	
	public void convertDecimal()
	{
		int counter=1;
		for(int i=number.length()-1;i>=0;i--)
		{
			decimalInt+=(parseArray[i]*counter);
			counter*=originalBase;
		}
		decimalInteger=decimalInt;
	}
	
	public void convertBase()
	{
		String output="";
		int digitAmount=0;
		int topAmount=1;
		int binaryBase=2;
		//variable amount
		int decimalAmount=decimalInt;
		
		switch(binaryBase)
		{
		case 2:
			while(topAmount<decimalAmount)
			{
				digitAmount++;
				topAmount*=2;
				
				if(topAmount>decimalAmount)
				{
					topAmount/=2;
					break;
				}
			}
			binaryDigits = new int[digitAmount];
			System.out.println("Decimal: "+decimalAmount);
			System.out.println("Top Amount: "+topAmount);
			for(int i=digitAmount-1;i>=0; i--)
			{
				if(decimalAmount<topAmount)
				{
					binaryDigits[i]=0;
					topAmount/=2;
				}
				else if(decimalAmount>=topAmount)
				{
					binaryDigits[i]=1;
					decimalAmount-=topAmount;
					topAmount/=2;
				}
			}
			for(int i=binaryDigits.length-1;i>=0;i--)
			{
				output+=binaryDigits[i]+"";
			}
			if(switchBase==2)
			{
				JOptionPane.showMessageDialog(null,"Base "+switchBase+": "+output);
			}
			else
			{
				binaryBase=switchBase;
			}
		case 8:
			int[][] binaryGroups;
			if(binaryDigits.length%3==0)
			{
				binaryGroups=new int[3][(binaryDigits.length/3)];
			}
			else
			{
				binaryGroups=new int[3][((binaryDigits.length/3)+1)];
			}
			for(int i=0; i<binaryDigits.length; i+=3)
			{
				for(int a=i;a<i+3;a++)
				{
					binaryGroups[i][a]=binaryDigits[a];
					System.out.println(binaryDigits[a]);
				}
			}
			JOptionPane.showMessageDialog(null,"Base "+switchBase+": "+Integer.toOctalString(decimalInt));
			break;
		case 10:
			output=decimalInt+"";
			JOptionPane.showMessageDialog(null,output);
			break;
		case 16:
			System.out.println(decimalInt);
			JOptionPane.showMessageDialog(null,"Base "+switchBase+": "+Integer.toHexString(decimalInt));
			break;
		}
	}
}