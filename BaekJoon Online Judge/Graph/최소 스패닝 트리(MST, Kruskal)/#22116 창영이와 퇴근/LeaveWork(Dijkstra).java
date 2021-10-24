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
    int idx_;
    int d_;

    public Edge(int n, int dis) {
        this.idx_ = n;
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
        dis[start].d_ = 0;
        dis[start].prev_ = -1; 
        /*
        * 이 부분을 -1로 해놓지 않으면 밑에 maxHeight 계산하는 부분에서 시작 노드를 게산하지 않게 됨
        * node.prev != 0 일 때만 반복문이 도는데 경로 상에서 2번 째 노드의 prev는 0(첫 번째 노드)이므로 두 번째 노드에서 반복문이 끊기게 됨
        */
        pq.add(new Edge(start, dis[start].d_));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            
            if(dis[cur.idx_].d_ < cur.d_) continue;
            
            for (Edge next : edge[cur.idx_]) {
                if(dis[next.idx_].d_ > Math.max(dis[cur.idx_].d_, next.d_)){
                    dis[next.idx_].d_ = Math.max(dis[cur.idx_].d_, next.d_);
                    //dis[next.idx_].prev_ = cur.idx_;
                    
                    pq.add(new Edge(next.idx_, dis[next.idx_].d_));
                }
            }
        }
        
//        Dis node = dis[N*N-1];
//        int maxHeight = 0;
//        
//        while(node.prev_ != -1){
//            System.out.println(node.prev_);
//            maxHeight = Math.max(maxHeight, Math.abs(node.d_ - dis[node.prev_].d_));
//            node = dis[node.prev_];
//        }
        
        return dis[N*N-1].d_;
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
