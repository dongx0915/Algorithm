/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MST.Baekjoon1647;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Road implements Comparable<Road>{
    int[] house = new int[2];
    int cost;

    public Road(int house1, int house2, int cost) {
        this.house[0] = house1;
        this.house[1] = house2;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Road o){
        return this.cost - o.cost;
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
            
    public static boolean checkCycle(int x, int y, int[] parent){
        x = getParent(parent, x);
        y = getParent(parent, y);
        
        return x == y;
    }
    
    public static int getMaintenanceCosts(ArrayList<Road> roads, int[] parent){
        int cost = 0;
        int most_expensive_cost = 0;
        
        for (Road road : roads) {
            if(!checkCycle(road.house[0] - 1, road.house[1] - 1, parent)){
                cost += (most_expensive_cost = road.cost);
                unionParent(road.house[0] - 1, road.house[1] - 1, parent);
            }
        }
        
        return cost - most_expensive_cost;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       //집(노드)의 개수
        int m = sc.nextInt();       //길(간선)의 개수
        int[] parent = new int[n];
        ArrayList<Road> roads = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
            roads.add(new Road(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        
        Collections.sort(roads);
        System.out.println(getMaintenanceCosts(roads, parent));
    }
    
}
