/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tomato;

import java.util.ArrayList;
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

public class Tomato {

    /**
     * @param args the command line arguments
     */
//    public static int width, height;
    public static int ripe = 0, undercook = 0;                   //익은 토마토, 안익은 토마토
//    public static int[][] box;
    public static int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};
    public static ArrayList<Point> ripePos;

    public static boolean everyQIsEmpty(Queue<Point>[] q) {
        for (Queue<Point> q1 : q) {
            if (!q1.isEmpty()) {       //하나라도 비어있지 않으면 false 리턴
                return false;
            }
        }
        return true;
    }

    public static int learningTomatoes(int width, int height, int[][] box) {
        Queue<Point>[] q = new LinkedList[ripePos.size()];
        Queue<Integer>[] dayQ = new LinkedList[ripePos.size()];
        int day = 0;
        int maxDay = 0;
        int ripeTomato = ripePos.size();
        int ripened = 0;
        
        for (int i = 0; i < ripeTomato; i++) {
            q[i] = new LinkedList<>();
            q[i].add(ripePos.get(i));
            dayQ[i] = new LinkedList<>();
            dayQ[i].add(day);
        }
        
        while (!everyQIsEmpty(q)) {
            for (int i = 0; i < ripeTomato; i++) {
                if (!q[i].isEmpty()) {
                    Point now = q[i].poll();
                    day = dayQ[i].poll();               //day의 최댓값을 출력해야함
                    if(maxDay < day) maxDay = day;
                    
                    //System.out.printf("q[%d] %d 일의 현재 위치는 [%d][%d]\n", i, day, now.x, now.y);
                    for (int j = 0; j < 4; j++) {
                        Point next = new Point(now.x + dy[j], now.y + dx[j]);
                        //System.out.println("next : " + next.x + "," + next.y);
                        if (next.x < 0 || next.x >= height || next.y < 0 || next.y >= width) continue;
                        if (box[next.x][next.y] == 0) {
                            //System.out.printf("%d일 q[%d]에 [%d][%d] 푸쉬\n", day, i, next.x, next.y);
                            q[i].add(next);
                            dayQ[i].add(day + 1);
                            box[next.x][next.y] = 1;
                            ripened++;
                        }
                    }
                }
            }
//            System.out.println("현재 day = " + day);
//            System.out.println("");
        }
        
        return (undercook != ripened) ? -1 : maxDay;
    }

    public static int getRipenDay(int width, int height, int[][] box) {
        ripePos = new ArrayList<>();
        ripe = undercook = 0;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (box[i][j] == 1) {
                    ripePos.add(new Point(i, j));
                    ripe++;
                }
                if (box[i][j] == 0) undercook++;
            }
        }
        //System.out.println("안익은 토마토 개수 : " + undercook);
        return learningTomatoes(width, height, box);
    }

    public static int start(int width, int height, int[][] box){
        return getRipenDay(width, height, box);
    }
    
//    public static void main(String[] args) {
//        // TODO code application logic here
//        Scanner sc = new Scanner(System.in);
//
//        width = sc.nextInt();
//        height = sc.nextInt();
//
//        ripePos = new ArrayList<>();
//        box = new int[height][width];
//
//        //1은 익은 토마토
//        //0은 익지 않은 토마토
//        //-1은 빈 칸
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                box[i][j] = sc.nextInt();
//            }
//        }
//        
//        System.out.println(getRipenDay());
//    }

}