package testy;

public class RunOperator extends MasterDriver {
	
	public static void runMethod() {
		if(paused == false) {
			Collision.collision();
			Controller.velocity();
			Controller.debug1();
			CharacterWalk.shift();
		}
	}
	
	public static void sleep() {
		try {
			Thread.sleep(6);
		}
		catch(InterruptedException e) {}
	}
	
	public static void initiate() {
		iconCoords[0] = 0;
		iconCoords[1] = 140;
		playerCoords[0] = 100.0;
		playerCoords[1] = 100.0;
		
		InstantiateImages.instantiate();
	}
}
