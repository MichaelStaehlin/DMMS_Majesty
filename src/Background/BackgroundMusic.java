package Background;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

// Background Music for the entire game
// Source: https://www.youtube.com/watch?v=dGTgBVgRfJI&t=27s
// Download as MP3 and converted in WAV (44100kHz, 16 Bit) with Ableton Live 

public class BackgroundMusic {
	
	public static synchronized void music(String track) {

		  final String trackname = track;

		  new Thread(new Runnable() {

		   public void run() {
		    while (true) {
		     
		     try {
		      Clip clip = AudioSystem.getClip();
		      AudioInputStream inputstream = AudioSystem.getAudioInputStream(new File(trackname));
		      clip.open(inputstream);
		      clip.loop(Clip.LOOP_CONTINUOUSLY);
		     
		      Thread.sleep(clip.getMicrosecondLength()/1000);
		      
		     } catch (Exception e) {
		      e.printStackTrace();
		     }

		    }

		   }

		  }).start();

		 }

		}


