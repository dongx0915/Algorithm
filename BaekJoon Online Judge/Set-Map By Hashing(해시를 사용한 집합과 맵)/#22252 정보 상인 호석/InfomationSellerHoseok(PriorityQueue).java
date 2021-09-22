/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.BOJ22252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int Q = Integer.parseInt(br.readLine());
        
        HashMap<String, PriorityQueue<Integer>> info = new HashMap<>();

        int select = 0;
        String name = "";
        PriorityQueue<Integer> pq; 
        long cost = 0;
        
        while(Q-- != 0){
            st = new StringTokenizer(br.readLine());
            select = Integer.parseInt(st.nextToken());
            //데이터가 존재하면 list 반환 존재하지 않으면 list 생성
            pq = info.getOrDefault(name = st.nextToken(), new PriorityQueue<>(Collections.reverseOrder()));
            
            if(select == 1){
                int k = Integer.parseInt(st.nextToken());
                while(k-- != 0) pq.add(Integer.parseInt(st.nextToken()));
                info.put(name, pq);
            }
            else{
                int cnt = Integer.parseInt(st.nextToken());
                int size = pq.size();
                
                if(cnt < size) while(cnt-- != 0) cost += pq.poll(); //사려는 개수보다 정보의 개수가 많은 경우
                else while(!pq.isEmpty()) cost += pq.poll();        //사려는 개수보다 정보의 개수가 적은 경우
                
                info.put(name, pq);
            }
        }
        
        System.out.println(cost);
    }
    
}
