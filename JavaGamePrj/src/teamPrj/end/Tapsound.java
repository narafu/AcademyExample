package teamPrj.end;


import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Tapsound {

	public static void tapSound() {

		// 사운드 재생
		File file = new File("res/sound/tap.wav");
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();

		} catch (Exception w) {

			w.printStackTrace();
		}

	}

	public static void blackWin() {

		File files = new File("res/sound/blackwin.wav");
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(files);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();

		} catch (Exception w) {

			w.printStackTrace();
		}

	}

	public static void whitewin() {

		File filess = new File("res/sound/whitewin.wav");
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(filess);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();

		} catch (Exception w) {

			w.printStackTrace();
		}

	}
}
