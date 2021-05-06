/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra.BOJ13424;

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
    public static final int INF = 100001;
    public static int[][] dis;
    public static int[][] adj;
    
    public static void dijkstra(int friend, int start){
        int n = adj.length;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dis[friend][start] = 0;
        pq.offer(new Node(start, dis[friend][start]));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.dis_ > dis[friend][cur.index_]) continue;
            
            for (int i = 0; i < n; i++) {
                if(adj[cur.index_][i] != INF){
                    if(dis[friend][i] > dis[friend][cur.index_] + adj[cur.index_][i]){
                        dis[friend][i] = dis[friend][cur.index_] + adj[cur.index_][i];
                        pq.offer(new Node(i, dis[friend][i]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        
        while(test-- != 0){
            int room = sc.nextInt();        //방 개수
            int road = sc.nextInt();        //비밀통로 개수 
            
            adj = new int[room + 1][room + 1];
            for (int i = 0; i < room + 1; i++) Arrays.fill(adj[i], INF);
            for (int i = 0; i < road; i++) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                
                adj[n1][n2] = adj[n2][n1] = sc.nextInt();
            }

            int friend = sc.nextInt();      //참여하는 친구 수
            
            dis = new int[friend][room + 1];
            for (int i = 0; i < friend; i++){
                Arrays.fill(dis[i], INF);
                dijkstra(i, sc.nextInt());
            }
            
            int min_dis = Integer.MAX_VALUE;
            int party_room = 1;
            
            for (int i = 1; i < room + 1; i++) {
                int sum = 0;
                for (int j = 0; j < friend; j++) if(dis[j][i] != INF) sum += dis[j][i];
                if(min_dis > sum){
                    min_dis = sum;
                    party_room = i;
                }
            }
            
            System.out.println(party_room);
        }
    }
    
}
