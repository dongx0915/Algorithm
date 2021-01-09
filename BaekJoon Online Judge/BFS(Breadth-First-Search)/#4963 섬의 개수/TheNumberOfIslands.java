/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Posit{
    int x;
    int y;

    public Posit(int x, int y) {
        this.x = x;
        this.y = y;
    }   
}

public class TheNumberOfIslands {

    /**
     * @param args the command line arguments
     */
    static int[] dx = {-1,-1,-1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0,-1,-1};
    static int width, height;       // 0 < w,h <= 50
    static int[][] map;
    static boolean[][] visited;
    
    public static boolean check(Posit next){
        if(next.x < 0 || next.x >= height || next.y < 0 || next.y >= width) return false;
        if(map[next.x][next.y] == 0) return false;
        return !visited[next.x][next.y];
    }
    
    public static void BFS(Posit root){
        Queue<Posit> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            Posit now = q.poll();
            visited[now.x][now.y] = true;
            
            for (int i = 0; i < 8; i++) {
                Posit next = new Posit((now.x + dx[i]), (now.y + dy[i]));
                if(check(next)){
                    q.add(next);
                    visited[next.x][next.y] = true;
                }
            }
        }
    }
    
    public static int getIsland(){
        int cnt = 0;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    BFS(new Posit(i,j));
                    cnt++;
                }
            }
        }     
        return cnt;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        while(true){
            width = sc.nextInt();
            height = sc.nextInt();
            
            if(width == 0 && height == 0) break;
            map = new int[height][width];
            visited = new boolean[height][width];
            
            for (int i = 0; i < height; i++) for (int j = 0; j < width; j++) map[i][j] = sc.nextInt();
            
            System.out.println(getIsland());
        }
    }
    
}
