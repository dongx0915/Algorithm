/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class2.BOJ14630;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Point implements Comparable<Point>{
    int x_,y_;

    public Point(int x_, int y_) {
        this.x_ = x_;
        this.y_ = y_;
    }
    
    @Override
    public int compareTo(Point p){
        if(this.y_ == p.y_) return this.x_ - p.x_;
        return this.y_ - p.y_;
    }
    
    @Override
    public String toString(){
        return this.x_ + " " + this.y_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Point[] p = new Point[N];
        
        for (int i = 0; i < N; i++) p[i] = new Point(sc.nextInt(), sc.nextInt());
        Arrays.sort(p);
        
        for (Point point : p) System.out.println(point);
    }
    
}
