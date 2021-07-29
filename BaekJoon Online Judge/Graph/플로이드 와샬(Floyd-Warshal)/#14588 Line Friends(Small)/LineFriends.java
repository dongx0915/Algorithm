/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floyd.BOJ14588;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Line{
    int left_, right_;

    public Line(int left_, int right_) {
        this.left_ = left_;
        this.right_ = right_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int[][] friend;
    public static final int INF = 100000;
    
    public static boolean isOverlap(Line l1, Line l2){
        return !(l1.right_ < l2.left_ || l2.right_ < l1.left_);
    }
    
    public static void setRelationship(ArrayList<Line> line, int N){
        for (int i = 0; i < N - 1; i++) {
            Line cur = line.get(i);
            for (int j = i + 1; j < N; j++) {
                if(isOverlap(cur, line.get(j))) friend[i][j] = friend[j][i] = 1;
            }
        }
        
        floyd(N);
    }
    
    public static void floyd(int N){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(j == k) friend[j][k] = 0;
                    if(j == i || k == i || j == k) continue;
                    friend[j][k] = Math.min(friend[j][k], friend[j][i] + friend[i][k]);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Line> line = new ArrayList<>();
        friend = new int[N][N];
        
        //자기 자신은 0 ? INF ?
        for (int i = 0; i < N; i++) Arrays.fill(friend[i], INF);
        for (int i = 0; i < N; i++) line.add(new Line(sc.nextInt(), sc.nextInt()));
        
        int Q = sc.nextInt();
        
        setRelationship(line, N);
        
        for (int i = 0; i < Q; i++) {
            int relation = friend[sc.nextInt() - 1][sc.nextInt() - 1];
            if(relation == INF) System.out.println("-1");
            else System.out.println(relation);
        }
    }
    
}
