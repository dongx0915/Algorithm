/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.BOJ14395;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Operator{
    Operator prev_;
    int cur_;

    public Operator(Operator prev, char cur) {
        this.prev_ = prev;
        this.cur_ = cur;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static char[] oper = {'*', '+', '-', '/'};
    
    public static String bfs(int s, int t){
        Queue<Integer> q = new LinkedList<>();
        Queue<Operator> oper_q = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        
        q.add(s);
        oper_q.add(new Operator(null, ' '));
        
        while(!q.isEmpty()){
            int now_s = q.poll();
            Operator now_oper = oper_q.poll();
            //System.out.println("now = " + now_s + " now_oper = " + (char)now_oper.cur_ + " prev = " + now_oper.prev_);
            
            if(now_s == t){
               //System.out.println("now_oper = " + (char)now_oper.cur_ + " prev = " + now_oper.prev_);
               while(now_oper.prev_ != null){
                   result.append((char)now_oper.cur_);
                   now_oper = now_oper.prev_;
               }   
               return result.reverse().toString();
            }
            
            
            if(now_s == 0 || now_s > 1000000000 || now_s < 0) continue;
            
            if(now_s > 1) {
                q.add(now_s * now_s);
                oper_q.add(new Operator(now_oper, '*'));
            }
            
            
            q.add(now_s + now_s);
            oper_q.add(new Operator(now_oper, '+'));
            
            q.add(now_s - now_s);
            oper_q.add(new Operator(now_oper, '-'));
            
            if(now_s != 0){
                q.add(now_s / now_s);
                oper_q.add(new Operator(now_oper, '/'));
            }
            
        }
        
        return "-1";
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int t = sc.nextInt(); //s > t로 바꿔야함
        //큰 수가 작은 수의 배수이면 변환 가능
        
        if(s == t) System.out.println("0");
        else System.out.println(bfs(s, t));

    }
    
}
