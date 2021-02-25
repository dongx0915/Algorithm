/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.Baekjoon2217;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int maxWeight(int n, int[] rope){
        int max_weight = Integer.MIN_VALUE;
        int rope_sum = 0;
        int min_rope = 0;
        int k = 0;
        for (int i = n - 1; i >= 0; i--) {
            rope_sum += rope[i];
            min_rope = rope[i];
            k++;
            max_weight = Math.max(min_rope * k, max_weight);
        }   
        
        return max_weight;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] rope = new int[n];
        
        for (int i = 0; i < n; i++) {
            rope[i] = sc.nextInt();
        }
        
        Arrays.sort(rope);
        
        System.out.println(maxWeight(n, rope));
    }
    
}
