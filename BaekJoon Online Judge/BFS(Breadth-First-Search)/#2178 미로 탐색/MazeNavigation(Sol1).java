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
    static int[] dx = {0, 1, 0, -1};                    //상, 우, 하, 좌
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited;

    public static boolean checkRoute(int x, int y) {
        if (x < 0 || x >= col || y < 0 || y >= row) {
            return false;                               //범위를 벗어나면 false
        }
        if (visited[x][y]) {
            return false;                               //이미 방문한 곳이면 false
        }
        return maze[x].charAt(y) != '0';
    }

    public static int searchShortestRoute(String[] maze) {
        int dist = 1;                                                                              //시작부터 1칸이므로 1로 초기화
        boolean isArrived = false;
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(0, 0));                                                                    //시작 지점 삽입
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int thisTurnSize = q.size();                                                           //thisTurnSize : 현재 턴에 갈 수 있는 경로의 수
            dist++;
            for (int i = 0; i < thisTurnSize; i++) {                                                
                Point nowP = q.poll();
                
                for (int j = 0; j < 4; j++) {
                    Point nextP = new Point(nowP.x + dx[j], nowP.y + dy[j]);
                    if(nextP.x == col - 1 && nextP.y == row - 1) {isArrived = true; break;}         //도착 지점이면 break
                    if (checkRoute(nextP.x, nextP.y)) {                                             //갈 수 있는 경로인지 체크
                        visited[nextP.x][nextP.y] = true;
                        q.add(nextP);
                    }
                }
                if(isArrived) break;
            }
            if(isArrived) break;
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
