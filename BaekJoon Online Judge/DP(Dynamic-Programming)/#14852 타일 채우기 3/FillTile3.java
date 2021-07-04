/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.BOJ14852;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static long[][] d;
    
    public static long dp(int x){
        d[0][0] = 0;
        d[1][0] = 2;
        d[2][0] = 7;
        d[2][1] = 1;
        
        for (int i = 3; i <= x; i++) {
            d[i][1] = (d[i - 1][1] + d[i - 3][0]) % 1000000007;
            d[i][0] = (2 * d[i - 1][0] + 3 * d[i - 2][0] + 2 * d[i][1]) % 1000000007;
        }
        
        return d[x][0];
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new long[n + 1][2];
        
        System.out.println(dp(n));
    }
    
}
