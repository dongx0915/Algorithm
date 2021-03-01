/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.Baekjoon2206;

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

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    
    public static int bfs(StringBuilder[] map){
        int n = map.length;
        int m = map[0].length();
        boolean[][] visited = new boolean[n][m];
        
        Queue<Point> q = new LinkedList<>();
        Queue<Integer> dis_q = new LinkedList<>();
        
        q.add(new Point(0,0));
        dis_q.add(1);
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            int now_dis = dis_q.poll();
            
            for (int i = 0; i < 4; i++) {
                Point next = new Point(now.x + dx[i], now.y + dy[i]);
                if(next.x < 0 || next.x >= n || next.y < 0 || next.y >= m) continue;
                if(next.x == n - 1 && next.y == m - 1) return now_dis + 1;
                if(map[next.x].charAt(next.y) == '0' && !visited[next.x][next.y]){
                    q.add(next);
                    dis_q.add(now_dis + 1);
                    visited[next.x][next.y] = true;
                }
            }
        }
        
        return -1;
    }
    public static int getShortestDis(StringBuilder[] map, int n, int m){
        int min_dis = Integer.MAX_VALUE; //벽을 하나도 부수지 않은 상태에서 목적지까지의 거리
        boolean flag = !(bfs(map) == -1);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i].charAt(j) == '1'){
                    map[i].setCharAt(j, '0');
                    int dis = bfs(map);
                    if(dis > 0) {
                        min_dis = Math.min(min_dis, dis);
                        flag = true;
                    }
                    map[i].setCharAt(j, '1'); //bfs를 돌리고 난 후 벽 원상복구
                }
            }
        }
        
        return flag ? min_dis : -1;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //세로(y)
        int m = sc.nextInt();   //가로(x)
        StringBuilder[] map = new StringBuilder[n];
        
        for (int i = 0; i < n; i++) {
            map[i] = new StringBuilder(sc.next());
        }
        
        System.out.println(getShortestDis(map, n,m));
    }
}
