/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra.Baekjoon20007;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Neighbor implements Comparable<Neighbor>{
    int index;
    int distance;

    public Neighbor(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
    
    @Override
    public int compareTo(Neighbor o){
        return this.distance - o.distance;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static final int INF = 100000001;
    public static int[][] adj;
    public static int[] dis;
    
    public static void dijkstra(int home, int city){
        PriorityQueue<Neighbor> pq = new PriorityQueue<>();
        dis[home] = 0;
        
        pq.offer(new Neighbor(home, dis[home]));
        
        while(!pq.isEmpty()){
            Neighbor cur = pq.poll();
            if(cur.distance > dis[cur.index]) continue;
            
            for (int i = 1; i < city + 1; i++) {
                if(adj[cur.index][i] != INF){
                    if(dis[i] > dis[cur.index] + adj[cur.index][i]){
                        dis[i] = dis[cur.index] + adj[cur.index][i];
                        pq.offer(new Neighbor(i, dis[i]));
                    }
                }
            }
        }
    }

    public static Neighbor[] getNeighbor(int home, int city){
        dijkstra(home, city);
        
        Neighbor[] nb = new Neighbor[city];
        for (int i = 0; i < city; i++) nb[i] = new Neighbor(i, dis[i]);

        Arrays.sort(nb);
        
//        for (Neighbor neighbor : nb) {
//            System.out.print(neighbor.index + "번 집 : " + neighbor.distance + "\n");
//        }
        
        return nb;
    }
    
    public static int getMinimumDay(int home, int city, int x){
        Neighbor[] nb = getNeighbor(home, city);
        Queue<Neighbor> q = new LinkedList<>();
        int today = x;
        int day = 1;
        
        for (int i = 1; i < city; i++) q.offer(nb[i]);

        while(!q.isEmpty()){
            Neighbor cur = q.poll();
            //System.out.println(cur.index + "번 집 : " + cur.distance);
            if(cur.distance * 2 > x) return -1;  //하루에 갈 수 있는 최대 거리보다 먼 집이 나오면 -1
            
            //아예 갈 수 없는 곳이면 위의 if문에서 걸림
            //이까지 왔다는 것은 갈 수는 있으나 오늘 갈 수 없는 곳이라는 뜻
            //오늘 갈 수 있는 거리(남은 거리)보다 먼 집이 나오면 다른 날에 가도록 큐에 삽입해둠
            if(today < cur.distance * 2) q.offer(cur);
            
            today -= cur.distance * 2;           //오늘 이동한 거리를 뺌
            if(today <= 0){                      //하루 할당량이 다 찼으면 다음 날에감
                today = x;
                day++;
            }
        }

        return day;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int city = sc.nextInt();
        int road = sc.nextInt();
        int x = sc.nextInt();
        int home = sc.nextInt();
        
        adj = new int[city + 1][city + 1];
        dis = new int[city + 1];
        
        for (int i = 0; i < city + 1; i++) {
            Arrays.fill(adj[i], INF);
        }
        Arrays.fill(dis, INF);
        
        for (int i = 0; i < road; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a][b] = adj[b][a] = sc.nextInt();
        }
        
        System.out.println(getMinimumDay(home, city, x));
    }
    
}

