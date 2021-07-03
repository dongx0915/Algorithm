/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.BOJ14395;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Donghyeon <20183188>
 */
class Operator{
    Operator prev_;
    char cur_;
    long s_;
    
    public Operator(Operator prev, char cur, long s) {
        this.prev_ = prev;
        this.cur_ = cur;
        this.s_ = s;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static String bfs(long s, int t){
        Queue<Operator> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        Set<Long> visited = new HashSet<>();
        char[] oper = {'*', '+', '-', '/'};
        
        q.add(new Operator(null, ' ', s));
        visited.add(s);
        
        while(!q.isEmpty()){
            Operator now = q.poll();

            if(now.s_ == 0 || now.s_ < 0) continue;
            if(now.s_ == t){
               while(now.prev_ != null){
                   result.append(now.cur_);
                   now = now.prev_;
               }   
               return result.reverse().toString();
            }
            
            long[] value = {now.s_ * now.s_, now.s_ + now.s_, 0, 1};
            
            for (int i = 0; i < 4; i++) {
                if(value[i] <= t && !visited.contains(value[i])){
                    visited.add(value[i]);
                    q.add(new Operator(now, oper[i], value[i]));
                }
            }
        }
        
        return "-1";
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        long s = sc.nextInt();
        int t = sc.nextInt(); //s > t로 바꿔야함
        //큰 수가 작은 수의 배수이면 변환 가능
        
        if(s == t) System.out.println("0");
        else System.out.println(bfs(s, t));
    }
}
