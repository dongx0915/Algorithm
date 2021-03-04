/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

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
    public static final int N = 6;
    public static final int INF = 1000000000;
    public static int[] dis = new int[N];
    public static int[][] adj = {
        {0, 2, 5, 1, INF, INF},
        {2, 0, 3, 2, INF, INF},
        {5, 3, 0, 3, 1, 5},
        {1, 2, 3, 0, 1, INF},
        {INF, INF, 1, 1, 0, 2},
        {INF, INF, 5, INF, 2, 0},
    };
    
    
    public static int[] dijkstra(int start){
        Arrays.fill(dis,INF);
        dis[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, dis[start]));
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(now.distance > dis[now.index]) continue;
            
            for (int i = 0; i < N; i++) {
                if(adj[now.index][i] != INF){
                    if(dis[i] > dis[now.index] + adj[now.index][i]){
                        dis[i] = dis[now.index] + adj[now.index][i];
                        pq.add(new Node(i, dis[i]));
                    }
                }
            }
        }
        
        return dis;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] dis = dijkstra(0);
        for (int di : dis) {
            System.out.print(di + " ");
        }
    }
}

/*
* 출력 : 0 2 3 1 2 4
*/
