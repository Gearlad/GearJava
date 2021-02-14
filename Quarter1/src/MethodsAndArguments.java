import java.util.Scanner;


public class MethodsAndArguments {
	Scanner kb = new Scanner(System.in);
	int birth;
	public void printOut() {
		System.out.println("Tall people make more money");
	}
	
	public void kevin() {
		System.out.println("Where is sean");
	}
	
	public void chair() {
		System.out.println("I wish I was a table!");
	}
	
	public void age() {
		System.out.println("How old are you");
		birth = kb.nextInt();
	}
	
	public void schoolMessage()
	{
		System.out.println("You must leave high school");
	}
	
	public void printOutAge() {
		System.out.println("Your age is "+birth);
		if(birth>=20){
			schoolMessage();
		}
	}
	
	public String setName() {
		System.out.println("What is your name?");
		String name = kb.next();
		return name;
	}
}
