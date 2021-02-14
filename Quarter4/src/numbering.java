import java.util.Scanner;


public class numbering {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter amount to go to");
		int a = kb.nextInt();
		for(int i = 1; i <= a; i++) {
			System.out.println(i+". ");
		}
	}
}