/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> str = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            if(!str.contains(input)) str.add(input);
        }
        
        Collections.sort(str, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length() == s2.length()) return s1.compareTo(s2);
                return s1.length() > s2.length() ? 1 : -1;
            }
        });
        
        str.forEach(string -> {System.out.println(string);});
    }
    
}
