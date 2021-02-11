/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.Baekjoon2212;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Section implements Comparable<Section>{
    int value;
    int rank = 1;
    int index;
    public Section(int value, int index) {
        this.value = value;
        this.index = index;
    }
    
    @Override
    public int compareTo(Section o){
        return this.rank - o.rank;
    }
}
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static int getReceiveableArea(int n, int k, int[] sensor){
        int result = 0;
        Section[] section = new Section[n - 1];
        int[] max_index = new int[k - 1];
        
        for (int i = 0; i < n - 1; i++) {
            section[i] = new Section(sensor[i + 1] - sensor[i], i + 1); 
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if(section[i].value < section[j].value) section[i].rank++;
            }
        }
        
        for (Section section1 : section) {
            System.out.print(section1.rank + " ");
        }
        Arrays.sort(section);
        System.out.println("");
        
        for (Section section1 : section) {
            System.out.println(section1.rank + " " + section1.index);
        }
        System.out.println("");
        return result;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] sensor = new int[n];
        
        for (int i = 0; i < n; i++) {
            sensor[i] = sc.nextInt();
        }
        
        Arrays.sort(sensor);
        
        System.out.println(getReceiveableArea(n, k, sensor));
    }
    
}
