/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ1953;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static final boolean BLUE = true, WHITE = false;
    public static ArrayList<Integer>[] adj;
    public static boolean[] checkTeam;
    public static PriorityQueue<Integer> blueTeam, whiteTeam;
    
    public static void dfs(int root, boolean team){
        if(team == BLUE) blueTeam.add(root);      
        else whiteTeam.add(root);
        
        checkTeam[root] = true;             //root가 팀에 들어감을 체크
        
        for (Integer next : adj[root]) {
            if(checkTeam[next]) continue;   //이미 팀에 들어갔으면 패스
            dfs(next, !team);
        }
    }
    
    public static void makeTeam(int n){
        for (int i = 1; i < n + 1; i++) {
            if(checkTeam[i]) continue;
            
            dfs(i, BLUE);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       //학생 수
        adj = new ArrayList[n + 1];
        blueTeam = new PriorityQueue<>();
        whiteTeam = new PriorityQueue<>();
        checkTeam = new boolean[n + 1];
        
        for (int i = 1; i < n + 1; i++) adj[i] = new ArrayList<>();
        
        for (int i = 1; i < n + 1; i++) {
            int hate = sc.nextInt();
            
            while(hate-- != 0){
                int person = sc.nextInt();
                adj[i].add(person);
                adj[person].add(i);
            }
        }
        
        makeTeam(n);
        
        StringJoiner sj = new StringJoiner(" ");
        
        System.out.println(blueTeam.size());
        
        while(!blueTeam.isEmpty()) sj.add(blueTeam.poll() + "");
        System.out.println(sj.toString());
        
        sj = new StringJoiner(" ");
        
        System.out.println(whiteTeam.size());
        while(!whiteTeam.isEmpty()) sj.add(whiteTeam.poll() + "");
        
        System.out.println(sj.toString());
    }
    
}
