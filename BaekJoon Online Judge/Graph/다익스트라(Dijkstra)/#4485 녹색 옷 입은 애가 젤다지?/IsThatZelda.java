/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra.Baekjoon4485;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Node implements Comparable<Node>{
    int x;
    int y;
    int distance;

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
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
    public static final int INF = 1000000;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    
    public static int dijkstra(int[][] map, int[][] dis){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int n = map.length;
        dis[0][0] = map[0][0];
        pq.offer(new Node(0, 0, dis[0][0]));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.distance > dis[cur.x][cur.y]);
            
            for (int i = 0; i < 4; i++) {
                Node next = new Node(cur.x + dx[i], cur.y + dy[i], -1);
                if(next.x < 0 || next.x >= n || next.y < 0 || next.y >= n) continue;
                next.distance = map[next.x][next.y];
                
                if(dis[next.x][next.y] > dis[cur.x][cur.y] + next.distance){
                    dis[next.x][next.y] = dis[cur.x][cur.y] + next.distance;
                    next.distance = dis[next.x][next.y];
                    pq.offer(next);
                }
            }
        }
        
        return dis[n-1][n-1];
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n;
        
        for(int i = 1;;i++){
            n = sc.nextInt();
            if(n == 0) break;
            int[][] map = new int[n][n];
            int[][] dis = new int[n][n];
            for (int j = 0; j < n; j++) {
                Arrays.fill(dis[j], INF);
            }
            
            for (int k = 0; k < n; k++) {
                for (int s = 0; s < n; s++) {
                    map[k][s] = sc.nextInt();
                }
            }
            System.out.println("Problem " + i + ": " + dijkstra(map, dis));
        }
    }   
}
