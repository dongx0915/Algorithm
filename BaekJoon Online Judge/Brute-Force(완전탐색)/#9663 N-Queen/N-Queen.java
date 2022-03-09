/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gold.BOJ9663;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {
    public static final int QUEEN = -1;
    public static int N, result = 0, next_y, next_x;
    public static int[][] board;
    public static int[] dy = {-1,-1, 1, 1};
    public static int[] dx = {-1, 1, 1,-1};
    
    public static void setQueenArea(int y, int x, int set){  
        // 가로
        for (int i = 0; i < N; i++) if(board[y][i] != -1) board[y][i] += set;
        
        // 세로
        for (int i = 0; i < N; i++) if(board[i][x] != -1) board[i][x] += set;
        
        // 대각선

        for (int i = 0; i < 4; i++) {
            next_y = y;
            next_x = x;

            while(true){
                next_y += dy[i];
                next_x += dx[i];

                if(next_y >= N || next_x >= N || next_y < 0 || next_x < 0) break;
                
                if(board[next_y][next_x] != -1) board[next_y][next_x] += set;
            }
        }
    }
    
    public static void nQueen(int col, int queen){
        if(queen == N){
            result++;
            return;
        }
        
      //퀸은 한 줄에 하나 씩 밖에 놓을 수 없으므로 해당 가로 줄만 탐색
        for (int row = 0; row < N; row++) {
                // 퀸을 놓을 수 있는 자리가 아니면 Continue
                if(board[col][row] != 0) continue;                        
                
                setQueenArea(col, row, 1);
                board[col][row] = QUEEN;    
                
                nQueen(col+1, queen+1);
                
                // 퀸의 범위를 지워 줌
                setQueenArea(col, row, -1);
                board[col][row] = 0;
        }
    }
        
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
            
        board = new int[N][N];
        
        nQueen(0, 0);
        System.out.println(result);
               
    }
    
}
