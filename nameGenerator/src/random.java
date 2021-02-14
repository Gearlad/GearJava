
public class random {
	int largest = 0;
	int save = 0;
	public static void main(String [] args) {
		for(int i = 0; i < 100000; i++) {
			int random = (int)(Math.random()*2);
			System.out.println(random);
		}
	}
}
