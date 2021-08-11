/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floyd.BOJ1719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static final long INF = 200 * 10000 * 1000 + 1;
    public static int N,M;
    public static long[][] parcel;
    public static int[][] first;
    
    public static void floyd(){
        for (int k = 0; k < N; k++) {
            System.out.println("k = " + (k+1));
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    
                    if(i == k || j == k || i == j) continue;
                    if(parcel[i][j] > parcel[i][k] + parcel[k][j]){
                        System.out.printf("[%d][%d]( %d ) > [%d][%d] + [%d][%d]( %d )\n",
                                i+1,j+1, parcel[i][j], i+1,k+1,k+1,j+1, parcel[i][k] + parcel[k][j]);
                        parcel[i][j] = parcel[i][k] + parcel[k][j];
                        first[i][j] = k + 1;
                    }
                }
            }
            System.out.println("");
        }
    }
    
    public static void print(){
        StringJoiner sj = new StringJoiner(" ");
        
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == j) System.out.print("- ");
                else System.out.print(first[i][j] + " ");
            }
            System.out.println("");
        }
        
    }

    public Main() {
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());   //집하장 개수(1 <= N <= 200)
        M = Integer.parseInt(st.nextToken());   //경로 개수 (1 <= M <= 10000)
        
        parcel = new long[N][N];
        first = new int[N][N];
        
        
        for (int i = 0; i < N; i++) Arrays.fill(parcel[i], INF);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken())-1;
            int n2 = Integer.parseInt(st.nextToken())-1;
            
            parcel[n1][n2] = parcel[n2][n1] = Integer.parseInt(st.nextToken());
        }
        
        floyd();
        print();
    }
    
}
