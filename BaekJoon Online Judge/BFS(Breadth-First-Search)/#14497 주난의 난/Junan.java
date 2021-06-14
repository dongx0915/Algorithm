/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra.BOJ14497;

import java.util.LinkedList;
import java.util.Queue;
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
    
    @Override
    public boolean equals(Object o){
        Pair target = (Pair)o;
        return (this.x_ == target.x_) && (this.y_ == target.y_);
    }

}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int N,M;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = { 0,-1, 0, 1};
    public static StringBuilder[] map;
    public static boolean[][] visited;
    
    public static boolean bfs(Pair junan, int cnt){
        Queue<Pair> q = new LinkedList<>();
        q.add(junan);
        visited[junan.x_][junan.y_] = true;
        
        while(!q.isEmpty()){
            Pair cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                Pair next = new Pair(cur.x_ + dx[i], cur.y_ + dy[i]);
                if(next.x_ < 0 || next.y_ < 0 || next.x_ >= N || next.y_ >= M) continue;
                char nextChar = map[next.x_].charAt(next.y_);
                
                if(visited[next.x_][next.y_]) continue;
                if(nextChar == '#') return true;
                
                int nextValue = nextChar - '0';
                visited[next.x_][next.y_] = true;
                
                if(nextValue == 1) map[next.x_].setCharAt(next.y_, (char)(cnt + '0'));
                else if(nextChar != '*') q.offer(next);
            }
        }
        return false;
    }
    
    public static int getJumpCount(Pair junan, Pair thief){
        int cnt = 1;
        
        while(!bfs(junan, ++cnt)){
            visited = new boolean[N][M];
            //printMap();
        }
        
        //printMap();
        return cnt - 1;
    }
    
    public static void printMap(){
        for (StringBuilder stringBuilder : map) {
            System.out.println(stringBuilder);
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        Pair junan = new Pair(sc.nextInt() - 1, sc.nextInt() - 1);
        Pair thief = new Pair(sc.nextInt()  -1, sc.nextInt() - 1);
        map = new StringBuilder[N];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) map[i] = new StringBuilder(sc.next());
        
        System.out.println(getJumpCount(junan, thief));
    }
    
}
