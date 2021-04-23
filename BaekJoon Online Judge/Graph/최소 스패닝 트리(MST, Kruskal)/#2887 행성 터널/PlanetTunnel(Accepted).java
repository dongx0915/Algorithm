/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MST.Baekjoon2887;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Planet{
    int node_;
    int x_;
    int y_;
    int z_;

    public Planet(int node, int x, int y, int z) {
        this.node_ = node;
        this.x_ = x;
        this.y_ = y;
        this.z_ = z;
    }
}

class Edge implements Comparable<Edge>{
    int[] node_ = new int[2];
    int cost_;

    public Edge(int n1, int n2, int cost) {
        this.node_[0] = n1;
        this.node_[1] = n2;
        this.cost_ = cost;
    }
    
    @Override
    public int compareTo(Edge o){
        return this.cost_ - o.cost_;
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
    
    public static int connectCost(Planet p1, Planet p2){
        int x_dis = Math.abs(p1.x_ - p2.x_);
        int y_dis = Math.abs(p1.y_ - p2.y_);
        int z_dis = Math.abs(p1.z_ - p2.z_);
        
        return Math.min(x_dis, Math.min(y_dis, z_dis));
    }

    public static int compute_min_cost(ArrayList<Edge> edges, int[] parent){
        int cost = 0;
        Collections.sort(edges);

        for (Edge edge : edges) {
            if(!isCycle(edge.node_[0], edge.node_[1], parent)){
                cost += edge.cost_;
                unionParent(edge.node_[0], edge.node_[1], parent);
            }
        }
        
        return cost;
    }
        
    public static void addEdge(ArrayList<Planet> planets, ArrayList<Edge> edges){
        int nums_planet = planets.size();
        for (int i = 0; i < nums_planet - 1; i++) {
            Planet p1 = planets.get(i);
            Planet p2 = planets.get(i + 1);
            edges.add(new Edge(p1.node_, p2.node_, connectCost(p1, p2)));
        }
    }
    
    public static void sortPlanet(ArrayList<Planet> planets, char type){
        Collections.sort(planets, new Comparator<Planet>(){
            @Override
            public int compare(Planet p1, Planet p2){
                switch (type) {
                    case 'x': return p1.x_ - p2.x_;
                    case 'y': return p1.y_ - p2.y_;
                    case 'z': return p1.z_ - p2.z_;
                    default: break;
                }
                return 0;
            }
        });
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       //행성의 개수
        int[] parent = new int[n];
        ArrayList<Planet> planets = new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            planets.add(new Planet(i, sc.nextInt(), sc.nextInt(), sc.nextInt()));
            parent[i] = i;
        }
        
        sortPlanet(planets, 'x');
        addEdge(planets, edges);
        
        sortPlanet(planets, 'y');
        addEdge(planets, edges);
        
        sortPlanet(planets, 'z');
        addEdge(planets, edges);
        
        System.out.println(compute_min_cost(edges, parent));
    }
    
}
