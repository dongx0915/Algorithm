/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.BOJ2638;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int[][] fibo = new int[41][41];
        
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        
        fibo[1][0] = 0;
        fibo[1][1] = 1;
        
        fibo[2][0] = 1;
        fibo[2][1] = 1;
        
        
        for (int i = 3; i < 41; i++) {
            fibo[i][0] = fibo[i - 1][1];
            fibo[i][1] = fibo[i - 1][0] + fibo[i - 1][1];
        }
        
        int test = sc.nextInt();
        
        while(test-- != 0){
            int n = sc.nextInt();
            System.out.println(fibo[n][0] + " " + fibo[n][1]);
        }
    }
    
}
