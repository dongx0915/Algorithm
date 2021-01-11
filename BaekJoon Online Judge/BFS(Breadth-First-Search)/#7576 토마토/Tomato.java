package tomato;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Tomatoes {

    /**
     * @param args the command line arguments
     */
    public static int width, height;
    public static int ripe = 0, undercook = 0;                   //익은 토마토, 안익은 토마토
    public static int[][] box;
    public static int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};
    public static Queue<Point> q = new LinkedList<>();
    public static Queue<Integer> dayQ = new LinkedList<>();

    public static boolean everyQIsEmpty(Queue<Point>[] q) {
        for (Queue<Point> q1 : q) {
            if (!q1.isEmpty()) {       //하나라도 비어있지 않으면 false 리턴
                return false;
            }
        }
        return true;
    }

    public static int learningTomatoes() {
        int day = 0;
        int ripened = 0;

        while (!q.isEmpty()) {
            Point now = q.poll();
            day = dayQ.poll(); 

            for (int j = 0; j < 4; j++) {
                Point next = new Point(now.x + dy[j], now.y + dx[j]);

                if (next.x < 0 || next.x >= height || next.y < 0 || next.y >= width)continue;
                if (box[next.x][next.y] == 0) {
                    q.add(next);
                    dayQ.add(day + 1);
                    box[next.x][next.y] = 1;
                    ripened++;
                }
            }
        }
        return (undercook != ripened) ? -1 : day;
    }

    public static int getRipenDay() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (box[i][j] == 1) {
                    q.add(new Point(i, j));
                    dayQ.add(0);
                    ripe++;
                }
                if (box[i][j] == 0) {
                    undercook++;
                }
            }
        }
        return learningTomatoes();
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        width = sc.nextInt();
        height = sc.nextInt();

        box = new int[height][width];

        //1은 익은 토마토
        //0은 익지 않은 토마토
        //-1은 빈 칸
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                box[i][j] = sc.nextInt();
            }
        }

        System.out.println(getRipenDay());
    }
}
