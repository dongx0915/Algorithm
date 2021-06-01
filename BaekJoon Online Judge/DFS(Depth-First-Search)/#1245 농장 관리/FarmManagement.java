/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ1245;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Pair{
    int x_;
    int y_;

    public Pair(int x_, int y_) {
        this.x_ = x_;
        this.y_ = y_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int N,M;
    public static int[][] farm;
    public static boolean[][] visited;
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0,-1};
    public static int[] dy = { 0, -1,-1,-1, 0, 1, 1, 1};
    
    public static void printFarm(){
        for (int[] is : farm) {
            for (int i : is) {
                System.out.printf("%3d", i);
            }
            System.out.println("");
        }
        System.out.println("");
        
        for (boolean[] bs : visited) {
            for (boolean b : bs) {
                if(b) System.out.print("T ");
                else System.out.print("F ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static int isMountainPeak(Pair root, int cur, boolean isPeak){
        visited[root.x_][root.y_] = true;
        System.out.printf("now [%d,%d], cur = %d\n", root.x_, root.y_, cur);
        
        for (int i = 0; i < 8; i++) {
            Pair next = new Pair(root.x_ + dx[i], root.y_ + dy[i]);
            
            if(next.x_ < 0 || next.y_ < 0 || next.x_ >= N || next.y_ >= M) continue;
            if(farm[next.x_][next.y_] > cur) isPeak = false;
            if(visited[next.x_][next.y_]) continue;
            
            if(farm[next.x_][next.y_] == cur) isMountainPeak(next, cur, isPeak);
        }
        
        
        System.out.println(isPeak);
        
        return isPeak ? 1 : 0;
    }
        
    public static int getMountainPeak(){
        int peak = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(farm[i][j] > 0 && !visited[i][j]){
                    //System.out.printf("root [%d,%d], cur = %d\n", i,j, farm[i][j]);
                    int dfs = isMountainPeak(new Pair(i,j), farm[i][j], true);
                    peak += dfs;
                    System.out.println(dfs);
                    //System.out.println("");
                    printFarm();
                }
            }
        }
        
        return peak;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        farm = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) 
            for (int j = 0; j < M; j++) 
                farm[i][j] = sc.nextInt();
        
        System.out.println(getMountainPeak());
    }
    
}
