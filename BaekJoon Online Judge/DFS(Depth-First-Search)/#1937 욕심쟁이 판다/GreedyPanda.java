/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Gold.BOJ1937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class Point{
    int x_;
    int y_;
    int max_;
    
    public Point(int x_, int y_, int max_) {
        this.x_ = x_;
        this.y_ = y_;
        this.max_ = max_;
    }
}

public class Main {
    
    public static int N;
    public static int[][] dp;
    public static int[][] bamboo;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = { 0,-1, 0, 1};
    
    public static int dfs(Point cur){
        // 이미 계산이 된 칸이면 바로 리턴
        if(dp[cur.x_][cur.y_] != 0) return dp[cur.x_][cur.y_];
        
        // 방문한 칸은 dp[cur]가 1로 체크되므로 visited 체크를 할 필요가 없음
        dp[cur.x_][cur.y_] = 1;
        
        for (int i = 0; i < 4; i++) {
            Point next = new Point(cur.x_ + dx[i], cur.y_ + dy[i], cur.max_ + 1);
            
            if(next.x_ < 0 || next.y_ < 0 || next.x_ >= N || next.y_ >= N) continue;
            if(bamboo[next.x_][next.y_] <= bamboo[cur.x_][cur.y_]) continue;
            
            // dfs(next)는 next 칸에서 판다가 살 수 있는 최대 일 수를 뜻함
            // 현재 칸에서 다음 칸으로 가는 것도 1일이 걸리므로 next + 1
            int nextDay = dfs(next) + 1;
            
            // 다음 칸으로 가는 경우 중 최대 일 수를 dp[cur]에 저장
            dp[cur.x_][cur.y_] = Math.max(dp[cur.x_][cur.y_], nextDay);
        }
        
        return dp[cur.x_][cur.y_];
    }
    
    public static int getMaxMoved(){
        int max = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, dfs(new Point(i, j, 1)));
            }
        }
        
        return max;
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        dp = new int[N][N];
        bamboo = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            
            for (int j = 0; j < N; j++) {
                bamboo[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        System.out.println(getMaxMoved());
    }
}
