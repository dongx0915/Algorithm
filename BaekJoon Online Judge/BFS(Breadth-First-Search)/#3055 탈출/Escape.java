/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Escape {

    public static int Y;        //R
    public static int X;        //C
    public static StringBuilder[] map;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    public static Queue<Point> hedgehog = new LinkedList<>();
    public static Queue<Point> water = new LinkedList<>();
    public static boolean[][] visited;

    //D 도착지점
    //S 시작지점
    //* 물
    //X 돌
    //# 방문한 곳
    public static String bfs(Point start, Point end) {
        Queue<Integer> time = new LinkedList<>();
        int nowT = 0;

        hedgehog.add(start);
        time.add(1);

        while (!hedgehog.isEmpty()) {
            Point nowHog = hedgehog.poll();
            //map[nowHog.x].setCharAt(nowHog.y, '#');

            if (nowT != time.peek()) {  
                int qsize = water.size();
                while (qsize-- != 0) {      //한 턴에 갈 수 있는 경우가 큐에 들어가므로 큐 사이즈만큼만 돌면 한 턴씩만 순회를 할 수 있다.
                    Point nowWater = water.poll();

                    for (int i = 0; i < 4; i++) {
                        Point next = new Point(nowWater.x + dx[i], nowWater.y + dy[i]);
                        if (next.x < 0 || next.x >= Y || next.y < 0 || next.y >= X) continue;
                        if (map[next.x].charAt(next.y) == '.') {
                            water.add(next);
                            map[next.x].setCharAt(next.y, '*');
                        }
                    }
                }
            }
            nowT = time.poll();
            
            for (int i = 0; i < 4; i++) {
                Point next = new Point(nowHog.x + dx[i], nowHog.y + dy[i]);
                if (next.x < 0 || next.x >= Y || next.y < 0 || next.y >= X) continue;
                if (map[next.x].charAt(next.y) == '.') {
                    hedgehog.add(next);
                    time.add(nowT + 1);
                    map[next.x].setCharAt(next.y, '#');
                }
                if (map[next.x].charAt(next.y) == 'D') {
                    return nowT + "";
                }
            }
        }

        return "KAKTUS";
    }

    public static String getTime() {
        Point start = null, end = null;

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (map[i].charAt(j) == 'S') {
                    start = new Point(i, j);
                }
                if (map[i].charAt(j) == 'D') {
                    end = new Point(i, j);
                }
                if (map[i].charAt(j) == '*') {
                    water.add(new Point(i, j));
                }
            }
        }

        return bfs(start, end);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Y = sc.nextInt();
        X = sc.nextInt();
        visited = new boolean[Y + 1][X + 1];
        map = new StringBuilder[Y];

        for (int i = 0; i < Y; i++) {
            map[i] = new StringBuilder(sc.next());
        }

        System.out.println(getTime());
    }

}
