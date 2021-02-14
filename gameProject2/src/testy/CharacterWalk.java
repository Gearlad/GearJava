package testy;

public class CharacterWalk extends MasterDriver {
	
	public static int determineStep(int walkCounter) {
		
		if(walkCounter > 100 && walkCounter <= 125) {
			playSteps = false;
			currentStep = 1;
		} else if(walkCounter > 125 && walkCounter <= 150) {
			if(playSteps == false) {
				playSteps = true;
				try {
					SoundEffects.playFootsteps();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			currentStep = 2;
		} else if(walkCounter > 150 && walkCounter <= 175) {
			playSteps = false;
			currentStep = 3;
		} else if(walkCounter > 175 && walkCounter <= 200) {
			currentStep = 4;
		} else if(walkCounter > 200 && walkCounter < 225) {
			if(playSteps == false) {
				playSteps = true;
				try {
					SoundEffects.playFootsteps();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			currentStep = 5;
		} else if(walkCounter > 225) {
			currentStep = 6;
		}
		return currentStep;
	}
	
	public static void shift() {
		if(playerCoords[0] <= -15) {
			moving[0] = true;
		}
		if(playerCoords[0] >= 656) {
			moving[1] = true;
		}
		if(playerCoords[1] <= -14) {
			moving[2] = true;
		}
		if(playerCoords[1] >= 436) {
			moving[3] = true;
		}
		
		if(moving[0] == true) {
			xVelocity = 0;
			yVelocity = 0;
			playerCoords[0] += 3;
			if(playerCoords[0] > 650) {
				moving[0] = false;
			}
		}
		if(moving[1] == true) {
			xVelocity = 0;
			yVelocity = 0;
			playerCoords[0] -= 3;
			if(playerCoords[0] < -9) {
				moving[1] = false;
			}
		}
		if(moving[2] == true) {
			xVelocity = 0;
			yVelocity = 0;
			playerCoords[1] += 3;
			if(playerCoords[1] > 430) {
				moving[2] = false;
			}
		}
		if(moving[3] == true) {
			xVelocity = 0;
			yVelocity = 0;
			playerCoords[1] -= 3;
			if(playerCoords[1] < -8) {
				moving[3] = false;
			}
		}
	}
}
