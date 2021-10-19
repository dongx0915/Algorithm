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
class Edge {
    int index_;
    int d_;

    public Edge(int n, int dis) {
        this.index_ = n;
        this.d_ = dis;
    }
//    
//    @Override
//    public int compareTo(Edge e){
//        return this.dis_ - e.dis_;
//    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static final int INF = 1_000_000_001;
    public static int[] dis;
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
                    int nextIndex = (N * ny) + nx;
                    
                    if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                    edge[index].add(new Edge(nextIndex, Math.abs(map[i][j] - map[ny][nx])));
                }
            }
        }
        
        return edge;
    }
    
    public static void dijkstra(int start, ArrayList<Edge>[] edge){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dis[start] = 0;
        pq.add(new Edge(start, dis[start]));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            
            if(dis[cur.index_] < cur.d_) continue;
            
            for (Edge e : edge[cur.index_]) {
                
            }
        }
    }
        
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        map = new int[N][N];
        dis = new int[N];
        
        Arrays.fill(dis, INF);
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
    }
}
