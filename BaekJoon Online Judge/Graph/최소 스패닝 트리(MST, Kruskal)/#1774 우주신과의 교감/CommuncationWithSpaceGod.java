/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MST.Baekjoon1774;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Coordinate{
    int x_;
    int y_;

    public Coordinate(int x, int y) {
        this.x_ = x;
        this.y_ = y;
    }
    
}
    
class Way implements Comparable<Way>{
    int[] node_ = new int[2];
    double dis_;

    public Way(int p1, int p2, double dis_) {
        this.node_[0] = p1;
        this.node_[1] = p2;
        this.dis_ = dis_;
    }
    
    @Override
    public int compareTo(Way o){
        if(this.dis_ - o.dis_ < 0) return -1;
        else return 1;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static int getParent(int[] parent, int x){
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }
    
    public static void unionParent(int x, int y, int[] parent){
        x = getParent(parent, x);
        y = getParent(parent, y);
        
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
    
    public static boolean isCycle(int x, int y, int[] parent){
        x = getParent(parent, x);
        y = getParent(parent, y);
        
        return x == y;
    }
    
    public static double getDistance(Coordinate p1, Coordinate p2){
        double x_dis = Math.pow(p1.x_ - p2.x_, 2);
        double y_dis = Math.pow(p1.y_ - p2.y_, 2);
        
        return Math.sqrt(x_dis + y_dis);
    }
    
    public static ArrayList<Way> setWays(ArrayList<Coordinate> posit){
        int n = posit.size();
        ArrayList<Way> ways = new ArrayList<>();
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                ways.add(new Way(i, j, getDistance(posit.get(i), posit.get(j))));
            }
        }
        
        Collections.sort(ways);
        return ways;
    }
    
    public static double computeWay(ArrayList<Way> ways, int[] parent){
        double way_length = 0;
        
        for (Way way : ways) {
            if(!isCycle(way.node_[0], way.node_[1], parent)){
                way_length += way.dis_;
                unionParent(way.node_[0], way.node_[1], parent);
                System.out.println(way.node_[0] + " " + way.node_[1] + " : " + way.dis_);
            }
        }
        
        return way_length;
    }
        
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();   //우주신의 수 - 노드
        int m = sc.nextInt();   //이미 연결된 신들과의 통로 개수
        int[] parent = new int[n];
        ArrayList<Coordinate> posit = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            posit.add(new Coordinate(sc.nextInt(), sc.nextInt()));
        }
        
        for (int i = 0; i < m; i++) {
            unionParent(sc.nextInt() - 1, sc.nextInt() - 1, parent);
        }
        
        System.out.printf("%.2f\n",computeWay(setWays(posit), parent));
    }
    
}
