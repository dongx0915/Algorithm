/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.Baekjoon13913;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringJoiner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Node{
    int posit;
    int prev;

    public Node(int posit, int prev) {
        this.posit = posit;
        this.prev = prev;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int[][] dp = {
        {-1, 1},
        { 1, 1}, 
        { 0, 2},
    };
    // Xi = (now.x + dx) * dy;
    public static boolean[] visited = new boolean[100001];
    public static int[] from = new int[100001];
    
    public static String getTimeAndPath(int n, int k){
        StringJoiner sj = new StringJoiner("\n");
        Queue<Node> q = new LinkedList<>();
        Queue<Integer> cnt_q = new LinkedList<>();
        int cnt = 0;
        
        q.add(new Node(n, -1));
        from[n] = -1;
        visited[n] = true;
        cnt_q.add(cnt);
        
        while(!q.isEmpty()){
            Node now = q.poll();
            cnt = cnt_q.poll();
            
            if(now.posit == k) {
                sj.add(cnt + "");
                sj.add(getOpticalPath(now.posit));
            }
            
            for (int i = 0; i < 3; i++) {
                Node next = new Node((now.posit + dp[i][0]) * dp[i][1], now.posit);
                if(next.posit > 100000 || next.posit < 0) continue;
                if(visited[next.posit]) continue;
                
                q.add(next);
                cnt_q.add(cnt + 1);
                visited[next.posit] = true;
                from[next.posit] = next.prev;
            } 
        }
        return sj.toString();
    }
    
    public static String getOpticalPath(int posit){
        StringJoiner sj = new StringJoiner(" ");
        Stack<Integer> stack = new Stack<>();
        
        while(posit != -1){
            stack.push(posit);
            posit = from[posit];
        }
        
        while(!stack.isEmpty()) sj.add(stack.pop() + "");
        return sj.toString();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //수빈이의 위치
        int k = sc.nextInt(); //동생의 위치
        
        System.out.println(getTimeAndPath(n, k));
    }
}
