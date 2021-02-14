package testy;

public class Collision extends MasterDriver {
	public static void collision() {
		
		if(area == 0) {
			if(playerCoords[0] > 80 && playerCoords[0] < 163 && playerCoords[1] < 111 && playerCoords[1] > 110) {
				playerCoords[1] = 111;
			} else if(playerCoords[0] > 80 && playerCoords[0] < 163 && playerCoords[1] < 73 && playerCoords[1] > 70) {
				playerCoords[1] = 70;
			} else if(playerCoords[0] > 80 && playerCoords[0] < 83 && playerCoords[1] > 70 && playerCoords[1] < 110) {
				playerCoords[0] = 80;
			} else if(playerCoords[0] < 163 && playerCoords[0] > 160 && playerCoords[1] > 70 && playerCoords[1] < 110) {
				playerCoords[0] = 163;
			}
		}
	}
}
