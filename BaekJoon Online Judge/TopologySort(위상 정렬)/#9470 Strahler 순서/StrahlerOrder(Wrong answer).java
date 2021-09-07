/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TopologySort.BOJ9470;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Node{
    int order_ = 1;
    boolean carry_ = false;
    ArrayList<Integer> next_;
    
    public Node() {
        this.next_ = new ArrayList<>();
    }
    
    public void ordering(int preOrder){
        if(this.order_ == 0) this.order_ = preOrder;
        else if(this.order_ == preOrder) carry_ = true;
        else if(this.order_ < preOrder){
            this.order_ = preOrder;
            carry_ = false;
        }
    }
    public void setOrder(){
        if(carry_) order_++;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int K,M,P;
    public static int topologySort(Node[] river, int[] di){
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < M; i++) if(di[i]==0) q.offer(i);
        
        for (int i = 0; i < M; i++) {
            int cur = q.poll();
            //노드를 방문하면서 순서 갱신
            river[cur].setOrder();
            
            for (Integer next : river[cur].next_) {
                if(--di[next] == 0) q.add(next);
                river[next].ordering(river[cur].order_);
            }
        }
        
        return river[M-1].order_;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        Node[] river;
        int[] di;
        
        while(test-- != 0) {
            K = sc.nextInt();
            M = sc.nextInt();
            P = sc.nextInt();
            di = new int[M];
            river = new Node[M];
            
            for (int i = 0; i < M; i++) river[i] = new Node();
            
            for (int i = 0; i < P; i++) {
                int r1 = sc.nextInt()-1;
                int r2 = sc.nextInt()-1;
                
                //그래프에 Node 클래스를 직접 추가하는 방식으로하면 간선의 개수만큼 인스턴스가 생성됨
                //또한, 같은 번호의 노드라도 여러개의 인스턴스가 생성되어 각각 다른 값을 가질 수도 있음
                river[r1].next_.add(r2);
                di[r2]++; 
           }
            
           System.out.println(K + " " + topologySort(river, di));
        }
    }
    
}
