/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Silver.BOJ2407;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {
    public static BigInteger[][] dp;
    
    public static void combi(int n, int r) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                // iC1 ~ iCi까지 구하기
                // 1C0 + 1C1 = 2C1
                if(j == 0 || i == j) dp[i][j] = BigInteger.ONE; // iC0, iCi 인 경우
                else dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        dp = new BigInteger[1000][1000];
        dp[0][0] = dp[1][0] = dp[1][1] = BigInteger.ONE;
        
        // nCr = n-1Cr-1 + n-1Cr
        combi(n, m);
        
        System.out.println(dp[n][m]);
    }
}
