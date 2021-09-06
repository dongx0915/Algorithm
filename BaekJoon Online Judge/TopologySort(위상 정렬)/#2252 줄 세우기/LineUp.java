/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TopologySort.BOJ2252;

import java.util.ArrayList;
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
    public static int N,M;
    public static boolean[] visited;
    public static StringJoiner result = new StringJoiner(" ");
    
    public static void topologySort(ArrayList<Integer>[] graph, int[] di, int first){
        Queue<Integer> q = new LinkedList<>();
        visited[first] = true;
        q.offer(first);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;
            result.add((cur+1)+"");
            
            for (Integer next : graph[cur]) {
                if(visited[next]) continue;
                if(--di[next] == 0) q.add(next);
            }
        }
    }
    
    public static void SortByHeight(ArrayList<Integer>[] graph, int[] di){
        for (int i = 0; i < N; i++) if(di[i] == 0 && !visited[i]) topologySort(graph, di, i);
        System.out.println(result);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N];
        
        int[] di = new int[N];
        ArrayList<Integer>[] graph = new ArrayList[N];
        
        
        
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            int s1 = sc.nextInt()-1;
            int s2 = sc.nextInt()-1;
            graph[s1].add(s2);
            di[s2]++;
        }
        
        SortByHeight(graph, di);
    }
    
}
