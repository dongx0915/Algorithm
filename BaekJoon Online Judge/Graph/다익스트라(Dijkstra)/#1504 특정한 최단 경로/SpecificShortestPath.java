/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra.Baekjoon1504;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Node implements Comparable<Node>{
    int index;
    int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
    
    @Override
    public int compareTo(Node o){
        return this.distance - o.distance;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static final int INF = 160000001;
    public static int[][] adj;
    
    
    public static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int n = adj.length;
        int[] dis = new int[n];
        
        Arrays.fill(dis, INF);
        
        dis[start] = 0;
        pq.offer(new Node(start, dis[start]));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.distance > dis[cur.index]) continue;
            
            for (int i = 1; i < n; i++) {
                if(adj[cur.index][i] != INF){
                    if(dis[i] > dis[cur.index] + adj[cur.index][i]){
                        dis[i] = dis[cur.index] + adj[cur.index][i];
                        pq.offer(new Node(i, dis[i]));
                    }
                }
            }
        }
        //System.out.printf("start[%d] to end[%d] = %d\n", start, end, dis[end]);
        return dis[end];
    }
    
    public static int getShortestPath(int start, int v1, int v2, int end){
        int r1 = dijkstra(start, v1) + dijkstra(v1, v2) + dijkstra(v2, end);
        int r2 = dijkstra(start, v2) + dijkstra(v2, v1) + dijkstra(v1, end);
        return Math.min(r1, r2) >= INF ? -1 : Math.min(r1, r2);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 2 <= N <= 800
        int e = sc.nextInt(); // 0 <= E <= 200,000
        adj = new int[n + 1][n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(adj[i], INF);
        }
        
        for (int i = 0; i < e; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int w = sc.nextInt();
            
            adj[n1][n2] = adj[n2][n1] = w;
        }
        
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        
        System.out.println(getShortestPath(1, v1, v2, n));
    }
    
}
