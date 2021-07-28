/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floyd.BOJ21278;

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
    public static final int INF = 100000;
    public static int N,M;
    public static int[] time;
    public static int[][] dis;
    
    public static void print(){
        for (int[] di : dis) {
            for (int i : di) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static void floyd(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(j == k) dis[j][k] = 0;
                    if(j == i || k == i || j == k) continue;
                    dis[j][k] = Math.min(dis[j][k], dis[j][i] + dis[i][k]);
                }
            }
        }
    }
    
    public static String getPosition(){
        int[] ch = {0, 1};
        int minDis = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                //i, j는 치킨 집 번호
                //치킨 집 조합에 대해서 각 노드에서의 왕복거리의 합을 구함
                for (int k = 0; k < N; k++) {
                    if(dis[k][i] == INF && dis[k][j] == INF) continue;
                    sum += Math.min(dis[k][i], dis[k][j]) * 2;
                }
                if (minDis > sum) {
                    //작은 번호가 같은 경우(큰 번호가 더 작은 것을 출력)
                    minDis = sum;
                    if(ch[0] == i) ch[1] = ch[1] > j ? j : ch[1];
                    else {
                        ch[0] = i;
                        ch[1] = j;
                    }
                }
            }
        }
        
        return (ch[0]+1) + " " + (ch[1]+1) + " " + minDis;
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        time = new int[N];
        dis = new int[N][N];
        
        for (int i = 0; i < N; i++) Arrays.fill(dis[i], INF);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            dis[n1][n2] = dis[n2][n1] = 1;
        }
        floyd();
        //print();
        System.out.println(getPosition());
    }
    
}
