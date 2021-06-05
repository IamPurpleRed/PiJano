import java.io.File;
import java.util.TreeSet;

public class FileChecker {
    File music_folder = new File("music");
    File beatmap_folder = new File("beatmap");
    TreeSet<String> check = new TreeSet<String>();

    FileChecker() {
        for (File f : music_folder.listFiles()) {
            String temp = f.getName();
            temp = temp.substring(0, temp.length() - 4); // 去除副檔名
            check.add(temp);
        }
        for (File f : beatmap_folder.listFiles()) {
            String temp = f.getName();
            temp = temp.substring(0, temp.length() - 4); // 去除副檔名
            if (check.contains(temp))
                Main.PiJano.available_list.add(temp);
        }
    }
}
