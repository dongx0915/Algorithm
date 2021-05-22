/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ11123;

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
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = { 0,-1, 0, 1};
    public static int h,w;
    
    public static int dfs(Pair root, StringBuilder[] land){
        land[root.x_].setCharAt(root.y_, '.');
        
        for (int i = 0; i < 4; i++) {
            Pair next = new Pair(root.x_ + dx[i], root.y_ + dy[i]);
            if(next.x_ < 0 || next.y_ < 0 || next.x_ >= h || next.y_ >= w) continue;
            
            if(land[next.x_].charAt(next.y_) == '#') dfs(next, land);
        }
        
        return 1;
    }
    
    public static int getSheeps(int h, int w, StringBuilder[] land){
        int sheep_cnt = 0;
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(land[i].charAt(j) == '#') sheep_cnt += dfs(new Pair(i,j), land);
            }
        }
        
        return sheep_cnt;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        
        while(test-- != 0){
            h = sc.nextInt();       //높이(세로)
            w = sc.nextInt();       //너비(가로)
            StringBuilder[] land = new StringBuilder[h];
            
            for (int i = 0; i < h; i++) land[i] = new StringBuilder(sc.next());
            
            System.out.println(getSheeps(h, w, land));
        }
    }
    
}
