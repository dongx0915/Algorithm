/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ3187;
import java.util.Scanner;
import java.util.Stack;

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
    public static StringBuilder[] garden;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = { 0,-1, 0, 1};
    public static int wolf = 0;
    public static int sheep = 0;
    public static int r, c;
    
    public static void dfs(Pair root){
        Stack<Pair> s = new Stack<>();
                
        int wolf_cnt = 0;
        int sheep_cnt = 0;
        char root_char = garden[root.x_].charAt(root.y_);
        if(root_char == 'v') wolf_cnt++;
        else if(root_char == 'k') sheep_cnt++;
        
        s.add(root);
        garden[root.x_].setCharAt(root.y_, '@');
        
        while(!s.isEmpty()){
            Pair cur = s.pop();
            
            for (int i = 0; i < 4; i++) {
                Pair next = new Pair(cur.x_ + dx[i], cur.y_ + dy[i]);
                char next_char = garden[next.x_].charAt(next.y_);
                if(next.x_ < 0 || next.y_ < 0 || next.x_ >= r || next.y_ >= c) continue;
                if(next_char != '#' && next_char != '@'){
                    if (next_char == 'v') wolf_cnt++;
                    else if (next_char == 'k') sheep_cnt++;
                    s.add(next);
                    garden[next.x_].setCharAt(next.y_, '@');
                }
            }
        }
        
        if(sheep_cnt > wolf_cnt) sheep += sheep_cnt;
        else wolf += wolf_cnt;
    }
    
    public static void whosAlive(){
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char cur = garden[i].charAt(j);
                if(cur == 'v' || cur == 'k') dfs(new Pair(i,j));
            }
        }
        
        System.out.println(sheep + " " + wolf);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();       //행(세로)
        c = sc.nextInt();       //열(가로)
        
        garden = new StringBuilder[r];
        for (int i = 0; i < r; i++) garden[i] = new StringBuilder(sc.next());
        
        whosAlive();
    }
}
