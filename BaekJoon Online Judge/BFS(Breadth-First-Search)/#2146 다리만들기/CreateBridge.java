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
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class CreateBridge {
    public static int N;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int[][] map;
    public static boolean[][] visited;
    
    public static void printMap(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public static void setAreaBfs(Point root, int index){
        Queue<Point> q = new LinkedList<>();
        
        
        q.add(root);
        visited[root.x][root.y] = true;
        map[root.x][root.y] = index;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            
            for (int i = 0; i < 4; i++) {
                Point next = new Point(now.x + dx[i], now.y + dy[i]);
                if(next.x < 0 || next.x >= N || next.y < 0 || next.y >= N) continue;
                if(!visited[next.x][next.y] && map[next.x][next.y] != 0){
                    q.add(next);
                    visited[next.x][next.y] = true;
                    map[next.x][next.y] = index;
                }
            }
        }
    }
    
    public static void setArea(){
        int index = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) setAreaBfs(new Point(i,j), index++);
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        setArea();
        printMap();
    }
    
}
