import java.io.File;
import javax.sound.sampled.*;

public class MusicPlayer {
    MusicPlayer(String name) {
        try {
            String path = "music/" + name + ".wav";
            File music_path = new File(path);
            AudioInputStream audioinputstream = AudioSystem.getAudioInputStream(music_path);
            Clip clip = AudioSystem.getClip();
            clip.open(audioinputstream);
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
