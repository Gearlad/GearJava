import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class masterMind {
	
	static ArrayList<String> arrayCorrect;
	String [] array;
	
	public static void main(String[] args) {
		masterMind obj = new masterMind();
		obj.func();
	}
	
	public void func() {
		Scanner scannator = new Scanner(System.in);
		System.out.println("Welcome to mastermind.\nThere are six colours to choose; only four are correct.\nThe colours must"
				+ " be entered in the correct order.\nColours: red, green, blue, yellow, brown, grey\n"
				+ "Keep in mind that you cannot repeat colours in this program!");
		arrayCorrect = new ArrayList();
		String [] array2 = {"red","green","blue","yellow","brown","grey"};
		
		for(int i = 0; i < 6; i++) {
			arrayCorrect.add(array2[i]);
		}
		
		for(int i = 0; i < 2; i++) {
			int random = (int)(Math.random()*arrayCorrect.size());
			arrayCorrect.remove(random);
		}
		
		Collections.shuffle(arrayCorrect);
		System.out.println(arrayCorrect.toString());
		
		System.out.println("'robot' or 'human'?");
		String input = scannator.next();
		
		if(input.equals("robot")) {
			System.out.println("Method to solve? [random, smart, smarter]");
			String input2 = scannator.next();
			System.out.println("Beginning!");
			masterMindRobot obj2 = new masterMindRobot();
			if(input2.equals("random")) {
				obj2.solveRandom();
			} else if(input2.equals("smart")) {
				obj2.solveSmart();
			} else {
				obj2.solveSmarter();
			}
		}
		
		else {
			System.out.println("Begin!");
			for(;;) { 
				array = new String[4];
				for(int i = 0; i < 4; i++) {
					array[i] = scannator.next();
					for(int h = 0; h <= i; h++) {
						if(array[i].equals(array[h]) && i != h) {
							System.out.println("Hey you! No repeats!");
						}
					}
				}
				int [] array3 = correct(0,0);
				System.out.println("Correct: " + array3[0] + ";\nIn correct order: " + array3[1]);
				if(array3[0] == 4 && array3[1] == 4) {
					System.out.println("Success!");
					break;
				}
			}
		}
	}
	
	public void toArray() {
		array = new String[4];
		masterMindRobot obj5 = new masterMindRobot();
		for(int i = 0; i < 4; i++) {
			array[i] = obj5.shuffleArray.get(i);
		}
	}
	
	public int[] correct(int correct, int correctOrder) {
		int [] correctInts = new int[2];
		for(int i = 0; i < 4; i++) {
			for(int h = 0; h < 4; h++) {
				if(array[i].equals(arrayCorrect.get(h))) {
					correct++;
					if(i == h) {
						correctOrder++;
					}
				}
			}
		}
		correctInts[0] = correct;
		correctInts[1] = correctOrder;
		return correctInts;
	}
	
	public String array1() {
		return arrayCorrect.toString();
	}
}
