/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baekjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 *
 * @author W44858
 */
class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class FindArea {

    public static int Y;                    //height(M)
    public static int X;                    //width(N)
    public static int K;                    //number of rectangles
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int[][] area;

    public static int bfs(int idx1, int idx2) {
        int thisArea = 1;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(idx1, idx2));
        area[idx1][idx2] = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                Point next = new Point(now.x + dx[i], now.y + dy[i]);
                if (next.x < 0 || next.x >= Y || next.y < 0 || next.y >= X) {
                    continue;
                }
                if (area[next.x][next.y] == 0) {
                    q.add(next);
                    area[next.x][next.y] = 1;
                    thisArea++;
                }
            }
        }
        return thisArea;
    }

    public static String getArea() {
        ArrayList<Integer> answer = new ArrayList<>();
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (area[i][j] == 0) {
                    answer.add(bfs(i, j));
                }
            }
        }

        Collections.sort(answer);
        answer.forEach(integer -> {
            sj.add(integer + "");
        });
        
        return answer.size() + "\n" + sj.toString();
    }

    public static void makeRectangle(int startX, int startY, int endX, int endY) {
        int sY = Y - startY; // 3
        int eY = Y - endY; //0

        if (sY > eY) {
            int temp = sY;
            sY = eY;
            eY = temp;
        }

        for (int i = sY; i < eY; i++) {
            for (int j = startX; j < endX; j++) {
                area[i][j] = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        Y = sc.nextInt();
        X = sc.nextInt();
        K = sc.nextInt();
        area = new int[Y][X];

        for (int i = 0; i < K; i++) {
            makeRectangle(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        System.out.println(getArea());
    }

}
