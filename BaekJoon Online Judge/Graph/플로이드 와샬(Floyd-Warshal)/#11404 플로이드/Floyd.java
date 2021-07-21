/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloydWarshall.BOJ11404;

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
    public static final int INF = 10000001;
    public static int[][] city;
    
    public static void floydWarshall(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(j == i || k == i || j == k) continue;
                    if(city[j][k] > city[j][i] + city[i][k])
                        city[j][k] = city[j][i] + city[i][k];
                }
            }
        }
    }
    
    public static void print(int[][] city){
        for (int[] is : city) {
            for (int i : is) {
                if(i == INF) i = 0;
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        city = new int[n][n];
        
        for (int i = 0; i < n; i++) Arrays.fill(city[i], INF);
        for (int i = 0; i < m; i++){
            int n1 = sc.nextInt() - 1;
            int n2 = sc.nextInt() - 1;
            int cost = sc.nextInt();
            city[n1][n2] = Math.min(city[n1][n2], cost);
        }

        floydWarshall(n);
        print(city);
    }
    
}
