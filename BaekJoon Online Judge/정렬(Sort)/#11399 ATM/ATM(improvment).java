/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class ATM {

    /**
     * @param args the command line arguments
     */
    
    public static long getMinimumTime(int[] drawTime) {
        long sum = 0;
        int n = drawTime.length;
        for (int i = 0; i < n; i++) {
            sum += drawTime[i] * (n - i);
        }
        
        /*
        * 1                  => arr[0] 5번
        * 1 + 2              => arr[1] 4번       ==> 이전 값에 현재 값을 계속 더해가는 방식
        * 1 + 2 + 3          => arr[2] 3번       ==> sum += drawTime[i] * (n - i);로 나타낼 수 있다.
        * 1 + 2 + 3 + 3      => arr[3] 2번       
        * 1 + 2 + 3 + 3 + 4  => arr[4] 1번
        */
        return sum;
    }
    
    public static int getMinimumTime(int[] drawTime){
        int[] time = new int[drawTime.length];
        int sum = time[0] = drawTime[0];
        
        for (int i = 1; i < time.length; i++) {
                                                          //불필요하게 2중 FOR문을 쓸 필요 없이 이전의 값에 현재 인원의 값을 더함
            sum += (time[i] = time[i - 1] + drawTime[i]); //이전 시간 + 현재 인원의 시간
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
