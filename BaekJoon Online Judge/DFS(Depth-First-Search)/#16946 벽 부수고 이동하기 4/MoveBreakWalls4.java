/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ16946;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
    public static StringBuilder[] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = { 0,-1, 0, 1};
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static int dfs(Pair root, int cnt) throws IOException{
       // bw.write("root = [" + root.x_ + "," + root.y_ + "] cnt = " + cnt + "\n");
        //bw.flush();
        //printMap();
        
        for (int i = 0; i < 4; i++) {
            Pair next = new Pair(root.x_ + dx[i], root.y_ + dy[i]);
            if(next.x_ < 0 || next.y_ < 0 || next.x_ >= N || next.y_ >= M) continue;
            if(map[next.x_].charAt(next.y_) == '0' && !visited[next.x_][next.y_]){
                visited[next.x_][next.y_] = true;
                cnt = dfs(next, cnt + 1);
            }
        }
        
        return cnt;
    }
    
    public static void cntPath() throws IOException{
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i].charAt(j) == '1'){
                    visited[i][j] = true;
                    int cnt = dfs(new Pair(i, j), 1) % 10;
                    //bw.write(cnt + "\n");
                    
                    map[i].setCharAt(j, (char)(cnt + 48));
                    visited = new boolean[N][M];
                }
            }
        }
        //bw.flush();
    }
    
    public static void printMap() throws IOException{
        for (int i = 0; i < N; i++) {
            bw.write(map[i].toString() + "\n");
        }
        bw.write("\n");
        bw.flush();
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here

        
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        map = new StringBuilder[N];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) map[i] = new StringBuilder(br.readLine());
        
        cntPath();
        
        for (int i = 0; i < N; i++) {
            bw.write(map[i].toString() + "\n");
        }
        
        bw.flush();
        bw.close();
    }
    
}
