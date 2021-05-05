/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra.BOJ10282;

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
    int sec_;

    public Node(int index_, int sec_) {
        this.index_ = index_;
        this.sec_ = sec_;
    }
    
    @Override
    public int compareTo(Node n){
        return this.sec_ - n.sec_;
    }
}

public class Main {
    public static final int INF = 100000001;
    public static int[] dis;
    public static ArrayList<Node>[] adj;
    
    public static String hack(int c){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int hacked_com = 0;
        int length = adj.length;
        dis[c] = 0;
        pq.offer(new Node(c, dis[c]));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.sec_ > dis[cur.index_]) continue;
            
            for (Node next : adj[cur.index_]) {
                if(dis[next.index_] > dis[cur.index_] + next.sec_){
                    dis[next.index_] = dis[cur.index_] + next.sec_;
                    pq.add(new Node(next.index_, dis[next.index_]));
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if(dis[i] != INF) {
                hacked_com++;
                if(max < dis[i]) max = dis[i];
            }
        }
        
        return hacked_com + " " + max;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while(test-- != 0){
            int n = sc.nextInt();       //컴퓨터 개수
            int d = sc.nextInt();       //의존성(간선) 개수
            int c = sc.nextInt();       //해킹당한 컴퓨터의 번호
            
            dis = new int[n + 1];
            Arrays.fill(dis, INF);
            
            adj = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++) adj[i] = new ArrayList<>();

            for (int i = 0; i < d; i++) {
                int dependCom = sc.nextInt();
                int rootCom = sc.nextInt();

                adj[rootCom].add(new Node(dependCom, sc.nextInt()));
            }
            
            System.out.println(hack(c));
        }
    }
}
