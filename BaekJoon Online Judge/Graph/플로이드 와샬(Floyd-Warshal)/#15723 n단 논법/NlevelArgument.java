/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floyd.BOJ15723;

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
    public static boolean[][] conclusion = new boolean[26][26];
    
    public static void floyd(){
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    if(j == i || k == i || j == k) continue;
                    if(conclusion[j][i] && conclusion[i][k]) conclusion[j][k] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input;
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < 26; i++) Arrays.fill(conclusion[i], false);
        
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            int n1 = input.charAt(0) - 'a';
            int n2 = input.charAt(5) - 'a';
            conclusion[n1][n2] = true;
        }
        
        int m = Integer.parseInt(br.readLine());
        floyd();
        
        for (int i = 0; i < m; i++) {
            input = br.readLine();
            int n1 = input.charAt(0) - 'a';
            int n2 = input.charAt(5) - 'a';
            if(conclusion[n1][n2]) System.out.println("T");
            else System.out.println("F");
        }
        
    }
    
}
