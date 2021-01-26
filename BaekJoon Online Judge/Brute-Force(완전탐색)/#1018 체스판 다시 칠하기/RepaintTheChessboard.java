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
class Node{
    int x;
    int y;
    int data;

    public Node(int x, int y, int data) {
        this.x = x;
        this.y = y;
        this.data = data;
    }
}

public class chess {

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
        
        boolean first_c = color[start_i][start_j];          //처음 색
       
        for (int i = start_i; i < end_i; i++) {
            for (int j = start_j; j < end_j; j++) {
                if(color[i][j] != first_c) count++;         //처음 색(시작 색)과 다르면 새로 칠해야 하는 칸임
                                                            //매번 first_c가 반전됨 (W에서 시작했으면 first_c는 W가 되어 비교를함)
                                                            //현재 칸의 다음 칸은 반대 색상이어야함. 첫 칸이 W였으면 다음 칸은 B여야함(이에 따라서 first_c도 W -> B로 바꿔줌)
                                                            //first_c는 W -> B -> W -> B 처럼 계속 바뀜. first_c가 바뀜에 따라 해당 칸이랑 색상이 같으면 올바르게 칠해져있는 것
                                                            //first_c가 변하는 순서랑 체스판의 색깔 규칙이 똑같음을 이용
                first_c = !first_c;
            }
            first_c = !first_c;
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
        
        int n_range = N - 7;            //N = 10, M = 13인 경우 시작 인덱스는 (0,0) ~ (2,5)까지 가능하다.
        int m_range = M - 7;            //즉, 시작 인덱스의 범위는 0 ~ (N - 7) - 1, 0 ~ (M - 7) - 1이다.
        
        for (int i = 0; i < n_range; i++) {
            for (int j = 0; j < m_range; j++) {
                min = Math.min(min, getFillCnt(i,j));
            }
        }
        System.out.println(min);
    }
    
}
