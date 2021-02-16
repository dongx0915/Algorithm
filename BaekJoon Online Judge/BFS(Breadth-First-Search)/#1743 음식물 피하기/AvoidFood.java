/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.Baekjoon1743;

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
    
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    
    public static int bfs(Point start, int[][] trash){
        int result = 1;
        Queue<Point> q = new LinkedList<>();
        
        q.add(start);
        trash[start.x][start.y] = 0;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            
            for (int i = 0; i < 4; i++) {
                Point next = new Point(now.x + dx[i], now.y + dy[i]);
                if(next.x < 0 || next.x >= trash.length || next.y < 0 || next.y >= trash[0].length) continue;
                
                if(trash[next.x][next.y] == 1){
                    q.add(next);
                    trash[next.x][next.y] = 0;
                    result++;
                }
            }
        }
        return result;
    }
    
    public static int getBigTrash(int n, int m, int[][] trash){
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(trash[i][j] == 1) result = Math.max(result, bfs(new Point(i,j), trash));
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] trash = new int[n][m];
        
        for (int i = 0; i < k; i++) {
            trash[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
        }
        System.out.println(getBigTrash(n,m, trash));
    }
    
}
