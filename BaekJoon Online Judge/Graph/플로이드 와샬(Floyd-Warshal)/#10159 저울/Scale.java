/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floyd.BOJ10159;

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
    public static final int INF = 100 * 2000 + 1;
    public static int[][] compare, rev;
    
    public static void floyd(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(j == i || k == i || j == k) continue;
                    compare[j][k] = Math.min(compare[j][k], compare[j][i] + compare[i][k]);
                    rev[j][k] = Math.min(rev[j][k], rev[j][i] + rev[i][k]);
                }
            }
        }
    }
    
    public static String unknownObject(int n){
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++){
                if(i == j) continue;
                if(compare[i][j] == INF && rev[i][j] == INF) cnt++;
            }
            
            result.append(cnt).append("\n");
        }
        
        return result.toString();
    }
    
    public static void print(){
        for (int[] is : compare) {
            for (int i : is) {
                if(i == INF) System.out.print("N ");
                else System.out.print(i + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
  
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        compare = new int[n][n];
        rev = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(compare[i], INF);
            Arrays.fill(rev[i], INF);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            compare[n1][n2] = 1;
            rev[n2][n1] = 1;
        }
        
        floyd(n);
        System.out.print(unknownObject(n));
    }
}
