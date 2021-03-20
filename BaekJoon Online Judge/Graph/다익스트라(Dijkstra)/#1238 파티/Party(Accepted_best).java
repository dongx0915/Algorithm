/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra.Baekjoon1238;

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
    public static int[] dijkstra(int start, int[][] adj){
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
        
        return dis;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();           //학생 수(마을 수)
        int m = sc.nextInt();           //도로 개수(단방향)
        int end = sc.nextInt();
        int max_required = -1;
        
        int[][] adj = new int[n + 1][n + 1];
        int[][] rev_adj = new int[n + 1][n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(adj[i], INF);
            Arrays.fill(rev_adj[i], INF);
        }
        
        for (int i = 0; i < m; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int w = sc.nextInt();
            
            adj[n1][n2] = Math.min(adj[n1][n2], w);
            rev_adj[n2][n1] = Math.min(rev_adj[n2][n1], w);
        }
        
        int[] dis = dijkstra(end, adj);
        int[] rev_dis = dijkstra(end, rev_adj);
        
        for (int i = 1; i < n + 1; i++) {
            max_required = Math.max(dis[i] + rev_dis[i], max_required);
        }
        
        System.out.println(max_required);
    }
    
}
