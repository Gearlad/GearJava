
public class MethodsAndArgumentsDriver {
	public static void main(String [] args) {
		System.out.println("This is where we start.");
		MethodsAndArguments objectA = new MethodsAndArguments();
		objectA.printOut();
		objectA.kevin();
		objectA.age();
		objectA.printOutAge();
		objectA.setName();
		String name = objectA.setName();
		System.out.println("Your name is " + name + ".");
		
		MethodsAndArguments objectB = new MethodsAndArguments();
		objectB.chair();
		objectB.kevin();
		objectB.printOutAge();
		System.out.println("Your name is "+objectB.setName());
		
	}
}
