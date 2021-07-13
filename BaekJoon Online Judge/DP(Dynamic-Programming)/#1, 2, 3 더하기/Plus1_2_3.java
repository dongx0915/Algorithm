/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.BOJ9095;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int[] d = new int[12];
    
    public static int dp(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 4;
        if(d[n] != 0) return d[n];
        
        return d[n] = dp(n - 1) + dp(n - 2) + dp(n - 3);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while(test-- != 0){
            int n = sc.nextInt();
            System.out.println(dp(n));
        }
    }
    
}
