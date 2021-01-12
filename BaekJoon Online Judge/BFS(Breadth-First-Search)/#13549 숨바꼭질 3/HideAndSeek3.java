/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HideAndSeek2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class HideAndSeek3 {

    static class Data{
        int posit, time;
        public Data(int posit, int time){
            this.posit = posit;
            this.time = time;
        }
    }
    
    public static int sp;               //수빈이 위치
    public static int bp;               //동생 위치
    public static int[] dx = {-1, 1, 0};
    public static int[] dy = { 1, 1, 2};
    public static boolean[] visited = new boolean[100001];
    
    public static int getCatchTime(){
        Queue<Data> q = new LinkedList<>();
        int min = 10000001;
        q.add(new Data(sp, 0));
        
        while(!q.isEmpty()){
            Data now = q.poll();
            visited[now.posit] = true;
            
            if(now.posit == bp) if(min > now.time) min = now.time;                                          //순간이동은 시간이 걸리지 않기 때문에 bfs에서 가장 먼저 동생을 잡는 경우가
                                                                                                            //최소 시간이 아닐 수 있으므로 최솟 값을 구해준다.
            for (int i = 0; i < 3; i++) {
                Data next = new Data((now.posit + dx[i]) * dy[i], (i == 2) ? now.time : now.time + 1);      //순간이동(x * 2)인 경우에는 시간을 증가시키지 않음
                if(next.posit < 0 || next.posit > 100000) continue;
                if(visited[next.posit]) continue;
                
                q.add(next);
            }
        }
        return min;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        sp = sc.nextInt();
        bp = sc.nextInt();
        
        System.out.println(getCatchTime());
    }
    
}
