package music;

public class MusicManager {
	public static MusicListener music;
	
	public static void launchMusic() {
		music.run();
	}
	
	public static void setMenuMusic() {
		music = new MusicListener("src/assets/music1.wav");
	}
	
	public static void stopMusic() {
		music.stop();
	}
}
