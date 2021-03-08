/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra.Baekjoon18352;

import java.util.ArrayList;
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
    public static final long INF = Long.valueOf("300000000000");
    public static ArrayList<Integer> adj[];
    public static long[] dis;
    
    public static String dijkstra(int start, int k){
        int city = adj.length;
        StringBuilder result = new StringBuilder();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dis[start] = 0;
        pq.offer(new Node(start, dis[start]));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.distance > dis[cur.index]) continue;
            
            for (Integer next : adj[cur.index]) {
                if(dis[next] > dis[cur.index] + 1){
                    dis[next] = dis[cur.index] + 1;
                    pq.add(new Node(next, dis[next]));
                }
            }
        }
        
        for (int i = 1; i < city; i++) {
            if(dis[i] == k) result.append(i).append("\n");
        }
        
        return result.length() == 0 ? "-1\n" : result.toString();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int city = sc.nextInt();
        int road = sc.nextInt();
        int k = sc.nextInt();
        int start = sc.nextInt();
        
        adj = new ArrayList[city + 1];
        dis = new long[city + 1];
        for (int i = 0; i < city + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        Arrays.fill(dis, INF);
        
        for (int i = 0; i < road; i++) {
            adj[sc.nextInt()].add(sc.nextInt());
        }
        System.out.print(dijkstra(start, k));
    }
    
}
