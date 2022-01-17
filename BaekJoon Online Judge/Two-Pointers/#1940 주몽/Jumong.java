/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwoPointer.BOJ1940;

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
    
    public static int numberOfArmor(int N, int M, int[] material){
        int s = 0, e = N-1;
        int cnt = 0;
        int sum = 0;
        
        while(s < e){
            sum = material[s] + material[e];
            
            if(sum < M) s++;
            else{
                if(sum == M) cnt++;
                e--;
            }
        }
        
        return cnt;
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] material = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) material[i] = Integer.parseInt(st.nextToken());     
        
        Arrays.sort(material);
        System.out.println(numberOfArmor(N,M,material));
    }
    
}
