/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.BOJ11052;

import java.util.Scanner;

public class Main {
    //d[] : 카드 n개를 사는 최대 가격
    //p[] : 카드 팩의 가격
    public static int[] d, p;
    
    public static int solution(int n){
        for (int i = 1; i <= n; i++) {       //전체 카드 수
            for (int j = 1; j <= i; j++) {   //구매한 카드 수
                /* d[i] : 카드 i개를 사는 최대 가격 vs 
                *  d[i - j] + p[j] : j개를 사고 남은 카드를 사는 최대 가격 + 카드 j개의 가격
                */
                //System.out.printf("d[%d] = d[%d] vs d[%d - %d] + p[%d]\n", i, i, i, j, j);
                d[i] = Math.max(d[i], d[i - j] + p[j]);
                //System.out.printf("d[%d] = %d\n", i, d[i]);
            }
            //System.out.println("");
        }
        
        return d[n];
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n+1];
        p = new int[n+1];
        
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
            //System.out.print(p[i] + " ");
        }
        //System.out.println("");
        
        System.out.println(solution(n));
        
    }
    
}
