/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.BOJ16194;

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
    public static final int MAX = 1000 * 10000;
    public static int[] p, d;
    
    public static int dp(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int price = d[i - j] == MAX ? p[j] : d[i-j] + p[j];
                d[i] = Math.min(d[i], price);
            }
        }
        
        return d[n];
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        p = new int[N + 1];
        d = new int[N + 1];
        
        Arrays.fill(d, MAX);
        for (int i = 1; i <= N; i++) p[i] = sc.nextInt();
        System.out.println(dp(N));
    }
    
}
