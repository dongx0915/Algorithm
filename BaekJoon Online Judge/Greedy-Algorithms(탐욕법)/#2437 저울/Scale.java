/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.Baekjoon2437;
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
    public static int getMinWeight(int n, int[] weight){
        int min_weight = 0;
        
        for (int i = 0; i < n; i++) {
            if(weight[i] > min_weight + 1) return min_weight + 1;
            else min_weight += weight[i];
        }
        
        return min_weight + 1;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weight = new int[n];
        
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        
        Arrays.sort(weight);
        System.out.println(getMinWeight(n, weight));

    }
    
}
