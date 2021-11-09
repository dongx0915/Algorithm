/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Baekjoon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //N은 홀수
        int[] num = new int[N];
        /*
        * 산술평균 : N개의 수들의 합을 N으로 나눈 값
        * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값(N/2)
        * 최빈값 : N개의 수들 중 가장 많이 나타나는 값(여러 개 있을 떄에는 최빈값 중 두 번째로 작은 값을 출력)
        * 범위 : N개의 수들 중 최댓값과 최솟값의 차이
        */
        int sum = 0;
        
        for (int i = 0; i < N; i++) sum += (num[i] = sc.nextInt());
        Arrays.sort(num);
        
        ArrayList<Integer> mode = new ArrayList<>();
        int max_freq = 0;
        int freq = 1;
        
        for (int i = 0; i < N; i++) {
            if(i < N-1) {
                if (num[i] == num[i + 1]) freq++;
                else {
                    if (max_freq < freq) {
                        max_freq = freq;
                        freq = 1;
                        mode.clear();
                        mode.add(num[i]);
                    }
                    else if(max_freq == freq) mode.add(num[i]);
                }
            }
            else {
                if(max_freq < freq){
                    max_freq = freq;
                    freq = 1;
                    mode.clear();
                    mode.add(num[i]);
                }
                else if(max_freq == freq) mode.add(num[i]);
            }
        }
        
        Collections.sort(mode);
        /* 산술평균 */
        System.out.printf("%.0f\n", (double)sum / N);
        
        /* 중앙값 */
        System.out.println(num[N/2]);
        
        /* 최빈값 */
        System.out.println((mode.size() >= 2) ? mode.get(1) : mode.get(0));
        
        /* 범위 */
        System.out.println(num[N-1] - num[0]);
    }
    
}
