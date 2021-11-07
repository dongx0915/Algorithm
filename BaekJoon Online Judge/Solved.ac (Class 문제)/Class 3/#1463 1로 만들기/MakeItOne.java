/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.BOJ1463;

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
    public static final int INF = 1000001;
    public static int[] d;
    
    public static int dp(int n, int cnt){
        if(n == 1) return cnt;
        
        /*
        * d[x]보다 현재 cnt가 더 작다면 다시 dp를 돌릴 필요가 없음 (이걸 체크 안하고 dp를 계속 돌리면 시간 초과)
        */
        if(d[n/3] > cnt && n % 3 == 0) d[n/3] = Math.min(dp(n/3, cnt+1), d[n/3]);
        if(d[n/2] > cnt && n % 2 == 0) d[n/2] = Math.min(dp(n/2, cnt+1), d[n/2]);
        if(d[n-1] > cnt) d[n-1] = Math.min(dp(n-1, cnt+1), d[n-1]);
        
        return d[n] = Math.min(Math.min(d[n/3], d[n/2]), d[n-1]);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n+1];
        Arrays.fill(d, INF);
        
        System.out.println(dp(n, 0));
    }
    
}
