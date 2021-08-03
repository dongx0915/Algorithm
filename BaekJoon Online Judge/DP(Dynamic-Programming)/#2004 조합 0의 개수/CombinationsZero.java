/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dp.BOJ2004;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int[][] d = new int[1000][1000];
    
    public static int combi(int n, int m){
       if(n == 1) return 1;
       if(n == m || m == 0) return d[n][m] = 1;
       if(d[n][m] != 0) return d[n][m];
       
       return d[n][m] = combi(n - 1, m) + combi(n - 1, m - 1);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        d[1][1] = 1;
        d[2][0] = 1;
        d[2][1] = 2;
        d[2][2] = 1;
        
        for (int i = 0; i <= n; i++) {
            for (int k = n; k > i; k--) System.out.print("     ");
            for (int j = 0; j <= i; j++) {
                System.out.printf("%10d", combi(i,j));
            }
            System.out.println("");
        }
    }
    
}
