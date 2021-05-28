/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ19542;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<ArrayList<Integer>> adj;
    public static boolean[] visited;
    public static int N,S,D;
    public static int maxPath = 0;
    
    public static void dfs(int root, int cnt){
        visited[root] = true;
        maxPath = Math.max(maxPath, cnt);
        
        for (Integer child : adj.get(root)) {
            if(!visited[child]) dfs(child, cnt + 1);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();       //노드 수
        S = sc.nextInt();       //케니소프트의 위치
        D = sc.nextInt();       //힘
        
        visited = new boolean[N + 1];
        adj = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) adj.add(new ArrayList<>());
        
        for (int i = 0; i < N - 1; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }
        
        if(N == 1) System.out.println("0");
        else{dfs(S, 0);
            if(maxPath - D < maxPath - 1) System.out.println("1");
            else System.out.println((maxPath-D) * 2);
        }
    }
    
}
