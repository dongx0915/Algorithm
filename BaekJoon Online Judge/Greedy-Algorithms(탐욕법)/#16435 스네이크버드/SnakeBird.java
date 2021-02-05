/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.Baekjoon16435;

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
    
    public static int getMaxLength(int n, int len, int[] fruits){
        for (int fruit : fruits) {
            if(len < fruit) break;
            else len++;
        }
        
        return len;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int len = sc.nextInt();
        
        int[] fruits = new int[n];
        
        for (int i = 0; i < n; i++) {
            fruits[i] = sc.nextInt();
        }
        
        Arrays.sort(fruits);
        System.out.println(getMaxLength(n, len, fruits));
    }
    
}
