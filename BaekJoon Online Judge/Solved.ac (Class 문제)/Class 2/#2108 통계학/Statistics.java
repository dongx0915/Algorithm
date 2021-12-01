package Math.BOJ2108;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //N은 홀수
        int[] num = new int[N];
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
                        mode.clear();
                        mode.add(num[i]);
                    }
                    else if(max_freq == freq) mode.add(num[i]);
                    freq=1;
                }
            }
            else {
                if(max_freq < freq){
                    max_freq = freq;
                    mode.clear();
                    mode.add(num[i]);
                }
                else if(max_freq == freq) mode.add(num[i]);
                freq=1;
            }
        }
        
        Collections.sort(mode);
        //System.out.println("최빈 값 : " + mode);
        
        
        //System.out.println("");
        /* 산술평균 */
        double avg = (double)sum / N;
        //avg = (avg > 0) ? avg + 0.5 : avg - 0.5;
        
        System.out.printf("%.0f\n", avg);
        
        /* 중앙값 */
        System.out.println(num[N/2]);
        
        /* 최빈값 */
        System.out.println((mode.size() >= 2) ? mode.get(1) : mode.get(0));
        
        /* 범위 */
        System.out.println(num[N-1] - num[0]);
    }
}
