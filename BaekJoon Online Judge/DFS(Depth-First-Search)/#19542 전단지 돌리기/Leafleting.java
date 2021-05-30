/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ19542;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int N,S,D;
    public static ArrayList<ArrayList<Integer>> adj;
    public static int[] disToReaf;
    public static boolean[] visited;
    
    public static int setDisToReaf(int root, int cnt){
        int depth = 0;
        
        for (Integer child : adj.get(root)) {
            if(visited[child]) continue;
            visited[child] = true;
            depth = setDisToReaf(child, cnt);
            disToReaf[root] = Math.max(disToReaf[root], depth);
            visited[child] = false;
        }
        
        return disToReaf[root] + 1;
    }
    
    public static int dfs(int root, int dis){
        for (Integer child : adj.get(root)) {
            if(visited[child] || disToReaf[child] < D) continue;
            visited[child] = true;
            dis = dfs(child, dis + 1);
        }
        
        return dis;
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);     //노드의 개수
        S = Integer.parseInt(input[1]);       //케니소프트의 위치
        D = Integer.parseInt(input[2]);       //힘
        
        disToReaf = new int[N + 1];
        visited = new boolean[N + 1];
        
        adj = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) adj.add(new ArrayList<>());
        
        for (int i = 0; i < N - 1; i++) {       //양방향으로 만들지 않으면 루트가 1이 아닐 때 오답이 나올 수 있음
            input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);
            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }
        
        visited[S] = true;
        setDisToReaf(S, 0);

        System.out.println(dfs(S, 0) * 2);
    }
    
}
