/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kruskal;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Donghyeon <20183188>
 */

class Edge implements Comparable<Edge>{
    int[] node = new int[2];
    int distance;

    public Edge(int a, int b, int distance) {
        this.node[0] = a;
        this.node[1] = b;
        this.distance = distance;
    }
    
    @Override
    public int compareTo(Edge o){
        return this.distance - o.distance;
    }
}

public class Kruskal {

    /**
     * @param args the command line arguments
     */
    
    // 부모 노드를 찾는 함수
    public static int getParent(int[] parent, int x){
        if(parent[x] == x) return x; //x의 부모가 자신이라는 것은 최상위 노드인 것
        return parent[x] = getParent(parent, parent[x]);
    }
    
    // 두 부모 노드를 합치는 함수(같은 그래프에 속하도록 두 노드를 이어주는 것)
    public static void unionParent(int parent[], int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);
        
        if(a < b) parent[b] = a;        //더 작은 쪽을 부모로 선택
        else parent[a] = b;
    }
    
    // 같은 부모를 가지는지 확인
    public static boolean findParent(int[] parent, int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);
        return a == b;
    }
    
    public static int getCost(ArrayList<Edge> e, int[] parent){
        int sum = 0;
        for (Edge edge : e) {
            //서로 연결 된 두 노드가 같은 부모를 가지지 않는다면(연결이 되어있지 않은 상태) - 사이클이 아닌 상태
            if(!findParent(parent, edge.node[0] - 1, edge.node[1] - 1)){
                sum += edge.distance;                                       //거리를 더해줌
                unionParent(parent, edge.node[0] - 1, edge.node[1] - 1);    //실제로 그래프 상에서 두 노드를 이어줌
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 7;      //노드(정점)의 개수
        int m = 11;     //엣지(간선)의 개수
        
        //간선 정보를 저장하는 리스트(간선의 정보를 저장할 뿐, 그래프가 연결 되어있는 상태는 아님)
        ArrayList<Edge> e = new ArrayList<>();
        e.add(new Edge(1, 7, 12));
        e.add(new Edge(1, 4, 28));
        e.add(new Edge(1, 2, 67));
        e.add(new Edge(1, 5, 17));
        
        e.add(new Edge(2, 4, 24));
        e.add(new Edge(2, 5, 62));
        
        e.add(new Edge(3, 5, 20));
        e.add(new Edge(3, 6, 37));
        
        e.add(new Edge(4, 7, 13));
        
        e.add(new Edge(5, 7, 73));
        e.add(new Edge(5, 6, 45));
        
        Collections.sort(e);
        
        for (Edge edge : e) {
            System.out.println(edge.node[0] + " | " + edge.node[1]);
            System.out.println(" " + edge.distance);
            System.out.println("");
        }
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        System.out.println("최소 비용은 ? : " + getCost(e, parent)); 
    }
}
