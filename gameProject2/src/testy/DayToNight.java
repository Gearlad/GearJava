package testy;

public class DayToNight extends MasterDriver {
	public static String tickHandler() {
		String picture = "";
		//5:00 - 5:30
		if(ticks > 50000 && ticks <= 55000) {
			picture = "nightShadow2";
		}
		//5:30 - 6:00
		else if(ticks > 55000 && ticks <= 60000) {
			picture = "nightShadow3";
		}
		//6:00 - 6:30
		else if(ticks > 60000 && ticks <= 65000) {
			picture = "nightShadow4";
		}
		//6:30-7:00
		else if(ticks > 65000 && ticks <= 70000) {
			picture = "nightShadow5";
		}
		
		
		
		//7:00-17:00
		else if(ticks > 70000 && ticks <= 170000) {}
		
		
		
		//17:00 - 17:30
		if(ticks > 170000 && ticks <= 175000) {
			picture = "nightShadow5";
		}
		//17:30 - 18:00
		else if(ticks > 175000 && ticks <= 180000) {
			picture = "nightShadow4";
		}
		//18:00 - 18:30
		else if(ticks > 180000 && ticks <= 185000) {
			picture = "nightShadow3";
		}
		//18:30-19:00
		else if(ticks > 185000 && ticks <= 190000) {
			picture = "nightShadow2";
		}
		//19:00-5:00
		else if(ticks > 190000 || ticks <= 50000) {
			//darkest
			picture = "nightShadow1";
			if(ticks == 240000) {
				ticks = 0;
			}
		}
		return picture;
	}
}
