/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra.Baekjoon1446;

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
    
    static int[] dis;
    static int[][] shortcut;
    static final int INF = 100000001;
    
    public static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dis[start] = 0;
        pq.offer(new Node(start, dis[start]));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.distance > dis[cur.index]) continue;
            
            for (int i = 0; i < 10000; i++) {
                if(shortcut[cur.index][i] != INF){
                    if(dis[i] > dis[cur.index] + shortcut[cur.index][i]){
                        dis[i] = dis[cur.index] + shortcut[cur.index][i];
                        pq.offer(new Node(i, dis[i]));
                    }
                }
            }
        }
        
        return dis[end];
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //지름길 개수
        int d = sc.nextInt();  //고속도로 길이
        int start, end, short_d;
        
        //ArrayList<Node> shortcut[] = new ArrayList[10000];
        shortcut = new int[10000][10000];
        dis = new int[10000];
        
        for (int i = 0; i < 10000; i++) {
            Arrays.fill(shortcut[i], INF);
        }
        Arrays.fill(dis, INF);
        
        for (int i = 0; i < n; i++) {
            start = sc.nextInt();
            end = sc.nextInt();
            short_d = sc.nextInt();
            
            shortcut[start][end] = Math.min(shortcut[start][end], short_d);
        }
        
        System.out.println(dijkstra(0, d));
    }
    
}
