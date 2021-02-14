/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.Baekjoon14176;

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
    static int[] dx = { 0,-1,-1,-1, 0, 1, 1, 1};
    static int[] dy = {-1,-1, 0, 1, 1, 1, 0,-1};
    
    public static void print(int[][] banner){
        for (int[] is : banner) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
    }
    
    public static int bfs(int m, int n, int[][] banner, Point start){
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        banner[start.x][start.y] = 0;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            
            for (int i = 0; i < 8; i++) {
                Point next = new Point(now.x + dx[i], now.y + dy[i]);
                if(next.x < 0 || next.x >= m || next.y < 0 || next.y >= n) continue;
                if(banner[next.x][next.y] == 1){
                    q.add(next);
                    banner[next.x][next.y] = 0;
                }
            }
        }
        
        return 1;
    }
    public static int getWordCnt(int m, int n, int[][] banner){
        int word = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(banner[i][j] == 1) {
                    word += bfs(m, n, banner, new Point(i,j));
                    //print(banner);
                }
            }
        }
        
        return word;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        //banner 현수막
        int[][] banner = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                banner[i][j] = sc.nextInt();
            }
        }
        
        System.out.println(getWordCnt(m, n, banner));
    }
    
}
