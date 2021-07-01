/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.BOJ2133;

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
        if(x == 0) return 1;
        if(x == 1) return 0;
        if(x == 2) return 3;
        if(d[x] != 0) return d[x];
        
        int result = d[x] = 3 * dp(x-2);
        
        for (int i = 4; i <= x ; i+=2) result += 2 * dp(x - i);// n=4부터는 새로운 도형이 추가된다. 하지만 n이 4,6,8,10...일때 도형의 모양이 모두 다르기 때문에 각각 dp[i]에 더해준다.
        return d[x] = result;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        d = new int[n + 1];
        
        System.out.println(dp(n));
    }
    
}
