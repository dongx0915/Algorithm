/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TopologySort.BOJ14567;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    //96,139,78
    
    
    public static int[] topologySort(int N, ArrayList<Integer>[] object, int[] indegree){
        Queue<Integer> q = new LinkedList<>();
        int[] tpOrder = new int[N];
        Arrays.fill(tpOrder, 1);
        
        for (int i = 0; i < N; i++) if(indegree[i] == 0) q.add(i);
        
        
        for (int i = 0; i < N; i++) {
            if(q.isEmpty()) break;
            int now = q.poll();
            
            object[now].stream().map(next -> {
                if(--indegree[next] == 0) q.add(next);
                return next;
            }).forEachOrdered(next -> {
                tpOrder[next] = Math.max(tpOrder[now]+1, tpOrder[next]);
            });
          /*
            for (Integer next : object[now]) {
                if(--indegree[next] == 0) q.add(next);
                tpOrder[next] = Math.max(tpOrder[now]+1, tpOrder[next]);
            }
          */
        }
        
        return tpOrder;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();       //과목의 수
        int M = sc.nextInt();       //선수 조건의 수(먼저 들어야하는 과목 조건)
        ArrayList<Integer>[] object = new ArrayList[N];
        int[] indegree = new int[N];
        
        for (int i = 0; i < N; i++) object[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int o1 = sc.nextInt() - 1;
            int o2 = sc.nextInt() - 1;
            object[o1].add(o2);
            indegree[o2]++;
        }

        for (int i : topologySort(N, object, indegree)) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
}
