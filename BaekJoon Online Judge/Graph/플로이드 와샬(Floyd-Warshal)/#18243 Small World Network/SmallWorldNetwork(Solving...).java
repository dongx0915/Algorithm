/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloydWarshall.BOJ18243;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static final int INF = 100;
    public static int[][] graph;
    
    public static String floyd(int n){
        for (int i = 0; i < n; i++) {
            System.out.println("i == " + (i + 1));
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(j == i || k == i || j == k) continue;
                    System.out.printf("[%d][%d] = %d  :: [%d][%d] + [%d][%d] = %d\n",
                            j+1, k+1, graph[j][k], j+1, i+1, i+1, k+1, graph[j][i] + graph[i][k]);
                    if(graph[j][k] > graph[j][i] + graph[i][k])
                        graph[j][k] = graph[j][i] + graph[i][k];
                }
            }
            System.out.println("");
        }
        
        for (int[] g : graph) for (int v : g) if(v != INF && v > 6) return "Big World!";
        return "Small World!";
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        graph = new int[n][n];
        
        for (int i = 0; i < n; i++) Arrays.fill(graph[i], INF);
        for (int i = 0; i < k; i++){
            int n1 = sc.nextInt() - 1;
            int n2 = sc.nextInt() - 1;
            
            graph[n1][n2] = graph[n2][n1] = 1;
        }
                for (int[] is : graph) {
            for (int i : is) {
                if(i == INF) i = 0;
                System.out.print(i + " ");
            }
            System.out.println("");
        }
        System.out.println(floyd(n));
        for (int[] is : graph) {
            for (int i : is) {
                if(i == INF) i = 0;
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
}
