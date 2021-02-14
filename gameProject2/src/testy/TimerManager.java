package testy;

import java.util.Timer;
import java.util.TimerTask;

public class TimerManager extends MasterDriver {
	
	static Timer timer;
	
	int interval = 1;
	int delay = 1000;
	int period = 1000;
	boolean intervalBoolean = false;

	public boolean timing() {
		intervalBoolean = false;
		timer();
		if(intervalBoolean == true) {
			interval = 1;
		}
		return intervalBoolean;
	}
	
	public static void intermittentFunc() {
		if(intermittent == 150) {
			visibleIcon = false;
			intermittent -= 150;
		} else if(intermittent == 75) {
			visibleIcon = true;
		}
		
		intermittent++;
	}
	
	public void timer() {
	    timer = new Timer();
	    timer.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
	        	interval--;
	        	if(interval <= 0) {
	        		intervalBoolean = true;
	        		timer.cancel();
	        	}
	        }
	    }, delay, period);	}


}
