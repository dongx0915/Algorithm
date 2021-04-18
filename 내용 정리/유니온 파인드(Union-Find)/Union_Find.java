/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Union_Find;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Union_Find {

    /**
     * @param args the command line arguments
     */
    
    // 부모 노드를 찾는 함수
    public static int getParent(int[] parent, int x){
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }
    
    // 두 부모 노드를 합치는 함수(같은 그래프에 속하도록 두 노드를 이어주는 것)
    public static void unionParent(int parent[], int a, int b){
        a = getParent(parent, a);  //a의 부모를 찾음
        b = getParent(parent, b);  //b의 부모를 찾음
        
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    
    // 같은 부모를 가지는지 확인
    public static boolean findParent(int[] parent, int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);
        return a == b;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] parent = new int[11];
        for (int i = 1; i < 11; i++) {
            parent[i] = i;
        }
        
        unionParent(parent, 1, 2);
        unionParent(parent, 2, 3);
        unionParent(parent, 3, 4);
        unionParent(parent, 5, 6);
        unionParent(parent, 6, 7);
        unionParent(parent, 7, 8);
        System.out.println("1과 5는 연결 ? " + findParent(parent, 1, 5));
        unionParent(parent, 2, 8);
        System.out.println("1과 5는 연결 ? " + findParent(parent, 1, 5));
        System.out.println("2과 4는 연결 ? " + findParent(parent, 2, 4));
        System.out.println("1과 4는 연결 ? " + findParent(parent, 1, 4));
    }
    
}
