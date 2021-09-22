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
        
        HashMap<String, ArrayList<Integer>> info = new HashMap<>();

        int select = 0;
        String name = "";
        ArrayList<Integer> list; 
        long cost = 0;
        
        while(Q-- != 0){
            st = new StringTokenizer(br.readLine());
            select = Integer.parseInt(st.nextToken());
            //데이터가 존재하면 list 반환 존재하지 않으면 list 생성
            list = info.getOrDefault(name = st.nextToken(), new ArrayList<>());
            
            if(select == 1){
                int k = Integer.parseInt(st.nextToken());
                while(k-- != 0) list.add(Integer.parseInt(st.nextToken()));
                info.put(name, list);
            }
            else{
                int cnt = Integer.parseInt(st.nextToken());
                int size = list.size();
                
                if(cnt < size){ //사려는 개수보다 정보의 개수가 많은 경우
                    Collections.sort(list);
                    for (int i = size-1; i >= size - cnt; i--){
                        cost += list.get(i);
                        list.remove(i);
                    }
                }
                else{ //사려는 개수보다 정보의 개수가 적은 경우
                    for (Integer e : list){
                        cost += e;
                    }
                    list.clear();
                }
                
                info.put(name, list);
            }
        }
        
        System.out.println(cost);
    }
    
}
