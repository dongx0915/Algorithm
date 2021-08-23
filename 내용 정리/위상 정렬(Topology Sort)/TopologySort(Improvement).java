/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TopologySort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Donghyeon <20183188>
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<Integer>[] graph;
    public static int[] indegree;
    
    public static String topologySort(int N){
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        /* 
        * 차수가 0인 노드를 큐에 삽입한다.
        * 하나씩 빼면서 연결 된 간선은 제거한다.
        * 제거 후 다시 올라가서 반복한다.
        * 만약 큐가 비어있는데 차수가 0인 노드가 없다면 사이클이 발생한 것
        */

        for (int i = 1; i <= N; i++) if(indegree[i] == 0) q.add(i);
        
        /*
        * 위상 정렬이 제대로 완료 되려면 모든 노드를 한 번씩 방문해야함
        * 방문을 하면서 Queue에서 Pop을 하므로 총 N번만큼만 Pop을 하게됨
        * N번만큼 Pop을 하기 전에 Queue가 비어버린다면 사이클이 발생한 경우로 정렬 불가
        */
        for (int i = 1; i <= N; i++) { 
            if(q.isEmpty()) return "사이클 발생";
            int now = q.poll();
            
            sb.append(now).append(" ");
           
            graph[now].forEach(next -> { if(--indegree[next] == 0) q.add(next);});  //간선 제거(현재 노드와 연결된 간선을 제거했을 때 연결된 노드의 진입차수가 0이 되면 삽입)
            //굳이 graph[now].clear()를 해줄 필요가 없음(indegree로 연결 된 노드의 개수만 세면 되기 때문)
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int N = 7;
        graph = new ArrayList[N + 1];
        indegree = new int[N + 1];
        
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        
        graph[1].add(2);
        indegree[2]++;
        graph[1].add(5);
        indegree[5]++;
        
        graph[2].add(3);
        indegree[3]++;
        
        graph[3].add(4);
        indegree[4]++;
        
        graph[4].add(6);
        indegree[6]++;
        
        graph[5].add(6);
        indegree[6]++;
        
        graph[6].add(7);
        indegree[7]++;
        
        System.out.println(topologySort(N));
    }
    
}
