/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy.Baekjoon1689;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Line implements Comparable<Line>{ 
    int s;
    int e;

    public Line(int s, int e) {
        this.s = s;
        this.e = e;
    }
    
    @Override
    public int compareTo(Line o){
        if(this.s == o.s) return o.e - this.e;
        else return this.s - o.s;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static int getMaxOverlap(int n, Line[] line){
        int max = 0;
        int cnt = 1;
        Line now = line[0];
        boolean flag = false;
        
        for (int i = 1; i < n; i++) {
            Line next = line[i];
            if(now.s <= next.s && now.e >= next.e) {
                cnt++;
                flag = true;
            }
            else{
                max = Math.max(max, cnt);
                cnt = 1;
                now = line[i];
            }
        }
        
        if(!flag) return 0;
        return Math.max(max, cnt);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Line[] line = new Line[n];
        
        for (int i = 0; i < n; i++) {
            line[i] = new Line(sc.nextInt(), sc.nextInt());
        }
        
        Arrays.sort(line);
        
//        for (Line line1 : line) {
//            System.out.println(line1.s + " " + line1.e);
//        }
        
        System.out.println(getMaxOverlap(n, line));
    }
    
}
