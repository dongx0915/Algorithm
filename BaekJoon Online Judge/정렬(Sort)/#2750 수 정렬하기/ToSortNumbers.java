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
public class ToSortNumbers {

    /**
     * @param args the command line arguments
     */
    
    // 삽입 정렬(InsertionSort)
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
        int[] array = new int[n];
        
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        
        for (int i : sort(array)) {
            System.out.println(i);
        }
    }
    
}
