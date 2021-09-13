/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.BOJ1269;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sizeA = Integer.parseInt(st.nextToken());
        int sizeB = Integer.parseInt(st.nextToken());
        int cnt = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeA; i++) set.add(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeB; i++) if(set.contains(st.nextToken())) cnt++;
        
        System.out.println((sizeA + sizeB) - (cnt * 2));
    }
}
