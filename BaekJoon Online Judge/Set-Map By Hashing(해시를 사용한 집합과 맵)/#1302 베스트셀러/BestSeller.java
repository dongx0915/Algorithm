/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.BOJ1302;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> hash = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String book = sc.next();
            if(hash.containsKey(book)) hash.replace(book, hash.get(book) + 1);
            else hash.put(book, 0);
        }
        
        ArrayList<String> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : hash.entrySet()) max = Math.max(max, entry.getValue());
        for (Map.Entry<String, Integer> entry : hash.entrySet()) if(entry.getValue() == max) result.add(entry.getKey());
        
        Collections.sort(result);
        System.out.println(result.get(0));
    }
    
}
