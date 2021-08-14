/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floyd.BOJ6156;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Donghyeon <20183188>
 */
class Cow{
    Set<Integer> stronger_ = new HashSet<>();
    Set<Integer> weaker_ = new HashSet<>();
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static final int INF = -1;
    public static boolean[][] skill;
    
    public static void floyd(Cow[] cows, int N){
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i == k || j == k || i == j) continue;
                    if(skill[i][k] && skill[k][j]) {
                        skill[i][j] = true;
                        //System.out.printf("[%d] > [%d]\n", i,j);
                        cows[i].weaker_.add(j);     //i가 j보다 쎄다
                        cows[j].stronger_.add(i);   //j가 i보다 쎄다
                    }
                }
            }
        }
    }
    
    public static int getRankableCow(Cow[] cows, int N){
        int cnt = 0;
        for (Cow cow : cows) {
            //System.out.println("st = " + cow.stronger_.size() + " wk = " + cow.weaker_.size());
            if(((cow.stronger_.size() + cow.weaker_.size())) >= N-1) cnt++;
        }
        
        return cnt;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        skill = new boolean[N][N];
        Cow[] cows = new Cow[N];
        
        for (int i = 0; i < N; i++) cows[i] = new Cow();
        for (int i = 0; i < M; i++) {
            int c1 = sc.nextInt() - 1;
            int c2 = sc.nextInt() - 1;
            skill[c1][c2] = true;
            cows[c1].weaker_.add(c2);
            cows[c2].stronger_.add(c1);
        }
        
        floyd(cows, N);
        System.out.println(getRankableCow(cows, N));
    }
    
}
