/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.BOJ6118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Edge implements Comparable<Edge>{
    int index_;
    int dis_;

    public Edge(int index_, int dis_) {
        this.index_ = index_;
        this.dis_ = dis_;
    }
    
    @Override
    public int compareTo(Edge e){
        return this.dis_ - e.dis_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int N,M;
    public static final int INF = 20000 * 50000 + 1;
    public static int[] dis;
    public static ArrayList<Integer>[] node;
    
    public static int dijkstra(int N){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        
        //1부터 시작
        pq.add(new Edge(1, dis[1] = 0));
            
        int max_dis = -1;
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            
            if(cur.dis_ > dis[cur.index_]) continue;
            
            for (Integer next : node[cur.index_]) {
                if(visited[next]) continue;
                if(dis[next] > dis[cur.index_] + 1){
                    dis[next] = dis[cur.index_] + 1;
                    max_dis = Math.max(max_dis, dis[next]);
                    
                    visited[next] = true;
                    pq.add(new Edge(next, dis[next]));
                }
            }
        }
        
        return max_dis;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();      //헛간(노드)의 개수
        M = sc.nextInt();      //길(간선)의 개수
        dis = new int[N+1];
        node = new ArrayList[N+1];
        
        Arrays.fill(dis, INF);
        for (int i = 0; i < N+1; i++) node[i] = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            node[a].add(b);
            node[b].add(a);
        }
        
        int max_dis = dijkstra(N);      //다익스트라로 최단 거리
        ArrayList<Integer> barn = new ArrayList<>();

        for (int i = 0; i < N+1; i++) if(dis[i] == max_dis) barn.add(i);
        
        System.out.println(barn.get(0) + " " + max_dis + " " + barn.size());
        
    }
    
}
