/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.Baekjoon11403;

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
    
    public static boolean bfs(int n, int start, int end, int[][] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for (int i = 0; i < n; i++) {
                if(graph[now][i] == 1){
                    if(i == end) return true;
                    if (!visited[i]) {
                        q.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public static void findRoute(int n, int[][] graph){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean result = bfs(n,i,j,graph);
                if(result) graph[i][j] = 1;
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        
        findRoute(n, graph);
        for (int[] is : graph) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
    
}
