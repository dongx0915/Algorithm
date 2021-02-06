/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.Baekjoon1339;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class ReverseComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer n1, Integer n2){
        return (n1 < n2) ? 1 : ((Objects.equals(n1, n2)) ? 0 : -1);
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int getMaxResult_save(int n, String[] words, int[] value){
        int result = 0;
        int num = 9;
        for (String word : words) {
            int length = word.length();
            int convert_num = 0;
            for (int i = 0; i < length; i++) {
                char alpha = word.charAt(i);
                if(value[alpha - 'A'] == -1){
                    value[alpha - 'A'] = num;
                    num--;
                }
                
                convert_num = (convert_num * 10) + value[alpha - 'A'];
            }
            result += convert_num;
            System.out.println(convert_num);
        }
        return result;
    }
    
    public static int getMaxResult(int n, String[] words, Integer[] value){
        int result = 0;
        int num = 9;
        int[] sum = new int[n];
        ReverseComparator rsc = new ReverseComparator();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < n; j++) {
                if(words[j].charAt(i) == ' ') continue;
                //System.out.println(Math.pow(10, 7 - i));
                value[words[j].charAt(i) - 'A'] += (int)Math.pow(10, 7 - i);
            }
        }


        Arrays.sort(value, rsc);
        
        for (Integer i : value) {
            if(i == 0) break;
            result += (i * num--);
        }
        return result;
    }
        
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] value = new Integer[26 + 1];
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = String.format("%8s", sc.next());
        }
        Arrays.fill(value, 0);
        System.out.println(getMaxResult(n, words, value));
    }
}
