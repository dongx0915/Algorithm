/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _15922;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Point{
    int s;
    int e;

    public Point(int s, int e) {
        this.s = s;
        this.e = e;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static long getLineLength(int n, Point[] point){
        long result = 0;
        long start = point[0].s;
        long end = point[0].e;
        long temp = Math.abs(end - start);
        
        //처음부터 끝까지 하나의 선분으로 이루어진 경우 result에 더해지지않음
        for (int i = 1; i < n; i++) {
            if(point[i].s <= end){      //이어지거나 겹치는 경우
                if(point[i].e > end) end = point[i].e;  //하나의 선분이 포함되지 않는 경우
                temp = Math.abs(end - start);
            }
            else{       //중간에 선이 끊어진 경우
                result += temp;
                start = point[i].s;
                end = point[i].e;
                temp = Math.abs(end - start);
            }
        }
        
        result += temp;
        return result;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] point = new Point[n];
        
        for (int i = 0; i < n; i++) {
            point[i] = new Point(sc.nextInt(), sc.nextInt());
        }
        
        System.out.println(getLineLength(n, point));
    }
    
}
