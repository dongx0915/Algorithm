/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int width, height;       // 0 < w,h <= 50
    static int[][] map;

    public static void bfs(Posit root) {
        map[root.x][root.y] = 0;

        for (int i = 0; i < 8; i++) {
            Posit next = new Posit((root.x + dx[i]), (root.y + dy[i]));
            if (next.x < 0 || next.x >= height || next.y < 0 || next.y >= width) continue;
            if (map[next.x][next.y] == 1) bfs(next);
        }
    }

    public static int getIsland() {
        int cnt = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] == 1) {
                    bfs(new Posit(i, j));
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        while (true) {
            width = sc.nextInt();
            height = sc.nextInt();

            if (width == 0 && height == 0) break;
            map = new int[height][width];

            for (int i = 0; i < height; i++) for (int j = 0; j < width; j++)  map[i][j] = sc.nextInt();

            System.out.println(getIsland());
        }
    }

}
