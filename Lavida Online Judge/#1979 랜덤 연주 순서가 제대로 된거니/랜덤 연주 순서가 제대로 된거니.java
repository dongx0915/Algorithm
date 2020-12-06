import java.util.*;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();

        for (int i = 0; i < test; i++) {
            int musicCount = scan.nextInt();
            int[] playlist = new int[musicCount];

            for (int j = 0; j < musicCount; j++) {
                playlist[j] = scan.nextInt();
            }

            if (MusicPlayer(playlist)) {
                System.out.println("good");
            } else {
                System.out.println("bad");
            }
        }
    }

    public static boolean MusicPlayer(int[] playlist) {
        int length = playlist.length;
        for (int i = 0; i < length - 2; i++) {
                if ((playlist[i] == playlist[i + 1]) || (playlist[i] == playlist[i + 2]))  return false;
                else if (length >= 4 && i < length - 3) {
                    if (playlist[i] == playlist[i + 3]) {
                        return false;
                    }
                }
            if (playlist[i] + 1 == playlist[i + 1] && playlist[i + 1] + 1 == playlist[i + 2]) {
                return false;
            }
        }

        return true;
    }
}