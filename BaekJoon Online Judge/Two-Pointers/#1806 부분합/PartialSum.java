/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwoPointer.BOJ1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int input(String str){
        return Integer.parseInt(str);
    }
    
    public static int getSequenceRange(int[] num, int S){
        int start = 0, end = 0;
        int sum = 0, N = num.length;
        int minRange = Integer.MAX_VALUE;
        
        for (start = 0; start < N; start++) {
            //sum이 S보다 같거나 커질 때까지 end를 증가
            while(sum < S && end < N) sum += num[end++];
            
            if(sum >= S) minRange = Math.min(minRange, Math.abs(end - start));  // <- 범위를 구할 때 음수가 나올 수 있으므로 절대값을 씌워주기
            sum -= num[start];
        }
        
        return minRange == Integer.MAX_VALUE ? 0 : minRange;
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = input(st.nextToken());
        int S = input(st.nextToken());
        
        int[] num = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) num[i] = input(st.nextToken());
        
        System.out.println(getSequenceRange(num, S));
        
    }
    
}
