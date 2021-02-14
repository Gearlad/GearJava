package testy;

import java.awt.event.KeyEvent;

public class Controller extends MasterDriver {
	
	public static void directionalArrows() {
		if(command == 'a') {
			xVelocity -= .5;
			aHeld = true;
		} else if(command == 'w') {
			yVelocity -= .5;
			wHeld = true;
		} else if(command == 'd') {
			xVelocity += .5;
			dHeld = true;
		} else if(command == 's') {
			yVelocity += .5;
			sHeld = true;
		}
	}
	
	public static void directionalArrowsRelease() {
		if(command == 'a') {
			xVelocity += .5;
			aHeld = false;
		} else if(command == 'w') {
			yVelocity += .5;
			wHeld = false;
		} else if(command == 'd') {
			xVelocity -= .5;
			dHeld = false;
		} else if(command == 's') {
			yVelocity -= .5;
			sHeld = false;
		}
	}
	
	public static void otherButtons() {
		if(code == KeyEvent.VK_ENTER && initialEnter == false) {
			initialEnter = true;
		} else if(code == KeyEvent.VK_ENTER && initialEnter == true) {
			if(newCrusadeBool == false) {
				if(selection == 0) {
					//New crusade
					newCrusadeBool = true;
					FileReading.newFile();
				} else if(selection == 1) {
					//Continue crusade
					FileReading.fileList();
					loadNames = true;
					initiateTable();
				} else if(selection == 2) {
					System.exit(0);
				}
				else initialTiming = ticks;
			} else {
				newCrusadeBool = false;
				newName = nameField.getText();
				FileReading.printToFile();
			}
		}
		else if(code == KeyEvent.VK_UP) {
			selection--;
			intermittent = 75;
			if(selection < 0) {
				selection += 3;
			}
		} else if(code == KeyEvent.VK_DOWN) {
			selection++;
			intermittent = 75;
			if(selection > 2) {
				selection -= 3;
			}
		} else if(code == KeyEvent.VK_ESCAPE) {
			if(paused == false) {
				paused = true;
			} else {
				paused = false;
			}
		}
	}
	
	protected static void debug1() {
		if(aHeld == false && dHeld == false) {
			xVelocity = 0;
		}
		if(wHeld == false && sHeld == false) {
			yVelocity = 0;
		}
	}
	
	protected static void selectionDetect() {
		if(selection == 0) {
			iconCoords[0] = 0;
			iconCoords[1] = 140;
		} else if(selection == 1) {
			iconCoords[0] = 0;
			iconCoords[1] = 240;
		} else if(selection == 2) {
			iconCoords[0] = 0;
			iconCoords[1] = 360;
		}
	}
	
	protected static void velocity() {
		playerCoords[0] += xVelocity;
		playerCoords[1] += yVelocity;
	}

}
