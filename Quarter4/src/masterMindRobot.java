import java.util.ArrayList;
import java.util.Collections;


public class masterMindRobot {
	
	String [] array = {"red","green","blue","yellow","brown","grey"};
	ArrayList<String> shuffleArray;
	int countTries;
	masterMind obj3 = new masterMind();
	
	public void solveRandom() {
		instantiate();
		while(true) {
			countTries++;
			shuffle();
			//System.out.println(shuffleArray.toString() + obj3.array1());
			if(obj3.array1().equals(shuffleArray.toString())) {
				System.out.println("Found: " + shuffleArray.toString());
				System.out.println("Found in "+countTries + " turns");
				break;
			}
			shuffleArray.clear();
		}
	}
	
	public void solveSmart() {
		instantiate();
		shuffle();
		masterMind obj10 = new masterMind();
		obj10.correct(0, 0);
		
	}
	
	public void solveSmarter() {
		instantiate();
	}
	
	public void shuffle() {
		for(int i = 0; i < 6; i++) {
			shuffleArray.add(array[i]);
		}
		
		for(int i = 0; i < 2; i++) {
			int random = (int)(Math.random()*shuffleArray.size());
			shuffleArray.remove(random);
		}
		
		Collections.shuffle(shuffleArray);
	}
	
	public void instantiate() {
		masterMind obj3 = new masterMind();
		countTries = 0;
		shuffleArray = new ArrayList();
	}
}
