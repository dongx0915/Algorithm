/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.BOJ5014;
import java.io.*;
import java.util.*;

public class Main {
    public static int floor;
    public static int cur;
    public static int goal;
    public static int up;       //up만큼 올라감
    public static int down;     //down만큼 내려감
    public static boolean[] visited;
    
    public static String getButtonClickCnt(){
        int clicked = 0;
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> click = new LinkedList<>();
        
        q.add(cur);
        click.add(0);
        visited[cur] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            clicked = click.poll();
            
            if(now == goal) return clicked + "";
            if(now + up <= floor && !visited[now + up]){
                q.add(now + up);
                click.add(clicked + 1);
                visited[now + up] = true;
            }
            if(now - down > 0 && !visited[now - down]){
                q.add(now - down);
                click.add(clicked + 1);
                visited[now - down] = true;
            }
        }
        return "use the stairs";
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        floor = Integer.parseInt(input[0]);
        cur = Integer.parseInt(input[1]);
        goal = Integer.parseInt(input[2]);
        up = Integer.parseInt(input[3]);
        down = Integer.parseInt(input[4]);
        visited = new boolean[floor + 1];
        
        System.out.println(getButtonClickCnt());
    }
}
