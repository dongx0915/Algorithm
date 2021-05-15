/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ13565;

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
    public static StringBuilder[] fiber;
    public static int[] dx = {0, -1, 1, 0};
    public static int[] dy = {-1, 0, 0, 1};
    public static int m,n;
    
    public static boolean dfs(Pair root){
        Stack<Pair> s = new Stack<>();
        
        s.push(root);
        fiber[root.x_].setCharAt(root.y_, '#');
        
        while(!s.isEmpty()){
            Pair cur = s.pop();
            
            for (int i = 0; i < 4; i++) {
                Pair next = new Pair(cur.x_ + dx[i], cur.y_ + dy[i]);
                
                if(next.x_ >= m - 1) return true;
                if(next.x_ < 0 || next.y_ < 0 || next.y_ >= n) continue;
                
                char next_ch = fiber[next.x_].charAt(next.y_);
                if(next_ch == '0'){
                    s.push(next);
                    fiber[next.x_].setCharAt(next.y_, '#');
                }
            }
        }
        
        //printMap();
        return false;
    }
    
    public static void printMap(){
        for (int i = 0; i < m; i++) {
            System.out.println(fiber[i]);
        }
        System.out.println("");
    }
    
    public static boolean isPermeable(){
        //visited 체크를 번호로하기
        for (int i = 0; i < n; i++) {
            if(fiber[0].charAt(i) == '0') if(dfs(new Pair(0,i))) return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();       //세로
        n = sc.nextInt();       //가로
        
        fiber = new StringBuilder[m];
        for (int i = 0; i < m; i++) fiber[i] = new StringBuilder(sc.next());
        
        if(isPermeable()) System.out.println("YES");
        else System.out.println("NO");
    }
    
}
