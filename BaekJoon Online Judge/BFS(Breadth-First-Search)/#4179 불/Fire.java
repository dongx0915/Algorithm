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
public class Fire {

    /**
     * @param args the command line arguments
     */
    public static int row;      //세로(행)
    public static int col;      //가로(열)
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    public static StringBuilder[] map;
    public static Queue<Point> fire_q = new LinkedList<>();
    
    public static void print(){
        for (int i = 0; i < row; i++) {
            System.out.println(map[i]);
        }
        System.out.println("");
    }
    
    public static String bfs(Point start){
        int time = 0;
        Queue<Point> q = new LinkedList<>();
        Queue<Integer> time_q = new LinkedList<>();
        
        q.add(start);
        time_q.add(1);
        map[start.x].setCharAt(start.y, '-'); // - 방문한 곳
        
        while(!q.isEmpty()){
            Point now = q.poll();
            if(time != time_q.peek()){
                int fire_qSize = fire_q.size();
                while(fire_qSize-- != 0){
                    Point now_fire = fire_q.poll();
                    
                    for (int i = 0; i < 4; i++) {
                        Point next = new Point(now_fire.x + dx[i], now_fire.y + dy[i]);
                        if(next.x < 0 || next.x >= row || next.y < 0 || next.y >= col) continue;
                        if(map[next.x].charAt(next.y) == '.'){
                            fire_q.add(next);
                            map[next.x].setCharAt(next.y, 'F');
                        }
                    }
                }
            }
            time = time_q.poll();
            
            for (int i = 0; i < 4; i++) {
                Point next = new Point(now.x + dx[i], now.y + dy[i]);
                if(next.x < 0 || next.x >= row || next.y < 0 || next.y >= col) return time + "";
                if(map[next.x].charAt(next.y) == '.'){
                    q.add(next);
                    time_q.add(time + 1);
                    map[next.x].setCharAt(next.y, '-');
                }
            }
        }
        return "IMPOSSIBLE";
    }
    public static String getEscapeTime(){
        Point start = null;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(map[i].charAt(j) == 'J') start = new Point(i,j);
                if(map[i].charAt(j) == 'F') fire_q.add(new Point(i,j));
            }
        }
        return bfs(start);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        map = new StringBuilder[row];
        
        for (int i = 0; i < row; i++) {
            map[i] = new StringBuilder(sc.next());
        }
        System.out.println(getEscapeTime());
    }
    
}
