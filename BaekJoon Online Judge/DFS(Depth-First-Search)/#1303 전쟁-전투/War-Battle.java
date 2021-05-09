/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ1303;

import java.util.Scanner;
import java.util.Stack;

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
    public static boolean[][] visited;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int n,m;
    public static String[] field;
    
    public static int dfs(Pair root, boolean team){
        int people = 1;
        Stack<Pair> s = new Stack<>();
        
        s.push(root);
        visited[root.x_][root.y_] = true;
        
        while(!s.isEmpty()){
            Pair cur = s.pop();
        
            for (int i = 0; i < 4; i++) {
                Pair next = new Pair(cur.x_ + dx[i], cur.y_ + dy[i]);
                if(next.x_ < 0 || next.x_ >= m || next.y_ < 0 || next.y_ >= n) continue;
                if(!visited[next.x_][next.y_]){
                    if(team){
                        if(field[next.x_].charAt(next.y_) == 'W'){
                            people++;
                            s.add(next);
                            visited[next.x_][next.y_] = true;
                        }
                    }
                    else{
                        if(field[next.x_].charAt(next.y_) == 'B'){
                            people++;
                            s.add(next);
                            visited[next.x_][next.y_] = true;
                        }
                    }
                }
            }
        }

        return people;
    }
    
    public static void getPower(){
        int w_cnt = 0;
        int b_cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    if(field[i].charAt(j) == 'W') w_cnt += (int)Math.pow(dfs(new Pair(i,j), true), 2);
                    if(field[i].charAt(j) == 'B') b_cnt += (int)Math.pow(dfs(new Pair(i,j), false), 2);
                }
            }
        }
        
        System.out.println(w_cnt + " " + b_cnt);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   //가로
        m = sc.nextInt();   //세로
        
        field = new String[m];
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            field[i] = sc.next();
        }
        
        getPower();
    }
    
}
