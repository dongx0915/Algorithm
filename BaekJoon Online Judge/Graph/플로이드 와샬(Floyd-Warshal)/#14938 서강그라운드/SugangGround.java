/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floyd.BOJ14938;

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
    public static final int INF = 100 * 100 * 15 + 1;
    public static int[][] ground;
    
    public static void floyd(int N){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(j == i || k == i || j == k) continue;
                    ground[j][k] = Math.min(ground[j][k], ground[j][i] + ground[i][k]);
                }
            }
        }
    }
    
    public static int getItems(int[] item, int N, int M){
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < N; i++) {
            int sum = item[i];
            for (int j = 0; j < N; j++) if(ground[i][j] <= M) sum += item[j];
            
            max = Math.max(max, sum);
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //지역
        int M = sc.nextInt();   //수색 범위
        int R = sc.nextInt();   //길의 개수
        int[] item = new int[N];
        ground = new int[N][N];
        
        
        for (int i = 0; i < N; i++) {
            item[i] = sc.nextInt();
            Arrays.fill(ground[i], INF);
        }
        
        for (int i = 0; i < R; i++) {
            int n1 = sc.nextInt() - 1;
            int n2 = sc.nextInt() - 1;
            ground[n1][n2] = ground[n2][n1] = sc.nextInt();
        }
        
        floyd(N);
        System.out.println(getItems(item, N, M));
    }
    
}
