/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ1240;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Donghyeon <20183188>
 */


public class Main {

    /**
     * @param args the command line arguments
     */
    public static int n,m;
    public static int[][] adj;
    public static boolean[] visited;
    public static int[][] dist; //노드 사이의 거리
    
    public static void dfs(int start, int next, int dis){
        dist[start][next] = dis;
        
        for (int i = 1; i < n + 1; i++) {
            if(!visited[i] && adj[next][i] != -1){
                visited[i] = true;
                dfs(start, i, dis + adj[next][i]);
            }
        }
        
    }
    
    public static void printDis(){
        System.out.print("  ");
        
        for (int i = 1; i < n + 1; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println("");

        for (int i = 1; i < n + 1; i++) {
            System.out.print(i + "|");
            for (int j = 1; j < n + 1; j++) {
                System.out.printf("%3d", dist[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();       //노드 개수 (간선은 n - 1개)
        m = sc.nextInt();       //노드 쌍의 개수
        
        adj = new int[n + 1][n + 1];
        dist = new int[n + 1][n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(adj[i], -1);
            Arrays.fill(dist[i], -1);
        }
        
        for (int i = 0; i < n - 1; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            adj[n1][n2] = adj[n2][n1] = sc.nextInt();
        }
        
        for (int i = 1; i < n + 1; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, i, 0);
        }
        
        //printDis();
        
        for (int i = 0; i < m; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            System.out.println(dist[n1][n2]);
        }
        
    }
    
}
