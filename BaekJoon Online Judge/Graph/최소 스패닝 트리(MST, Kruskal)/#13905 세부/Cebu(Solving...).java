/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MST.BOJ13905;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Bridge implements Comparable<Bridge>{
    int[] home_ = new int[2];
    int weight_;

    public Bridge(int h1, int h2, int w) {
        this.home_[0] = h1;
        this.home_[1] = h2;
        this.weight_ = w;
    }
    
    @Override
    public int compareTo(Bridge b){
        return b.weight_ - this.weight_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int n;       //집의 수       - vortex
    public static int m;       //다리의 수     - edge
    public static int s;       //숭이의 위치   - start
    public static int h;       //혜빈이의 위치 - end
    
    public static int getParent(int x, int[] parent){
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent[x], parent);
    }
    
    public static void unionParent(int x, int y, int[] parent){
        x = getParent(x, parent);
        y = getParent(y, parent);
        
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
    
    public static boolean isInGroup(int x, int y, int[] parent){
        x = getParent(x, parent);
        y = getParent(y, parent);
        
        return x == y;
    }
    
    public static int takeablePepero(ArrayList<Bridge> bridge, int[] parent){
        int pepero = Integer.MAX_VALUE;
        
        for (Bridge b : bridge) {
            if(isInGroup(b.home_[0], b.home_[1], parent)) continue;
            
            System.out.printf("[%d %d] 연결 w = %d\n", b.home_[0], b.home_[1], b.weight_);
            unionParent(b.home_[0], b.home_[1], parent);
            pepero = Math.min(pepero, b.weight_);
        }
        
        return pepero;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        s = sc.nextInt();
        h = sc.nextInt();
        //시작지점과 도착지점을 고려해야함
        
        int[] parent = new int[n + 1];
        ArrayList<Bridge> bridge = new ArrayList<>();
        
        for (int i = 0; i < n + 1; i++) parent[i] = i;
        for (int i = 0; i < m; i++) bridge.add(new Bridge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        
        Collections.sort(bridge);
        System.out.println(takeablePepero(bridge, parent));
    }
}
