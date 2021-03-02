/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.Baekjoon16948;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Point{
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
    
}
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int[] dx = {-2,-2, 0, 0, 2, 2};
    public static int[] dy = {-1, 1,-2, 2,-1, 1};
    
    public static int bfs(int[][] board, Point start, Point end){
        int n = board.length;
        Queue<Point> q = new LinkedList<>();
        Queue<Integer> cnt_q = new LinkedList<>();
        q.add(start);
        cnt_q.add(0);
        board[start.r][start.c] = 1;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            int cnt = cnt_q.poll();
            //System.out.printf("now[%d][%d]\n", now.r, now.c);
            for (int i = 0; i < 6; i++) {
                Point next = new Point(now.r + dx[i], now.c + dy[i]);
                if(next.r < 0 || next.r >= n || next.c < 0 || next.c >= n) continue;
                if(next.r == end.r && next.c == end.c) return cnt + 1;
                if(board[next.r][next.c] == 0){
                    q.add(next);
                    //System.out.printf("Add next[%d][%d]\n", next.r, next.c);
                    cnt_q.add(cnt + 1);
                    board[next.r][next.c] = 1;
                }
            }
            //System.out.println("");
        }
        
        
        return -1;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        Point start = new Point(sc.nextInt(), sc.nextInt());
        Point end = new Point(sc.nextInt(), sc.nextInt());
        
        System.out.println(bfs(board, start, end));
        
    }
    
}
