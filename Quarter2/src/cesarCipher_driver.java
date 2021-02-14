import javax.swing.JOptionPane;


public class cesarCipher_driver
{
	public static void main(String[] args)
	{
		 cesarCipher obj=new cesarCipher();
			 obj.getWord();
			 obj.getShift();
		 JOptionPane.showMessageDialog(null,"The code message is: "+obj.shift());
	}
}