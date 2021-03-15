/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra.Baekjoon11779;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Dis{
    int distance;
    ArrayList<Integer> path;

    public Dis(int distance) {
        this.distance = distance;
        this.path = new ArrayList<>();
    }
}

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
    public static final int INF = 100000001;
    public static int[][] adj;
    public static Dis[] dis;
    
    public static void dijkstra(int start, int end){
        int n = adj.length;
        StringJoiner sj = new StringJoiner(" ");
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dis[start].distance = 0;
        pq.add(new Node(start, dis[start].distance));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.distance > dis[cur.index].distance) continue;
            
            for (int i = 1; i < n; i++) {
                if(adj[cur.index][i] != INF){
                    if(dis[i].distance > dis[cur.index].distance + adj[cur.index][i]){
                        dis[i].distance = dis[cur.index].distance + adj[cur.index][i];
                        
                        dis[i].path = dis[cur.index].path;
                        if(!dis[i].path.contains(cur.index)) dis[i].path.add(cur.index);
                        
                        pq.offer(new Node(i, dis[i].distance));
                    }
                }
            }
        }
        if(!dis[end].path.contains(end)) dis[end].path.add(end);
        System.out.println(dis[end].distance);
        System.out.println(dis[end].path.size());
        dis[end].path.forEach(i -> {
            sj.add(i + "");
        });
        System.out.println(sj.toString());
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int city = sc.nextInt();
        int bus = sc.nextInt();
        adj = new int[city + 1][city + 1];
        dis = new Dis[city + 1];
        
        for (int[] is : adj) {
            Arrays.fill(is, INF);
        }
//        for (Dis di : dis) {
//            di = new Dis(INF);
//        }
        
        for (int i = 0; i < city + 1; i++) {
            dis[i] = new Dis(INF);
        }
        for (int i = 0; i < bus; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a][b] = Math.min(adj[a][b], sc.nextInt());
            
        }
        
        int start = sc.nextInt();
        int end = sc.nextInt();
        //System.out.println(dis[start].distance);
        dijkstra(start, end);
        
    }
    
}
