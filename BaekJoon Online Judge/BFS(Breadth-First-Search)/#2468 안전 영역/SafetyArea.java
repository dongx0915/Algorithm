/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.Baekjoon2468;

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
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int bfs(Point root, int water, int[][] map, boolean[][] visited){
        Queue<Point> q = new LinkedList();
        q.add(root);
        visited[root.x][root.y] = true;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            
            for (int i = 0; i < 4; i++) {
                Point next = new Point(now.x + dx[i], now.y + dy[i]);
                if(next.x < 0 || next.x >= map.length || next.y < 0 || next.y >= map.length) continue;
                if(map[next.x][next.y] > water && !visited[next.x][next.y]){
                    q.add(next);
                    visited[next.x][next.y] = true;
                }
            }
        }

        return 1;
    }
    
    public static int getSafetyArea(int max, int min, int[][] map){
        int n = map.length;
        int max_area = Integer.MIN_VALUE;
        //잠기지 않을려면 현재 물 높이보다 높아야함
        
        for (int water = min - 1; water <= max + 1; water++) {
            int area = 0;
            boolean[][] visited = new boolean[map.length][map[0].length];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(map[i][j] > water && !visited[i][j]) area += bfs(new Point(i,j), water, map, visited);
                }
            }
            max_area = Math.max(max_area, area);
        }
        
        return max_area;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                max = Math.max(map[i][j], max);
                min = Math.min(map[i][j], min);
            }
        }
        
        System.out.println(getSafetyArea(max, min, map));
    }
    
}
