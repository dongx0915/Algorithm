/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    static final int MAX_N = 500000;
    static int[] dx = {-1, 1, 0};
    static int[] dy = { 1, 1, 2};
    static int subin;
    static int brother;
    static boolean[][] visited;
    static boolean isMeet = false;
    
    public static int searchTimeToBFS(){
        if(subin == brother) return 0;              //수빈이와 동생의 위치가 이미 같으면 리턴 0(0초)
        Queue<Integer> q = new LinkedList<>();      //수빈이의 위치를 담을 큐
        
        visited[0][subin] = true;                   //처음 subin 위치를 true로 설정
        int turn = 1;
        q.add(subin);                               //처음 subin 위치를 queue에 삽입
        
        while(!q.isEmpty()){
            brother += turn;                        // if(subin == brother)에서 걸리지 않았다는 것은 첫 턴엔 만나지 않는다는 것이므로 2번쨰 턴부터 시작
            if(brother > MAX_N) break;              // 동생의 위치가 최댓값을 넘어가는 경우
            if(visited[turn % 2][brother]){ isMeet = true; break;}  //동생이 방문한 자리에 수빈이가 이미 방문을 했다면 잡은 것
            int thisTurnSize = q.size();                            //한 턴마다 갈 수 있는 수빈이의 경로를 Queue에 쌓기 때문에 Queue에 있는건 해당 턴에서 다 체크를 해야한다.
            
            for (int i = 0; i < thisTurnSize; i++) {
                int now_subin = q.poll();
                for (int j = 0; j < 3; j++) {
                    int next_subin = (now_subin + dx[j]) * dy[j];
                    if(next_subin < 0 || next_subin > MAX_N) continue; //범위를 초과하면 패스
                    if(next_subin == brother) { isMeet = true; break;} //만났으면 break
                    if(visited[turn % 2][next_subin]) continue;        //이미 방문했으면 패스
                    
                    visited[turn % 2][next_subin] = true;               //방문 가능한 곳이라 체크
                    q.add(next_subin);                                  //방문이 가능할 경우의 수빈이의 위치 삽입
                }
                if(isMeet) break;
            }
            if(isMeet) break;
            turn++;
        }
        
        if(isMeet) return turn;
        else return -1;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        subin = sc.nextInt();
        brother = sc.nextInt();
        visited = new boolean[2][MAX_N + 1];
        
        System.out.println(searchTimeToBFS());
    }
    
}
