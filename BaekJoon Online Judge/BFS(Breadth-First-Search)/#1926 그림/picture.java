/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.Baekjoon1926;

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
    public static int bfs(Point root, int[][] picture){
        int size = 1;
        Queue<Point> q = new LinkedList<>();
        q.add(root);
        picture[root.x][root.y] = 0;

        while(!q.isEmpty()){
            Point now = q.poll();
            
            for (int i = 0; i < 4; i++) {
                Point next = new Point(now.x + dx[i], now.y + dy[i]);
                if(next.x < 0 || next.x >= picture.length || next.y < 0 || next.y >= picture[0].length) continue;
                if(picture[next.x][next.y] == 1){
                    q.add(next);
                    picture[next.x][next.y] = 0;
                    size++;
                }
            }
        }
        
        return size;
    }
    
    public static String getBigestPicture(int[][] picture){
        int size = 0;
        int pic_cnt = 0;
        int n = picture.length;
        int m = picture[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(picture[i][j] == 1) {
                    pic_cnt++;
                    size = Math.max(size, bfs(new Point(i,j), picture)) ;
                }
            }
        }
        
        return pic_cnt + "\n" + size;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();      //세로(y)
        int m = sc.nextInt();      //가로(x)
        int[][] picture = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                picture[i][j] = sc.nextInt();
            }
        }
        System.out.println(getBigestPicture(picture));
    }
    
}
