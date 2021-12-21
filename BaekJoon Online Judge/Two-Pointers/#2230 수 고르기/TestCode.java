/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwoPointer.BOJ2230;

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
    
    public static int solution2(int M, int[] num){
        int s = 0, e = num.length - 1;
        int minRange = Integer.MAX_VALUE;
        
        int range = 0;
        while(s <= e){
            range = Math.abs(num[e] - num[s]);
            
            if(range == M) return range;
            if(range > M){
                minRange = Math.min(range, minRange);
                
                if(Math.abs(num[s+1] - num[s]) > Math.abs(num[e] - num[e-1])) s++;
                else e--;
            }
            else return minRange;
        }
        
        
        return minRange;
    }
    
    public static int solution(int N, int M, int[] num){
        int s = 0, e = 0;
        int minRange = Integer.MAX_VALUE;
        
        int range = 0;
        while(s < N && e < N){
            range = num[e] - num[s];
            if(range == M) return M;
            
            if(range < M) e++;
            else{
                minRange = Math.min(minRange, range);
                s++;
            }
        }
        
        return minRange;
    }
        
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int cnt = 10000;
        while(cnt-- != 0){
            int N = (int) (Math.random() * 5) + 1;
            int M = (int) (Math.random() * 100_000);

            int[] array = new int[N];

            for (int i = 0; i < N; i++) array[i] = (int) (Math.random() * 1_000_000_000);
            Arrays.sort(array);

            int result1 = solution(N, M, array);
            int result2 = solution2(M, array);
            
            if(result1 != result2){
                System.out.println("N = " + N + " M = " + M);
                
                for (int i : array)  System.out.print(i + " ");               
                System.out.println("");
                System.out.println("answer = " + result1 + " wrong = " + result2);
                break;
            }
        }
    }
    
}
