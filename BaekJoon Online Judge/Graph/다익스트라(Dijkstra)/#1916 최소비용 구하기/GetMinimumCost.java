/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra.Baekjoon1916;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Node implements Comparable<Node>{
    int index;
    long distance;

    public Node(int index, long distance) {
        this.index = index;
        this.distance = distance;
    }
    
    @Override
    public int compareTo(Node o){
        return (int)(this.distance - o.distance);
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static final int INF = 1000000000;
    public static long[][] adj;
    public static long[] dis;
    public static long dijkstra(int n, int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dis[start] = 0;
        pq.add(new Node(start, dis[start]));
        
        while(!pq.isEmpty()){
            Node current = pq.poll();
            
            if(current.distance > dis[current.index]) continue;
            
            for (int i = 1; i <= n; i++) {
                if(adj[current.index][i] != INF){
                    if(dis[i] > dis[current.index] + adj[current.index][i]){
                        dis[i] = dis[current.index] + adj[current.index][i];
                        pq.add(new Node(i, dis[i]));
                    }
                }
            }
        }
        
        return dis[end];
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int cities = sc.nextInt();
        int bus = sc.nextInt();
        adj = new long[cities + 1][cities + 1];
        dis = new long[cities + 1];
        
        for (int i = 0; i < cities + 1; i++) {
            Arrays.fill(adj[i], INF);
        }
        Arrays.fill(dis, INF);
        
        for (int i = 0; i < bus; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int pay = sc.nextInt();
            adj[s][e] = Math.min(adj[s][e], pay);
            //adj[sc.nextInt()][sc.nextInt()] = sc.nextInt();     
        }
        
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        System.out.println(dijkstra(cities, start, end));
    }
    
}
