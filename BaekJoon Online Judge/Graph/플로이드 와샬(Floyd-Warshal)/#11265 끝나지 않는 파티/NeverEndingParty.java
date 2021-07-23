/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floyd.BOJ11265;

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
    public static int[][] party;
    
    public static void floyd(int N, int[][] party){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(j == i || k == i || j == k) continue;
                    party[j][k] = Math.min(party[j][k], party[j][i] + party[i][k]);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(input.nextToken());        //파티장의 크기
        int M = Integer.parseInt(input.nextToken());        //손님 수
        
        party = new int[N][N];
        for (int i = 0; i < N; i++) {
            input = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) party[i][j] = Integer.parseInt(input.nextToken());
        }
        
        floyd(N, party);
        
        for (int i = 0; i < M; i++) {
            input = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(input.nextToken());   //출발 위치
            int e = Integer.parseInt(input.nextToken());   //도착 위치
            int t = Integer.parseInt(input.nextToken());   //제한 시간
            
            if(party[s - 1][e - 1] <= t) System.out.println("Enjoy other party");
            else System.out.println("Stay here");
        }
    }
    
}
