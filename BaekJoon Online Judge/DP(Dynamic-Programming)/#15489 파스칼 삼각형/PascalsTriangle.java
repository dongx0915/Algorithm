/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.BOJ15489;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int[][] combi = new int[31][31];
    
    public static int dp(int n, int m){
        if(n < 0 || m < 0 || n < m) return 0;
        if(n == m || m == 0) combi[n][m] = 1;
        if(combi[n][m] != 0) return combi[n][m];
        
        return combi[n][m] = dp(n-1,m) + dp(n-1,m-1);
    }

    
    public static int getTriangleSum(int R, int C, int W){
        int sum = 0;
        for (int i = R; i < R+W; i++) {
            for (int j = C; j <= C + i - R; j++) {
                if(R > 30 || C > 30) continue;
                //System.out.printf("%dC%d = %d\n", i, j, dp(i,j));
                sum += dp(i,j);
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();       //R번째 줄(R-1의 값을 구해야함(0C0 부터 시작하므로)
        int C = sc.nextInt();       //C번째 수(C-1의 값을 구해야함(nC0부터 시작하므로)
        int W = sc.nextInt();       //변의 길이 W
        
        combi[0][0] = 1;
        combi[1][0] = 1;
        combi[1][1] = 1;
        
        System.out.println(getTriangleSum(R-1, C-1, W));
    }
    
}
