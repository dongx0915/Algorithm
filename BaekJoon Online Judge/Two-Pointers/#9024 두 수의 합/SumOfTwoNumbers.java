/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwoPointer.BOJ9024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static int solution(int n, int k, int[] num){
        int s = 0, e = n-1;
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        
        while(s < e){
            int sum = num[s] + num[e];

            if(Math.abs(k - sum) < Math.abs(k - min)){
                min = sum;
                cnt = 1;
            }
            else if(Math.abs(k-sum) == Math.abs(k - min)) cnt++;
            
            if(sum > k) e--;
            else s++;
        }
        
        return cnt;
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test = Integer.parseInt(st.nextToken());
        
        while(test-- != 0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] num = new int[n];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) num[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(num);
            
            System.out.println(solution(n,k,num));
        }
    }
    
}
