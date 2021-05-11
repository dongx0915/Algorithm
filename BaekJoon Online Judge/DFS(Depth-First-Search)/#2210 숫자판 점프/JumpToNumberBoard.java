/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashSet;
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
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int[][] board = new int[5][5];
    public static HashSet<String> set = new HashSet<>();
    
    public static void dfs(Pair prev, int depth, String result){
        if(depth == 6){
            set.add(result);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            Pair next = new Pair(prev.x_ + dx[i], prev.y_ + dy[i]);
            if(next.x_ < 0 || next.x_ >=5 || next.y_ < 0 || next.y_ >= 5) continue;
            dfs(next, depth + 1, result + board[prev.x_][prev.y_]);
        }
    }
    
    public static void getNumbers(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(new Pair(i,j), 0, "");
            }
        }

        System.out.println(set.size());
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        
        getNumbers();
    }
    
}
