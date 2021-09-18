/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baekjoon.BOJ4358;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringJoiner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = "";
        Hashtable<String, Integer> hash = new Hashtable<>();
        int entire = 0;
        
        while((name = br.readLine()) != null && !name.isEmpty()){
             if(hash.containsKey(name)) hash.put(name, hash.get(name) + 1);
             else hash.put(name, 1);
             entire++;
        }
        
        StringBuilder result = new StringBuilder();
        LinkedList<String> list = new LinkedList<>();
        
        hash.keySet().forEach(key -> {list.add(key);});
        Collections.sort(list);
        StringJoiner sj;
        
        for (String key : list) {
            sj = new StringJoiner(" ");
            sj.add(key);
            sj.add(String.format("%.4f\n", ((hash.get(key).doubleValue() / entire) * 100)));
            result.append(sj);
        }
        
        
        System.out.println(result);
    }
    
}
