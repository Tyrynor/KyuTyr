package music;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicListener{
	
	private String name;
	private Clip clip;
	private int position;
	
	public MusicListener(String name) {
		this.name = name;
	}
	
	public void run() {
		File fileIn = new File(this.name);
		AudioInputStream audioIn;
		try {
			audioIn = AudioSystem.getAudioInputStream(fileIn);
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void stop() {
		clip.stop();
	}
	
	public void pause() {
		position = clip.getFramePosition();
		clip.stop();
	}
	
	public void playOn() {
		clip.setFramePosition(position);
		clip.start();
	}
}
