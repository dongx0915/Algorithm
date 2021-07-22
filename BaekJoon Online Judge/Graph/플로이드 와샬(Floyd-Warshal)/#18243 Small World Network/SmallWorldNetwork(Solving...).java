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
    public static final int INF = 100000000;
    public static int[][] graph;
    
    public static String floyd(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(j == i || k == i || j == k) continue;

                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                if(graph[i][j] > 6) return "Big World!";
            }
        }
        
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

        System.out.println(floyd(n));
    }
}
