/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HideAndSeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Donghyeon <20183188>
 */
public class HideAndSeek {

    /**
     * @param args the command line arguments
     */
    public static int sp, bp;
    public static int[][] dm = {{-1,1},{1,1},{0,2}};
    public static boolean[] visited = new boolean[100001];
    
    public static int getCatchTime(){
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> dayQ = new LinkedList<>();
        
        q.add(sp);
        dayQ.add(0);
        
        while(!q.isEmpty()){
            int now = q.poll();
            int day = dayQ.poll();
            visited[now] = true;
            if(now == bp) return day;
            
            for (int i = 0; i < 3; i++) {
                int next = (now + dm[i][0]) * dm[i][1];
                if(next < 0 || next > 100000 || visited[next]) continue;
                q.add(next);
                dayQ.add(day + 1);
            }
        }
        
        return 0;
    }
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        sp = Integer.parseInt(input[0]);
        bp = Integer.parseInt(input[1]);
        System.out.println(getCatchTime());
    }
    
}
