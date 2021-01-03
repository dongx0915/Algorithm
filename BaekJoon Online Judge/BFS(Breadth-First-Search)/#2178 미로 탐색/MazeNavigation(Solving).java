/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MazeNavigation {

    /**
     * @param args the command line arguments
     */
    static int col, row;
    static int[][] maze;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited;

    public static boolean checkRoute(int x, int y) {
        if (x < 0 || x >= col || y < 0 || y >= row) {
            return false; //범위를 벗어나면 false]=
        }
        if (visited[x][y]) {
            return false;         //이미 방문한 곳이면 false
        }
        return maze[x][y] != 0;
    }

    public static int searchShortestRoute(int[][] maze) {
        System.out.println("들어옴");
        int dist = 1;
        boolean isArrived = false;
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            System.out.println("돌고있다.");
            int thisTurnSize = q.size();
            
            for (int i = 0; i < thisTurnSize; i++) {
                Point nowP = q.poll();
                
                for (int j = 0; j < 4; j++) {
                    Point nextP = new Point(nowP.x + dx[j], nowP.y + dy[j]);
                    if(nextP.x == col && nextP.y == row) {isArrived = true; break;}
                    if (checkRoute(nextP.x, nextP.y)) {
                        q.add(nextP);
                    }
                }
                if(isArrived) break;
            }
            if(isArrived) break;
            dist++;
        }
        
        return dist;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        col = sc.nextInt();
        row = sc.nextInt();
        maze = new int[col][row];
        visited = new boolean[col][row];

        
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.printf("maze[%d][%d] = ", i,j);
                maze[i][j] = sc.nextInt();
            }
        }
        
        System.out.println(searchShortestRoute(maze));
    }

}
