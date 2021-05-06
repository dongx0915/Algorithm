/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.BOJ11725;

import java.util.ArrayList;
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
    public static ArrayList<Integer>[] adj;
    public static boolean[] visited;
    
    public static void findParent(int n){
        int[] parent = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(1);
        visited[1] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for (Integer next : adj[now]) {
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                    parent[next] = now;
                }
            }
        }
        
        for (int i = 2; i < n + 1; i++) {
            System.out.println(parent[i]);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) adj[i] = new ArrayList<>();
        
        for (int i = 0; i < n - 1; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            adj[n1].add(n2);
            adj[n2].add(n1);
        }
        
        findParent(n);
    }
    
}
