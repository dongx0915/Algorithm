/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.BOJ11727;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int[] d;
    
    public static int dp(int x){
        if(x == 1) return 1;
        if(x == 2) return 3;
        if(d[x] != 0) return d[x];
        
        return d[x] = (dp(x - 1) + 2 * dp(x - 2)) % 10007;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n + 1];
        
        System.out.println(dp(n));
    }
    
}
