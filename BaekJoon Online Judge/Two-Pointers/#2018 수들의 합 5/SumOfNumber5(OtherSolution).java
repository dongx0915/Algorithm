/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwoPointer.BOJ2018;

import java.util.Scanner;

/**
 *
 * @author Donghyeon Kim <donghyeon0915@gmail.com> [20183188]
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static int solution(int N, int[] num){
        int s = 0, e = 0;
        int cnt = 0, sum = 0;
        
        for (s = 0; s < N; s++) {
            while(sum < N && e < N) sum += num[e++];
            
            if(sum == N) cnt++;
            sum -= num[s];
        }
        
        return cnt;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        
        for (int i = 0; i < N; i++) num[i] = i+1;
        
        System.out.println(solution(N, num));
    }
    
}
