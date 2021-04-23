/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MST.Baekjoon6497;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Road implements Comparable<Road>{
    int[] node_ = new int[2];
    int dis_;

    public Road(int r1, int r2, int dis_) {
        this.node_[0] = r1;
        this.node_[1] = r2;
        this.dis_ = dis_;
    }   
    
    @Override
    public int compareTo(Road o){
        return this.dis_ - o.dis_;
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
    
    
    //절약할 수 있는 최대 비용이므로 없애는 비용을 구해야함
    public static int computeSavingCost(ArrayList<Road> roads, int[] parent){
        int saving_cost = 0;
        Collections.sort(roads);
        
        for (Road road : roads) {
            if(!isCycle(road.node_[0], road.node_[1], parent)){
                unionParent(road.node_[0], road.node_[1], parent);
            }
            else saving_cost += road.dis_;
        }
        
        return saving_cost;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        while(true){
            int m = sc.nextInt();   //집(정점)의 수 (1   <= m <= 200,000)
            int n = sc.nextInt();   //길(간선)의 수 (m-1 <= n <= 200,000)
            
            if(m == 0 && n == 0) break;
            
            int[] parent = new int[m];
            ArrayList<Road> roads = new ArrayList<>();
            
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }
            
            for (int i = 0; i < n; i++) {
                roads.add(new Road(sc.nextInt(), sc.nextInt(), sc.nextInt()));
            }
            
            System.out.println(computeSavingCost(roads, parent));
        }
    }
    
}
