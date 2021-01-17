/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baekjoon.RedGreenColorWeekness;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
}
public class RedGreenColorWeekness {

    /**
     * @param args the command line arguments
     */
    public static int N;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    public static StringBuilder[] normal_picture;
    public static StringBuilder[] week_picture;
    
    public static int bfs(Point root, char cur_char, boolean isWeek){
        StringBuilder[] picture = isWeek ? week_picture : normal_picture;
        Queue<Point> q = new LinkedList<>();
        
        q.add(root);
        picture[root.x].setCharAt(root.y, '#');
        
        while(!q.isEmpty()){
            Point now = q.poll();
            
            for (int i = 0; i < 4; i++) {
                Point next = new Point(now.x + dx[i], now.y + dy[i]);
                if(next.x < 0 || next.x >= N || next.y < 0 || next.y >= N) continue;
                if(picture[next.x].charAt(next.y) == cur_char){
                   q.add(next);
                   picture[next.x].setCharAt(next.y, '#');
                }
            }
        }
        
        return 1;
    }
    
    public static String getArea(){
        int normal = 0;
        int weekness = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(normal_picture[i].charAt(j) != '#') normal += bfs(new Point(i,j), normal_picture[i].charAt(j), false);
                if(week_picture[i].charAt(j) != '#') weekness += bfs(new Point(i,j),week_picture[i].charAt(j), true);
            }
        }
        return normal + " " + weekness;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        normal_picture = new StringBuilder[N];
        week_picture = new StringBuilder[N];
        
        for (int i = 0; i < N; i++) {
            normal_picture[i] = new StringBuilder(sc.next());
            week_picture[i] = new StringBuilder(normal_picture[i].toString().replace('G', 'R'));
        }
        
        System.out.println(getArea());
    }
    
}
