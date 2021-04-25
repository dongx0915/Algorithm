/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.BOJ7562;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Posit{
    int x_;
    int y_;

    public Posit(int x_, int y_) {
        this.x_ = x_;
        this.y_ = y_;
    }
    
    @Override
    public boolean equals(Object o){
        Posit p = (Posit)o;
        return (this.x_ == p.x_ && this.y_ == p.y_);
    }
    
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int[] dx = {-2, -1,  1,  2, 2, 1,-1,-2};
    public static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static boolean[][] visited;
    
    public static int bfs(Posit cur, Posit goal, int l){
        Queue<Posit> q = new LinkedList<>();
        Queue<Integer> cnt_q = new LinkedList<>();
        
        q.add(cur);
        cnt_q.add(0);
        visited[cur.x_][cur.y_] = true;
        
        while(!q.isEmpty()){
            Posit now = q.poll();
            int cnt = cnt_q.poll();
            
            //if(now.x_ == goal.x_ && now.y_ == goal.y_) return cnt;
            if(now.equals(goal)) return cnt;    //클래스의 equals 메소드는 저장 된 데이터가 아닌 객체가 같은지 비교를하므로 오버라이딩하여 재정의
            
            for (int i = 0; i < 8; i++) {
                Posit next = new Posit(now.x_ + dx[i], now.y_ + dy[i]);
                
                if(next.x_ < 0 || next.x_ >= l || next.y_ < 0 || next.y_ >= l) continue;
                if(!visited[next.x_][next.y_]){
                    q.add(next);
                    cnt_q.add(cnt + 1);
                    visited[next.x_][next.y_] = true;
                }
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here\
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        
        while(test-- != 0){
            int l = sc.nextInt();       //체스판의 길이
            visited = new boolean[l][l];
            
            Posit cur = new Posit(sc.nextInt(), sc.nextInt());
            Posit goal = new Posit(sc.nextInt(), sc.nextInt());
            
            System.out.println(bfs(cur, goal, l));
        }
    }
    
}
