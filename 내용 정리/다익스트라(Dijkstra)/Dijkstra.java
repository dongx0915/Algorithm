/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static final int INF = Integer.MAX_VALUE;
    public static int[][] dis = {
        {0, 2, 5, 1, INF, INF},
        {2, 0, 3, 2, INF, INF},
        {5, 3, 0, 3, 1, 5},
        {1, 2, 3, 0, 1, INF},
        {INF, INF, 1, 1, 0, 2},
        {INF, INF, 5, INF, 2, 0},
    };

    public static int getClosestNode(int n, int[] value, boolean[] v){
        int min_index = 0;
        int min_value = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if(value[i] < min_value && !v[i]){
                min_value = value[i];
                min_index = i;
            }
        }
        System.out.println("min = " + (min_index + 1));
        
        return min_index;
    }
    
    public static int[] dijkstra(int start, int n){
        int[] value = dis[start]; //root 노드에서의 최소 거리
        int v_cnt = 1;
        boolean[] v = new boolean[n];
        v[start] = true;
        
        System.out.println("value : ");
        for (int i : value) {
            System.out.print(i + " ");
        }
        System.out.println("");

        for (int j = 0; j < n-2; j++) {
            int now = getClosestNode(n, value, v);
            v[now] = true;
            
            for (int i = 0; i < n; i++) {
                //if(i == now) continue;
                if(dis[now][i] != INF){ //현재 노드(now)와 이어진 노드라면     
                    value[i] = Math.min(value[i], value[now] + dis[now][i]);
                }
            }
        }

        
        return value;
    }
        
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 6;
        int[] value = dijkstra(0, n);
        
        for (int i : value) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
}
