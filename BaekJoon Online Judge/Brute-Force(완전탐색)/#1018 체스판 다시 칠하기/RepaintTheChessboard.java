/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baekjoon.bruteforce;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */

public class RepaintTheChessboard {

    /**
     * @param args the command line arguments
     */
    public static int N;
    public static int M;
    public static StringBuilder[] board;
    public static boolean[][] color;
    
    public static int getFillCnt(int start_i, int start_j){
        int end_i = start_i + 8;
        int end_j = start_j + 8;
        int count = 0;    
        
        boolean cur = color[start_i][start_j];          //처음 색
       
        for (int i = start_i; i < end_i; i++) {
            for (int j = start_j; j < end_j; j++) {
                if(color[i][j] != cur) count++;
                
                cur = !cur;
            }
            cur = !cur;
        }
        
        return Math.min(count, 64 - count);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        N = sc.nextInt();
        M = sc.nextInt();
        
        board = new StringBuilder[N];
        color = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            board[i] = new StringBuilder(input);
            for (int j = 0; j < M; j++) {
                color[i][j] = (board[i].charAt(j) == 'W');
            }
        }
        
        int n_range = N - 7;
        int m_range = M - 7;
        
        for (int i = 0; i < n_range; i++) {
            for (int j = 0; j < m_range; j++) {
                min = Math.min(min, getFillCnt(i,j));
            }
        }
        System.out.println(min);
    }
    
}
