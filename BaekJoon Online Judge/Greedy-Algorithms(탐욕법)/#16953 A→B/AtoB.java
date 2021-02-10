/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bfs.Baekjoon16953;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static long convert(long a, long b){       
        Queue<Long> q = new LinkedList<>();
        Queue<Long> cnt_q = new LinkedList<>();
        
        q.add(a);
        cnt_q.add(Long.parseLong("1"));
        
        while(!q.isEmpty()){
            long now = q.poll();
            long cnt = cnt_q.poll();
            
            if(now == b) {
                return cnt;
            }
            
            long next = now * 2;
            if(next <= b){
                q.add(now * 2);
                cnt_q.add(cnt + 1);
            }
            
            next = (now * 10) + 1;
            if(next <= b){
                q.add((now * 10) + 1);
                cnt_q.add(cnt + 1);
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();

        System.out.println(convert(a, b));
    }
    
}
