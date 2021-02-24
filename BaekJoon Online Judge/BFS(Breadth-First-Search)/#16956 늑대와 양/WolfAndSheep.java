/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.Baekjoon16956;

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
     */
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    
    public static boolean checkRange(int y, int x, StringBuilder[] farm){
        return !(y < 0 || y >= farm.length || x < 0 || x >= farm[0].length());
    }
    
    public static Queue<Point> setFence(StringBuilder[] farm){
        Queue<Point> wolf_q = new LinkedList<>();
        int y = farm.length;
        int x = farm[0].length();

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(farm[i].charAt(j) == 'S'){
                    wolf_q.add(new Point(i, j));
                    for (int k = 0; k < 4; k++) {
                        int next_i = i + dx[k];
                        int next_j = j + dy[k];
                        if(checkRange(next_i, next_j,farm)){              //길을 울타리로 바꿔주는 부분(replace로 한 번에 해도됨)
                            if(farm[next_i].charAt(next_j) == '.'){
                                farm[next_i].setCharAt(next_j, 'D');
                            }
                        }
                    }
                }
            }
        }
        return wolf_q;
    }
    
    public static boolean bfs(Point root, StringBuilder[] farm){
          //        StringBuilder[] copy = new StringBuilder[farm.length];
          //        for (int i = 0; i < farm.length; i++) {
          //            copy[i] = new StringBuilder(farm[i].toString());
          //        }
      
          /*
          * StringBuilder 배열을 bfs 돌 때마다 복사하는 과정때문에 시간초과남
          */
        
        Queue<Point> q = new LinkedList<>();
        q.add(root);
        //copy[root.x].setCharAt(root.y, '#');
        
        while(!q.isEmpty()){
            Point now = q.poll();
            
            for (int i = 0; i < 4; i++) {
                Point next = new Point(now.x + dx[i], now.y + dy[i]);
                if(checkRange(next.x, next.y, farm)){
                    if(farm[next.x].charAt(next.y) == 'W') return false;
                }
            }
        }
        
        return true;
    }
    public static void isSafetyZone(StringBuilder[] farm, Queue<Point> wolf_q){
        while(!wolf_q.isEmpty()){
            if(!bfs(wolf_q.poll(), farm)){      //늑대와 양이 만나는 순간 바로 0 출력
                System.out.println("0");
                return;
            }
        }
        
                                                //늑대와 양이 한 번도 안만났을 경우
        System.out.println("1");
        for (StringBuilder stringBuilder : farm) {
            System.out.println(stringBuilder);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();  //세로(y)
        int x = sc.nextInt();  //가로(x)
        StringBuilder[] farm = new StringBuilder[y];
        
        for (int i = 0; i < y; i++) {
            //farm[i] = new StringBuilder(sc.next().replace('.', 'D'));
            farm[i] = new StringBuilder(sc.next());
            //replace로 한 번에 다 바꾸는 것보다 일일이 하나씩 setCharAt으로 바꾸는게 더 빠름
        }
        
        isSafetyZone(farm, setFence(farm));
    }
    
}
