/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue.BOJ11866;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static String josephus(int n, int k){
        StringJoiner sj = new StringJoiner(", ", "<", ">");
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 1; i < n + 1; i++) q.add(i);
        
        while(!q.isEmpty()){
            for (int i = 0; i < k - 1; i++) if(!q.isEmpty()) q.offer(q.poll());
            
            sj.add(q.poll() + "");
        }
        
        return sj.toString();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        System.out.println(josephus(n,k));
    }
}
