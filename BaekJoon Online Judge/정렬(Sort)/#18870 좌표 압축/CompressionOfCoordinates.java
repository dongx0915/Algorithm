/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOJ_SIlver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int input(String num){ return Integer.parseInt(num); }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = input(st.nextToken());
        int[] num = new int[N];
        int[] copy = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) num[i] = copy[i] = input(st.nextToken());
        
        Arrays.sort(copy);
        
        int rank = 0;
        for (int i : copy) if(!map.containsKey(i)) map.put(i, rank++);
        
        StringBuilder sb = new StringBuilder();
        for (int i : num) sb.append(map.get(i)).append(" ");
        
        System.out.println(sb.toString());
    }
    
}
