/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra.Baekjoon14496;

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
    public static final int INF = 10000001;
    public static int[][] adj;
    public static int[] dis;
    
    public static int dijkstra(int start, int end){
        int n = adj.length - 1;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dis[start] = 0;
        pq.add(new Node(start, dis[start]));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.distance > dis[cur.index]) continue;
            
            for (int i = 1; i < n + 1; i++) {
                if(adj[cur.index][i] != INF){
                    if(dis[i] > dis[cur.index] + adj[cur.index][i]){
                        dis[i] = dis[cur.index] + adj[cur.index][i];
                        pq.add(new Node(i, dis[i]));
                    }
                }
            }
        }
        
        return dis[end] == INF ? -1 : dis[end];
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int start = sc.nextInt();
        int end = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        adj = new int[n+1][n+1];
        dis = new int[n+1];
        
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(adj[i], INF);
        }
        Arrays.fill(dis, INF);
        
        for (int i = 0; i < m; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            
            adj[n1][n2] =  adj[n2][n1] = 1;
        }
        
        System.out.println(dijkstra(start, end));
    }
    
}
