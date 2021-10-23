/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kruskal.BOJ22116;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Edge implements Comparable<Edge>{
    int index_;
    int d_;

    public Edge(int n, int dis) {
        this.index_ = n;
        this.d_ = dis;
    }
    
    @Override
    public int compareTo(Edge e){return this.d_ - e.d_;}
}

class Dis{
    int d_;
    int prev_;

    public Dis(int dis_, int prev_) {
        this.d_ = dis_;
        this.prev_ = prev_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static final int INF = 1_000_000_001;
    public static int N;
    public static Dis[] dis;
    public static int[][] map;
    
    public static ArrayList<Edge>[] setEdge(int N){
        ArrayList<Edge>[] edge = new ArrayList[N*N];
        int[] dy = { 0,-1, 0, 1};
        int[] dx = {-1, 0, 1, 0};
        
        for (int i = 0; i < N*N; i++) edge[i] = new ArrayList<>();
        
        //index = (size * i) + j
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int index = (N * i) + j;
                
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                    
                    int nextIndex = (N * ny) + nx;
                    edge[index].add(new Edge(nextIndex, Math.abs(map[i][j] - map[ny][nx])));
                }
            }
        }
        
        return edge;
    }
    
    public static int dijkstra(int start, ArrayList<Edge>[] edge){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dis[start].d_ = dis[start].prev_ = 0;
        pq.add(new Edge(start, dis[start].d_));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            
            if(dis[cur.index_].d_ < cur.d_) continue;
            
            for (Edge e : edge[cur.index_]) {
                if(dis[e.index_].d_ > dis[cur.index_].d_ + e.d_){
                    dis[e.index_].d_ = dis[cur.index_].d_ + e.d_;
                    dis[e.index_].prev_ = cur.index_;
                    
                    pq.add(new Edge(e.index_, dis[e.index_].d_));
                }
            }
        }
        
        Dis node = dis[N*N-1];
        int maxHeight = 0;
        
        while(node.prev_ != 0){
            maxHeight = Math.max(maxHeight, Math.abs(node.d_ - dis[node.prev_].d_));
            node = dis[node.prev_];
        }
        
        return maxHeight;
    }
        
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        map = new int[N][N];
        dis = new Dis[N*N];
        
        for (int i = 0; i < N*N; i++) dis[i]= new Dis(INF, 0);
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) map[i][j] = sc.nextInt();

        System.out.println(dijkstra(0, setEdge(N)));
    }
}
