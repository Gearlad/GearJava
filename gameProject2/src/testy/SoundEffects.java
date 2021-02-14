package testy;


import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.SwingUtilities;

public class SoundEffects extends MasterDriver {
	
	public static void playFootsteps() throws Exception {
		File url = new File("step" + ((int)(Math.random()*5) + 1) + ".wav");
		Clip clip = AudioSystem.getClip();
		AudioInputStream ais = AudioSystem.getAudioInputStream(url);
		clip.open(ais);
		clip.start();
		SwingUtilities.invokeLater(new Runnable() {
		public void run() {}
		});
	}
	
	public static void playSong() throws Exception {
        File url = new File("beat1.wav");
		Clip clip = AudioSystem.getClip();
		AudioInputStream ais = AudioSystem.getAudioInputStream(url);
		clip.open(ais);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		SwingUtilities.invokeLater(new Runnable() {
		public void run() {}
		});
		if(logged == true) {
			clip.close();
		}
	}
}