
public class viginereCipher_driver
{
	static boolean decrypt=false;
	public static void main(String[] args)
	{
		viginereCipher object=new viginereCipher();
		object.input();
		object.rotation();
		object.getShift();
		object.shift();
	}
}
