/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.Baekjoon14226;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Emoticon{
    int clipboard_;
    int screen_;
    int time_;

    public Emoticon(int clipboard, int screen, int time) {
        this.clipboard_ = clipboard;
        this.screen_ = screen;
        this.time_ = time;
    }
}

public class Main {
    /**
     * @param args the command line arguments
     */
    
    //visited[클립보드에 이모티콘 수][화면에 이모티콘 수];
    public static boolean[][] visited = new boolean[1001][1001];
    
    //클립보드에 저장 - 1초
    //붙여넣기 - 1초
    //이모티콘 하나 삭제 - 1초
    public static int bfs(int s){
        Queue<Emoticon> q = new LinkedList<>();

        //new Emoticon(clipboard, screen, time);
        q.add(new Emoticon(0, 1, 0));

        while(!q.isEmpty()){
            Emoticon cur = q.poll();
            if(cur.screen_ == s) return cur.time_;
            
            //클립보드에 저장
            q.add(new Emoticon(cur.screen_, cur.screen_, cur.time_ + 1));
            
            //클립보드에 있는 이모티콘 붙여넣기
            //이전에서 복사를 하지않은 경우(클립보드 유지)
            if (cur.clipboard_ != 0 && (cur.screen_ + cur.clipboard_) <= s && !visited[cur.clipboard_][cur.screen_ + cur.clipboard_]) {
                q.add(new Emoticon(cur.clipboard_, cur.screen_ + cur.clipboard_, cur.time_ + 1));
                visited[cur.clipboard_][cur.screen_ + cur.clipboard_] = true;
            }
            
            //입력된 이모티콘 하나 삭제
            if (cur.screen_ != 0 && visited[cur.clipboard_][cur.screent_ - 1]) {
                q.add(new Emoticon(cur.clipboard_, cur.screen_ - 1, cur.time_ + 1));
                visited[cur.clipboard_][cur.screen_ - 1] = true;  
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();       //만들어야하는 이모티콘 개수
        
        System.out.println(bfs(s));    
    }
    
}
