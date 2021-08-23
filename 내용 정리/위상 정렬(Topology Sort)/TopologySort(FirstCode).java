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
        boolean[] visited = new boolean[N + 1];
        //차수가 0인 노드를 큐에 삽입한다.
        //하나씩 빼면서 연결 된 간선은 제거한다.
        //제거 후 다시 올라가서 반복한다.
        //만약 큐가 비어있는데 차수가 0인 노드가 없다면 사이클이 발생한 것

        for (int i = 1; i <= N; i++) {
            if(indegree[i] == 0) {
                q.add(i);
                visited[i] = true;
            }
        }
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            System.out.println("now = " + now);
            sb.append(now).append(" ");
           
            graph[now].forEach(next -> {indegree[next]--;});  //간선 제거
            graph[now].clear();
            
            for (int i = 1; i <= N; i++) {
                if(!visited[i] && indegree[i] == 0){
                    q.add(i);
                    visited[i] = true;
                }
            }
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
