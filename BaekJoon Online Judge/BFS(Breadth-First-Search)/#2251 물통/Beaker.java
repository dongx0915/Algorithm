/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Pair {
    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Beaker {

    /**
     * @param args the command line arguments
     */
    public static int[] beaker;   //각 비커의 최대 용량
    public static int[] from = {2,2,1,1,0,0};       //비커를 옮기는 모든 경우의수
    public static int[] to =   {0,1,0,2,1,2};       // C > A, C > B, B > A, B > C, A > B, A > C
    public static boolean[][] visited = new boolean[201][201];  
    public static boolean[] answer = new boolean[201];      //Answer은 C 비커의 크기만큼 할당해도됨(C 비커의 상태를 출력하는 것이기 때문에 인덱스가 C 비커의 용량 이상을 넘어갈리없음)

    public static String getStatusOfC() {
        StringJoiner sj = new StringJoiner(" ");
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, 0));
        answer[beaker[2]] = true;
        
        while(!q.isEmpty()){
            Pair now = q.poll();
            int a = now.a;
            int b = now.b;
            int c = beaker[2] - now.a - now.b;
            
            for (int i = 0; i < 6; i++) {
                int[] next = {a,b,c};               //현재 비커들의 상태로 저장
                
                next[to[i]] += next[from[i]];       //from에서 to로 물을 옮김
                next[from[i]] = 0;                  //옮긴 비커는 비워짐
                
                if(next[to[i]] > beaker[to[i]]){    //물을 받은 비커가 넘쳤을 때
                    next[from[i]] = next[to[i]] - beaker[to[i]];    //넘친만큼은 다시 원래 비커로 넣어줌
                    next[to[i]] = beaker[to[i]];
                }
                
                if(!visited[next[0]][next[1]]){     //비커 A와B로 상태 체크(C는 total - a - b이므로
                    q.add(new Pair(next[0], next[1]));
                    visited[next[0]][next[1]] = true;
                    if(next[0] == 0) answer[next[2]] = true;
                }
            }
        }
        
        for (int i = 0; i <= beaker[2]; i++) {      //C의 상태이므로 C의 용량보다 큰 범위는 접근을 할 필요가 없음
            if(answer[i]) sj.add(i + "");
        }
        return sj.toString();
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        beaker = new int[3];
        beaker[0] = Integer.parseInt(input[0]);
        beaker[1] = Integer.parseInt(input[1]);
        beaker[2] = Integer.parseInt(input[2]);
        
        System.out.println(getStatusOfC());
    }

}
