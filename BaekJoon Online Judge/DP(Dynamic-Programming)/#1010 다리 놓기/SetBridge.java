/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.BOJ1010;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int[][] dp;
    
    public static int combi(int n, int r){
        if(r == 0 || n == r) return 1;
        if(dp[n][r] != 0) return dp[n][r];
        
        return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        
        while(test-- != 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            dp = new int[m + 1][n + 1];
            
            System.out.println(combi(m, n));
        }
    }
}
