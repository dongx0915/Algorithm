/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floyd.BOJ11562;

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
    public static final int INF = 10000000;
    public static int N,M;
    public static int[][] road;
    
    public static void floyd(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(j == i || k == i || j == k) continue;
                    //System.out.printf("[%d,%d] + [%d,%d] = %d, %d\n", j+1,i+1, i+1,k+1, road[j][i], road[i][k]);
                    road[j][k] = Math.min(road[j][k], road[j][i] + road[i][k]); //j -> i로 갈 때 바꿔야하는 도로 수 + i -> k로 갈 때 바꿔야하는 도로 수
                }
            }
            //System.out.println("");
        }
    }
    
    public static void print(){
        for (int[] ls : road) {
            for (int l : ls) {
                if(l == INF) System.out.print("INF ");
                else System.out.printf("%3d ", l);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        road = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(road[i], INF);
            road[i][i] = 0;
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()); //d가 0이면 일방통행, 1이면 양방향
            
            //road 배열에는 n에서 m으로 갈 때 바꿔야하는 도로의 개수를 저장한다.
            //따라서, 정방향이라면 0(도로 안바꿔도 됨), 역방향이라면 1(도로 하나 바꿔야 함)로 저장한다.
            if(d == 0) {
                road[n1][n2] = 0;   
                road[n2][n1] = 1;   //역방향
            }                       
            else if(d == 1) road[n1][n2] = road[n2][n1] = 0;
        }
        
        floyd();
        
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            System.out.println(road[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1]);
        }
    }
    
}
