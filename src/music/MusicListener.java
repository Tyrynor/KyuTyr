package music;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicListener extends Thread {
	public void run() {
		int totalFramesRead = 0;
		File fileIn = new File("src/assets/music1.wav");
		AudioInputStream audioIn;
		try {
			audioIn = AudioSystem.getAudioInputStream(new File("src/assets/music1.wav"));
			Clip clip;
			try {
				clip = AudioSystem.getClip();
				clip.open(audioIn);
				clip.start();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
