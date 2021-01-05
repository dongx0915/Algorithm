/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeNavigation;

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
    static String[] maze;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited;

    public static boolean checkRoute(int x, int y) {
        if (x < 0 || x >= col || y < 0 || y >= row) {
            return false; //범위를 벗어나면 false
        }
        if (visited[x][y]) {
            return false;         //이미 방문한 곳이면 false
        }
        return maze[x].charAt(y) != '0';
    }

    public static int searchShortestRoute(String[] maze) {
        int dist = 1;
        boolean isArrived = false;
        Queue<Point> q = new LinkedList<>();
        Queue<Integer> distQ = new LinkedList<>();
        
        q.add(new Point(0, 0));
        distQ.add(dist);
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point nowP = q.poll();
            dist = distQ.poll();
            if(nowP.x == col - 1 && nowP.y == row - 1) break;
            
            for (int i = 0; i < 4; i++) {
                Point nextP = new Point(nowP.x + dx[i], nowP.y + dy[i]);
                if(checkRoute(nextP.x, nextP.y)){
                    q.add(nextP);
                    distQ.add(dist + 1);
                    visited[nextP.x][nextP.y] = true;
                }
            }
            
        }
        
        return dist;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        col = sc.nextInt();
        row = sc.nextInt();
        maze = new String[col];
        visited = new boolean[col][row];

        
        for (int i = 0; i < col; i++) {
            maze[i] = sc.next();
        }
        
        System.out.println(searchShortestRoute(maze));
    }

}
