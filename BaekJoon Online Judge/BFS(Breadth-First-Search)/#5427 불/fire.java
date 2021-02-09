/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.Baekjoon5427;

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
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    /**
     * @param args the command line arguments
     * 
     */
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    
    public static String bfs(StringBuilder[] building, Queue<Point> fire_q, Queue<Point> user_q){
        int height = building.length;
        int width = building[0].length();
        Queue<Integer> time_q = new LinkedList<>();
        time_q.add(1);
        
        while(!user_q.isEmpty()){
            int fire_size = fire_q.size();
            
            while(fire_size-- > 0){
                Point now_fire = fire_q.poll();
                
                for (int i = 0; i < 4; i++) {
                    Point next_fire = new Point(now_fire.x + dx[i], now_fire.y + dy[i]);
                    if(next_fire.x < 0 || next_fire.x >= height || next_fire.y < 0 || next_fire.y >= width) continue;
                    if(building[next_fire.x].charAt(next_fire.y) == '.' || building[next_fire.x].charAt(next_fire.y) == '@'){
                        fire_q.add(next_fire);
                        building[next_fire.x].setCharAt(next_fire.y, '*');
                    }
                }
            }
            
            int user_size = user_q.size();
            while(user_size-- > 0){
                Point now_user = user_q.poll();
                int time = time_q.poll();
                if(now_user.x == 0 || now_user.x == height - 1 || now_user.y == 0 || now_user.y == width - 1) return time + "";
            
                for (int i = 0; i < 4; i++) {
                    Point next_user = new Point(now_user.x + dx[i], now_user.y + dy[i]);
                    if(next_user.x < 0 || next_user.x >= height || next_user.y < 0 || next_user.y >= width) continue;
                
                    if(building[next_user.x].charAt(next_user.y) == '.'){
                        user_q.add(next_user);
                        time_q.add(time + 1);
                        building[next_user.x].setCharAt(next_user.y, '@');
                    }
                }
            }
        }
        
        return "IMPOSSIBLE";
    }
    
    public static String getEscapeRoute(StringBuilder[] building, int width, int height){
        Queue<Point> fire_q = new LinkedList<>();
        Queue<Point> user_q = new LinkedList<>();
        
        //불의 위치와 상근이의 위치를 Queue에 넣고 시작
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(building[i].charAt(j) == '*') fire_q.add(new Point(i,j));
                else if(building[i].charAt(j) == '@') user_q.add(new Point(i,j));
            }
        }
        
        return bfs(building, fire_q, user_q);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int test = sc.nextInt();

        while(test-- != 0){
            int width = sc.nextInt();
            int height = sc.nextInt();
            StringBuilder[] building = new StringBuilder[height];
            for (int i = 0; i < height; i++) {
                building[i] = new StringBuilder(sc.next());
            }

            System.out.println(getEscapeRoute(building, width, height));
        }
    }
    
}
