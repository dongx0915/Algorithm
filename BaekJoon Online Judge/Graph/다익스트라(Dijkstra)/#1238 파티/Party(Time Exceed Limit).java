/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra.Baekjoon1238;

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
    public static final int INF = 10000001;
    public static int[][] adj;
    public static int[][] rev_adj;
    
    public static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        PriorityQueue<Node> rev_pq = new PriorityQueue<>();
        
        int n = adj.length;
        int[] dis = new int[n];
        int[] rev_dis = new int[n];
        
        Arrays.fill(dis, INF);
        Arrays.fill(rev_dis, INF);

        dis[start] = 0;
        pq.offer(new Node(start, dis[start]));
        
        rev_dis[start] = 0;
        rev_pq.offer(new Node(start, rev_dis[start]));
        
        Node cur = null;
        Node rev_cur = null;
        
        while(!pq.isEmpty() && !rev_pq.isEmpty()){
            if(!pq.isEmpty()) cur = pq.poll();
            
            if(cur.distance <= dis[cur.index]){
                for (int i = 1; i < n; i++) {
                    if (adj[cur.index][i] != INF) {
                        if (dis[i] > dis[cur.index] + adj[cur.index][i]) {
                            dis[i] = dis[cur.index] + adj[cur.index][i];
                            pq.offer(new Node(i, dis[i]));
                        }
                    }
                }
            }
            
            if(!rev_pq.isEmpty()) rev_cur = rev_pq.poll();
            //System.out.println("rev index = " + rev_cur.index + " " + rev_dis[rev_cur.index]);
            
            if(rev_cur.distance <= rev_dis[rev_cur.index]){
                for (int i = 1; i < n; i++) {
                    if (rev_adj[rev_cur.index][i] != INF) {
                        if (rev_dis[i] > rev_dis[rev_cur.index] + rev_adj[rev_cur.index][i]) {
                            rev_dis[i] = rev_dis[rev_cur.index] + rev_adj[rev_cur.index][i];
                            rev_pq.offer(new Node(i, rev_dis[i]));
                        }
                    }
                }
            }
        }
        
//        System.out.println(start + " -> " + end);
//        for (int di : dis) {
//            System.out.print(di +  " ");
//        }
//        System.out.println("");
        
//        System.out.println(start + " -> " + end);
//        for (int di : dis) {
//            System.out.print(di + " ");
//        }
//        System.out.println("");
//        
//        System.out.println("rev : ");
//        for (int rev_di : rev_dis) {
//            System.out.print(rev_di + " ");
//        }
//        
//        System.out.println("");
//        System.out.println(dis[end] + rev_dis[end]);
//        System.out.println("");
        
        return dis[end] + rev_dis[end];
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();           //학생 수(마을 수)
        int m = sc.nextInt();           //도로 개수(단방향)
        int end = sc.nextInt();
        int max_required = -1;
        
        adj = new int[n + 1][n + 1];
        rev_adj = new int[n + 1][n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(adj[i], INF);
            Arrays.fill(rev_adj[i], INF);
        }
        
        for (int i = 0; i < m; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int w = sc.nextInt();
            
            adj[n1][n2] = Math.min(adj[n1][n2], w);
            rev_adj[n2][n1] = Math.min(rev_adj[n2][n1], w);
        }
        
        for (int i = 1; i < n + 1; i++) {
            max_required = Math.max(max_required, dijkstra(i, end));
        }
        
        System.out.println(max_required);
    }
    
}
