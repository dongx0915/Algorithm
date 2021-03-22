/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.Baekjoon2847;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int getReduceCnt(int[] score){
        int reduce = 0;
        for (int i = score.length - 1; i > 0; i--) {
            if(score[i] <= score[i - 1]){
                reduce += score[i - 1] - score[i] + 1;
                score[i - 1] = score[i] - 1;
            }
        }
        
        return reduce;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] score = new int[n];
        
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }
        System.out.println(getReduceCnt(score));
    }
    
}
