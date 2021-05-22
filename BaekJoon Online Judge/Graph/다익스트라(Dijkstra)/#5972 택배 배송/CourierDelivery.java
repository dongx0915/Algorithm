/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra.BOJ5972;

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

    public Node(int index_, int dis_) {
        this.index_ = index_;
        this.dis_ = dis_;
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
    public static final int INF = 50000001;
    public static int[] dis;
    public static ArrayList<ArrayList<Node>> map;
    
    public static int dijkstra(int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dis[1] = 0;
        pq.offer(new Node(1, dis[1]));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.dis_ > dis[cur.index_]) continue;
            
            for (Node node : map.get(cur.index_)) {
                if(dis[node.index_] > dis[cur.index_] + node.dis_){
                    dis[node.index_] = dis[cur.index_] + node.dis_;
                    pq.offer(new Node(node.index_, dis[node.index_]));
                }
            }
        }
        
        return dis[end];
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       //헛간(노드) 개수
        int m = sc.nextInt();       //간선 정보
        
        dis = new int[n + 1];
        map = new ArrayList<>();
        
        Arrays.fill(dis, INF);
        for (int i = 0; i < n + 1; i++) map.add(new ArrayList<>());
        
        for (int i = 0; i < m; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int w = sc.nextInt();
            
            map.get(n1).add(new Node(n2, w));
            map.get(n2).add(new Node(n1, w));
        }
        
        System.out.println(dijkstra(n));
    }
    
}
