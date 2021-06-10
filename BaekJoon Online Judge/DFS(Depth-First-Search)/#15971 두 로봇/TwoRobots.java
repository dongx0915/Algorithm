/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ15971;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Edge{
    int node_;
    int dis_;

    public Edge(int node_, int dis_) {
        this.node_ = node_;
        this.dis_ = dis_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int N;
    public static ArrayList<Edge>[] graph;
    public static boolean[] visited;
    public static int[][] robot_dis;
    public static final int R1 = 0, R2 = 1;
    
    //R은 로봇의 종류
    //robot_dis[로봇 종류][노드] = 거리
    
    public static void setDisDfs(int root, int dis, int R){
        robot_dis[R][root] = dis;
        
        for (Edge next : graph[root]) {
            if(visited[next.node_]) continue;
            visited[next.node_] = true;
            setDisDfs(next.node_, dis + next.dis_, R);
            visited[next.node_] = false;
        }
        
    }
    
    public static void setDistance(int robot1, int robot2){
        visited[robot1] = true;
        setDisDfs(robot1, 0, R1);
        visited[robot1] = false;
        
        visited[robot2] = true;
        setDisDfs(robot2, 0, R2);
        visited[robot2] = false;
        
//        printDis(R1);
//        printDis(R2);
    }
    
    public static int getMinDistance(int robot1, int robot2){
        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i < N + 1; i++) {
            for (Edge child : graph[i]) {
                min = Math.min(min, robot_dis[R1][i] + robot_dis[R2][child.node_]);
            }
        }
        
//        for (int i = 1; i < N + 1; i++) {
//            for (Edge child : graph[i]) {
//                min = Math.min(min, robot_dis[R2][i] + robot_dis[R1][child.node_]);
//            }
//        }
        
        return min;
    }
    
    public static void printDis(int robot){
        System.out.println((robot+1) + " 로봇 : ");
        for (int is : robot_dis[robot]) {
            System.out.print(is + " ");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        robot_dis = new int[2][N + 1];
        
        for (int i = 0; i < N + 1; i++) graph[i] = new ArrayList<>();
        
        int robot1 = sc.nextInt();
        int robot2 = sc.nextInt();
        
        for (int i = 0; i < N - 1; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int dis = sc.nextInt();
            
            graph[n1].add(new Edge(n2, dis));
            graph[n2].add(new Edge(n1, dis));
        }
        
        if(robot1 == robot2) System.out.println("0");
        else{
            setDistance(robot1, robot2);
            System.out.println(getMinDistance(robot1, robot2));
        }
    }
    
}
