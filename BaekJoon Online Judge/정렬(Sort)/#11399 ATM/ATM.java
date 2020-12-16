/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class ATM {

    /**
     * @param args the command line arguments
     */
    
    public static int getMinimumTime(int[] drawTime){
        int length = drawTime.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                sum += drawTime[j];         //처음부터 자신의 순서까지 걸리는 시간을 더함
            }
        }
        
        return sum;
    }
    
    public static int[] sort(int[] array){
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int j;
            int temp = array[i];
            for (j = i; j > 0 && array[j - 1] > temp; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
        
        return array;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        int[] drawTime = new int[n];
        
        for (int i = 0; i < n; i++) {
            drawTime[i] = scan.nextInt();
        }
        
        System.out.println(getMinimumTime(sort(drawTime)));
    }
    
}
