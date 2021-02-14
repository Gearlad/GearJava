import javax.swing.JOptionPane;

public class cesarCipher
{
	char[] letters;
	int[] ascII;
	int shift;
	String word;
	
	public void getWord()
	{
		word=JOptionPane.showInputDialog("Please enter in a word");
		word=word.toLowerCase();
		letters=new char[word.length()];
		ascII=new int[word.length()];
		for(int i=0;i<word.length();i++)
		{
			letters[i]=word.charAt(i);
			ascII[i]=(int)(letters[i]);
		}
	}
	public void getShift()
	{
		shift=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter shift amount"));
	}
	public String shift()
	{
		String newWord="";
		for(int i=0;i<word.length();i++)
		{
			String newLetter="";
			if(ascII[i]+shift<=122)
			{
				newLetter=(char)(ascII[i]+shift)+"";
			}
			else
			{
				int x=ascII[i]=shift-122;
				newLetter=(char)(96+x)+"";
			}
			newWord+=newLetter;
		}
		return newWord;
	}
}