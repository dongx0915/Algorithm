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
public class HideAndSeek2 {

    /**
     * @param args the command line arguments
     */
    public static int sp;               //수빈이의 위치
    public static int bp;               //동생의 위치
    public static int[] dx = {-1, 1, 0};
    public static int[] dy = { 1, 1, 2};
    public static boolean[] visited = new boolean[100001];
    
    public static String getCatchTime(){
        int cases = 0, min = -1;
        Queue<Integer> time = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(sp);
        time.add(0);
        
        while(!q.isEmpty()){
            int now = q.poll();
            int nowTime = time.poll();
            visited[now] = true;
            
            if(now == bp){                                        //동생을 잡은 경우
                if(min == -1) min = nowTime;                      //제일 처음 잡은 경우가 최소 시간이므로 min을 현재 시간으로 설정
                if(min == nowTime) cases++;                       //min과 현재 시간이 같으면(최소 시간으로 잡은 경우) cases(경우의 수) 1 증가
                continue;
            }
            
            for (int i = 0; i < 3; i++) {
                int next = (now + dx[i]) * dy[i];
                if(next < 0 || next > 100000) continue;
                if(visited[next] && next != bp) continue;         //이미 방문한 곳인데 동생을 잡는 위치가 아니면 continue
                                                                  //이미 방문을 했지만 동생을 잡는 위치이면 Enqueue
                q.add(next);
                time.add(nowTime + 1);
            }
        }
        return min + "\n" + cases;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        sp = sc.nextInt();
        bp = sc.nextInt();
        
        System.out.println(getCatchTime());
    }
}
