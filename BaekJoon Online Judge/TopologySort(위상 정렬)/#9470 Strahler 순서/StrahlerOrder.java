/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TopologySort.BOJ9470;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Donghyeon <20183188>
 */
class Node{
    int order_ = 0;
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
        
        for (int i = 0; i < M; i++){
            if(di[i]==0) {
                q.offer(i);
                river[i].order_ = 1;
            }
        }
        
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
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int test = Integer.parseInt(br.readLine());
        Node[] river;
        int[] di;
        
        while(test-- != 0) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            di = new int[M];
            river = new Node[M];
            
            for (int i = 0; i < M; i++) river[i] = new Node();
            
            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int r1 = Integer.parseInt(st.nextToken())-1;
                int r2 = Integer.parseInt(st.nextToken())-1;
                
                //그래프에 Node 클래스를 직접 추가하는 방식으로하면 간선의 개수만큼 인스턴스가 생성됨
                //또한, 같은 번호의 노드라도 여러개의 인스턴스가 생성되어 각각 다른 값을 가질 수도 있음
                river[r1].next_.add(r2);
                di[r2]++; 
           }
            
           bw.write(K + " " + topologySort(river, di));
           bw.write("\n");
        }
        bw.flush();
    }
    
}
