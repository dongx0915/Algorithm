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
public class OrganicCabbage {

    /**
     * @param args the command line arguments
     */
    public static int test;
    public static int col;      //가로    
    public static int row;      //세로
    public static int cabbage_cnt;//배추 개수
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    
    public static void print(int[][] farm){
        for (int[] farm1 : farm) {
            for (int j = 0; j < farm[0].length; j++) {
                System.out.print(farm1[j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static int bfs(int[][] farm, Point root){
        Queue<Point> q = new LinkedList<>();
        
        q.add(root);
        farm[root.x][root.y] = 0;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            
            for (int i = 0; i < 4; i++) {
                Point next = new Point(now.x + dx[i], now.y + dy[i]);
                if(next.x < 0 || next.x >= row || next.y < 0 || next.y >= col) continue;
                if(farm[next.x][next.y] == 1){
                    q.add(next);
                    farm[next.x][next.y] = 0;
                }
            }
        }
        
        return 1;
    }
    public static int getNeedEarthworm(int[][] farm){
        int worm = 0;
        for (int i = 0; i < farm.length; i++) {
            for (int j = 0; j < farm[0].length; j++) {
                if(farm[i][j] == 1)  worm += bfs(farm, new Point(i,j));
            }
        }
        
        return worm;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        test = sc.nextInt();
        
        while(test-- != 0){
            col = sc.nextInt();
            row = sc.nextInt();
            cabbage_cnt = sc.nextInt();
            
            int[][] farm = new int[row][col];
            
            for (int i = 0; i < cabbage_cnt; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                farm[y][x] = 1;
            }
            
            //print(farm);
            System.out.println(getNeedEarthworm(farm));
        }
        
    }
    
}
