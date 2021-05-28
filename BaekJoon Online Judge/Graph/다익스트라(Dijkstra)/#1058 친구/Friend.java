/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ1058;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

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
    public static final int INF = 100;
    public static int[][] adj;
    public static int[] dis;
    
    
    public static int dijkstra(int root, int n){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dis[root] = 0;
        pq.offer(new Node(root, dis[root]));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.dis_ > dis[cur.index_]) continue;
            
            for (int i = 0; i < n; i++) {
                if(adj[cur.index_][i] != INF){
                    if(dis[i] > dis[cur.index_] + adj[cur.index_][i]){
                        dis[i] = dis[cur.index_] + adj[cur.index_][i];
                        pq.offer(new Node(i, dis[i]));
                    }
                }
            }
            
        }
        
        int friend_cnt = 0;
        
        for (int i = 0; i < n; i++) if(root != i && dis[i] != INF && dis[i] <= 2) friend_cnt++;
        return friend_cnt;
    }
    
    public static int getTwoFriends(int n){
        int twoFriends = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            dis = new int[n];
            Arrays.fill(dis, INF);
            
            twoFriends = Math.max(twoFriends, dijkstra(i, n));
        }
        
        return twoFriends;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       //사람 수
        
        
        adj = new int[n][n];

        for (int i = 0; i < n; i++) Arrays.fill(adj[i], INF);
        
        for (int i = 0; i < n; i++){
            String input = sc.next();
            for (int j = 0; j < input.length(); j++) {
                adj[i][j] = input.charAt(j) == 'Y' ? 1 : INF;
            }
        }
        
        System.out.println(getTwoFriends(n));
    }
}
