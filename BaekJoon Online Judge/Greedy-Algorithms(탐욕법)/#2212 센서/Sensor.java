/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.Baekjoon2212;

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
    
    public static int getReceiveableArea(int n, int k, int[] sensor){
        int result = 0;
        int[] section = new int[n - 1];
        int[] max_index = new int[k - 1];
        
        for (int i = 0; i < n - 1; i++) {
            section[i] = sensor[i + 1] - sensor[i]; 
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] sensor = new int[n];
        
        for (int i = 0; i < n; i++) {
            sensor[i] = sc.nextInt();
        }
        
        Arrays.sort(sensor);
    }
    
}
