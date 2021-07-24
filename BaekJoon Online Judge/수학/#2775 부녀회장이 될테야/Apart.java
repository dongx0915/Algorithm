/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math.BOJ2775;

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
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int[][] apart = new int[15][15];
        
        for (int i = 0; i < 15; i++){
            apart[i][0] = 1;
            apart[0][i] = i + 1;
        }
        
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 14; j++) {
                apart[i][j] = apart[i-1][j] + apart[i][j-1];
            }
        }
        
        while(test-- != 0) System.out.println(apart[sc.nextInt()][sc.nextInt() - 1]);
    }
    
}
