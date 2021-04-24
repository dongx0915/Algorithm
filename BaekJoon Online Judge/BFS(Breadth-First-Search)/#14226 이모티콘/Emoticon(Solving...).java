/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.Baekjoon11559;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */

public class Main {
    /**
     * @param args the command line arguments
     */
    
    //클립보드에 저장 - 1초
    //붙여넣기 - 1초
    //이모티콘 하나 삭제 - 1초
    public static int bfs(int s){
        int result = 0;
        int prev_clip = 0;
        int cur_clip = 0;
        
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> time_q = new LinkedList<>();

        q.add(1);
        time_q.add(0);

        while(!q.isEmpty()){
            int cur_s = q.poll();
            int cur_time = time_q.poll();
            
            if(cur_s == s) return cur_time;
            
            //클립보드에 저장
            cur_clip = cur_s;
            q.add(cur_s);
            time_q.add(cur_time + 1);

            //클립보드에 있는 이모티콘 붙여넣기
            //이전에서 복사를 하지않은 경우(클립보드 유지)
            if (prev_clip != 0) {
                q.add(cur_s + prev_clip);
                time_q.add(cur_time + 1);
            }
            
            //입력된 이모티콘 하나 삭제
            if (cur_s != 0) {
                q.add(cur_s - 1);
                time_q.add(cur_time + 1);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();       //만들어야하는 이모티콘 개수
        
        System.out.println(bfs(s));    
    }
    
}
