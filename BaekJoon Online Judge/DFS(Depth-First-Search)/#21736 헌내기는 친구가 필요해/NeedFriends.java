/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ21736;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Pair{
    int x_, y_;

    public Pair(int x_, int y_) {
        this.x_ = x_;
        this.y_ = y_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int N,M,met_people = 0;
    public static StringBuilder[] campus;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = { 0,-1, 0, 1};
    
    public static void dfs(Pair now){
        for (int i = 0; i < 4; i++) {
            Pair next = new Pair(now.x_ + dx[i], now.y_ + dy[i]);
            if(next.x_ < 0 || next.y_ < 0 || next.x_ >= N || next.y_ >= M) continue;
            if(visited[next.x_][next.y_]) continue;
            
            char next_char = campus[next.x_].charAt(next.y_);
            if(next_char != 'X'){
                if(next_char == 'P') met_people++;
                visited[next.x_][next.y_] = true;
                dfs(next);
            }
        }
    }
    
    public static void getMetPeople(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(campus[i].charAt(j) == 'I') {
                    visited[i][j] = true;
                    dfs(new Pair(i,j));
                }
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        campus = new StringBuilder[N];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            campus[i] = new StringBuilder(sc.next());
        }
        getMetPeople();
        if(met_people > 0) System.out.println(met_people);
        else System.out.println("TT");
    }
    
}
