package BFS.Baekjoon2206;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Point{
    int x;
    int y;
    boolean broken = false;
   
    public Point(int x, int y, boolean broken){
        this.x = x;
        this.y = y;
        this.broken = broken;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    public static void printStatus(StringBuilder[] map){
        for (StringBuilder stringBuilder : map) {
            System.out.println(stringBuilder);
        }
        System.out.println("");
        System.out.println("");
    }
    
    public static int bfs(StringBuilder[] map){
        int n = map.length;
        int m = map[0].length();
        boolean[][][]  visited = new boolean[n][m][2]; //벽을 부수지않았으면 0 = true, 부쉈으면 1 = true
        
        Queue<Point> q = new LinkedList<>();
        Queue<Integer> dis_q = new LinkedList<>();

        q.add(new Point(0,0, false));
        dis_q.add(1);
        visited[0][0][0] = true;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            int dis = dis_q.poll();
            //System.out.printf("now[%d][%d] br : %b\n", now.x, now.y, now.broken);
            //System.out.println("now.x : " + now.x + " now.y : " + now.y + " br : " + now.broken);
            if(now.x == n - 1 && now.y == m - 1) return dis;
            
            for (int i = 0; i < 4; i++) {
                Point next = new Point(now.x + dx[i], now.y + dy[i], now.broken);
                
                if(next.x < 0 || next.x >= n || next.y < 0 || next.y >= m) continue;
                
                if(next.x == n - 1 && next.y == m - 1) return dis + 1;
                else if(!visited[next.x][next.y][0] && !visited[next.x][next.y][1]){  //방문하지 않은 경우
                    if(map[next.x].charAt(next.y) == '0'){
                        q.add(next);
                        dis_q.add(dis + 1);
                        visited[next.x][next.y][0] = true;
                        //System.out.printf("Add next[%d][%d] br : %b\n", next.x, next.y, next.broken);
                        //System.out.println("Add next.x : " + next.x + " next.y : " + next.y + " br : " + next.broken);
                    }
                    else if(!next.broken){ //map이 1이면서 벽을 하나도 안 부쉈을 때(벽을 부수고 감)
                        next.broken = true;
                        q.add(next);
                        dis_q.add(dis + 1);
                        visited[next.x][next.y][1] = true;
                        //System.out.printf("Add next[%d][%d] br : %b\n", next.x, next.y, next.broken);
                        //System.out.println("Add next.x : " + next.x + " next.y : " + next.y + " br : " + next.broken);
                    }
                }
            }
            //System.out.println("");
        }
        
        return -1;
    }
    
//    public static int getShortestDis(StringBuilder[] map, int n, int m){
//        int min_dis = Integer.MAX_VALUE; //벽을 하나도 부수지 않은 상태에서 목적지까지의 거리
//        boolean flag = !(bfs(map) == -1);
//        
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if(map[i].charAt(j) == '1'){
//                    map[i].setCharAt(j, '0');
//                    int dis = bfs(map);
//                    if(dis > 0) {
//                        min_dis = Math.min(min_dis, dis);
//                        flag = true;
//                    }
//                    map[i].setCharAt(j, '1'); //bfs를 돌리고 난 후 벽 원상복구
//                }
//            }
//        }
//        
//        return flag ? min_dis : -1;
//    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //세로(y)
        int m = sc.nextInt();   //가로(x)
        StringBuilder[] map = new StringBuilder[n];
        
        for (int i = 0; i < n; i++) {
            map[i] = new StringBuilder(sc.next());
        }
        
        System.out.println(bfs(map));
    }
}
