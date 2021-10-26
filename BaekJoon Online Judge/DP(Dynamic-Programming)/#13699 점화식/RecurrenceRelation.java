/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.BOJ13699;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static long[] t;
    
    public static long dp(int n){
        if(t[n] != 0) return t[n];
        
        for (int i = 0, j = n-1; (i < n-1) || (j >= 0); i++, j--) t[n] += dp(i) * dp(j);
        
        return t[n];
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        t = new long[n+1];
        
        t[0] = 1;
        System.out.println(dp(n));
    }
    
}
