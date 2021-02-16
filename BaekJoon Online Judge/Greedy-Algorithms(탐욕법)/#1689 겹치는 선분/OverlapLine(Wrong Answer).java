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
        
        Line target = line[0];
        Line now = line[0];
        int end_range = now.e;
        
        for (int i = 1; i < n; i++) {
            Line next = line[i];

            if(next.s < now.e && next.s < end_range){
                cnt++;
                end_range = Math.min(end_range, next.e);
            }
            else{
                max = Math.max(max, cnt);
                end_range = next.e;
                if(next.s < target.e) cnt = 2; //타겟에 포함되면 2 
                else{
                    cnt = 1;
                    target = next;
                }                  //아니면 1
            }
            //타겟에 포함되지 않는 경우 (타겟 갱신)
            now = next;
        }
        
        return Math.max(max, cnt);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Line[] line = new Line[n];
        
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            if(start > end){
                int temp = start;
                start = end;
                end = temp;
            }
            
            line[i] = new Line(start, end);
        }
        
        Arrays.sort(line);
        System.out.println(getMaxOverlap(n, line));
    }
}
