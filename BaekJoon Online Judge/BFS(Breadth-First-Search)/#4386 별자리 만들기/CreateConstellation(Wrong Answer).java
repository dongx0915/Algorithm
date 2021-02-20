/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS.Baekjoon4386;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Point{
    double x;
    double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static double getDistance(Point s1, Point s2){
        return Math.sqrt(Math.pow(s1.x - s2.x, 2) + Math.pow(s1.y - s2.y , 2));
    }
    
    public static void setDistance(int n, double[][] dis, Point[] star){
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //if(i == j) continue;
                if(dis[i][j] == -1) dis[i][j] = dis[j][i] = getDistance(star[i], star[j]);
            }
        }
    }
    
    public static double bfs(int root, int n, double[][] dis, Point[] star){
        double cost = 0;
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> cnt_q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        q.add(root);
        cnt_q.add(1);
        visited[root] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            int cnt = cnt_q.poll();
            if(cnt == n) return cost;
            
            
            for (int i = 0; i < n; i++) {
                if(dis[root][i] != -1 && !visited[i]){
                    //System.out.printf("root = %d i = %d\n", root, i);
                    q.add(i);
                    cnt_q.add(cnt + 1);
                    visited[i] = true;
                    cost += getDistance(star[now], star[i]);
                    //System.out.println("Cost = " + cost);
                }
            }
        }
        
        return cost;
    }
    public static double getMinimumCost(int n, double[][] dis, Point[] star){
        double min = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Double.min(min, bfs(i, n, dis, star));
        }
        return min;
    }
    
    public static void printDis(double[][] dis){
        for (double[] di : dis) {
            for (double d : di) {
                System.out.printf("%.2f  ", d);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[][] dis = new double[n][n];
        Point[] star = new Point[n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], -1);
            star[i] = new Point(sc.nextDouble(), sc.nextDouble());
        }
        setDistance(n, dis, star);
        //printDis(dis);
        System.out.printf("%.2f\n", getMinimumCost(n, dis, star));
        
    }
    
}
