/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class2.BOJ2108;

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
        int N = sc.nextInt();
        int[] num = new int[N];
        int sum = 0; 
        int[] frequency = new int[4001];
        int freq_max = 0;
        int min = 4001, max=-4001;
        
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
            sum += num[i];
            freq_max = Math.max(freq_max, frequency[num[i]]++);   //음수도 들어오므로 인덱스 범위 늘려야함
            
            max = Math.max(max, num[i]);
            min = Math.min(min, num[i]);
        }
        double avg = (double)sum / N;
        System.out.printf("%.1f\n", avg);
        
        Arrays.sort(num);
        System.out.println(num[N/2]);
        
        int freq = 0;
        for (int i = 1; i < N+1; i++) {
            if(frequency[i] == freq_max) {
                if(freq != 0) {
                    freq=frequency[i];
                    break;
                }
                freq=frequency[i];
            }
        }
        
        System.out.println(freq);
        System.out.println(max - min);
    }
    
}
