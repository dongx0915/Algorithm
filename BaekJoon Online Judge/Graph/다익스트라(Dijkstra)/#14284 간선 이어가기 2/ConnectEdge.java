/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MST.BOJ14284;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Node implements Comparable<Node>{
    int index_;
    int dis_;

    public Node(int index, int dis) {
        this.index_ = index;
        this.dis_ = dis;
    }
    @Override
    public int compareTo(Node n){
        return this.dis_ - n.dis_;
    }
}

public class Main {
    /**
     * @param args the command line arguments
     */
    
    public static final int INF = 10000001;
    public static int[] dis;
    public static int[][] adj;
    
    public static int dijkstra(int s, int t, int n){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dis[s] = 0;
        pq.add(new Node(s, dis[s]));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.dis_ > dis[cur.index_]) continue;
            
            for (int i = 1; i < n + 1; i++) {
                if(adj[cur.index_][i] != INF){
                    //System.out.printf("(%d,%d) = %d\n", cur.index_, i, adj[cur.index_][i]);
                    if(dis[i] > adj[cur.index_][i] + dis[cur.index_]){
                        dis[i] = adj[cur.index_][i] + dis[cur.index_];
                        pq.offer(new Node(i, dis[i]));
                    }
                }
            }
        }

        return dis[t];
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       //정점의 개수
        int m = sc.nextInt();       //간선의 개수
        ArrayList<Node> edges = new ArrayList<>();
        
        dis = new int[n + 1];
        adj = new int[n + 1][n + 1];
        Arrays.fill(dis, INF);
        
        for (int[] is : adj) {
            Arrays.fill(is,INF);
        }
        for (int i = 0; i < m; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            //같은 노드를 잇지만 가중치가 다른 간선이 들어올 수 있음에 주의
            adj[node1][node2] = adj[node2][node1] = sc.nextInt();
        }

        int s = sc.nextInt();
        int t = sc.nextInt();
        
        System.out.println(dijkstra(s,t,n));
    }
    
}
