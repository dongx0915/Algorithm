/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floyd_Warshall;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static final int INF = 10000000;
    
    public static int[][] graph = {
        {0,   5,   INF, 8},
        {7,   0,   9,   INF},
        {2,   INF, 0,   4},
        {INF, INF, 3,   0},
    };
    
    public static void floydWarshall(){
        int n = graph.length;
        
        for (int i = 0; i < n; i++) { //거쳐가는 노드를 선택하는 반복문
            for (int j = 0; j < n; j++) {   //갱신할 노드를 선택하는 반복문
                for (int k = 0; k < n; k++) {   // j > k 
                    if(j == i || k == i || j == k) continue;
                    //j > k로 바로 가는 경우와 i를 거쳐가는 경우(j > i > k)를 비교
                    //더 작은 값으로 갱신
                    if(graph[j][k] > graph[j][i] + graph[i][k]) 
                        graph[j][k] = graph[j][i] + graph[i][k];
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        floydWarshall();
        for (int[] is : graph) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
    
}
